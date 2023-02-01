package Model;

import Enuns.TipoTransacao;
import Exceptions.IncorrectPasswordException;
import Exceptions.IsAtivaException;

import java.io.Serializable;
import java.util.Date;

public class ContaCorrente extends Conta implements Serializable {

    private double LimiteDoCheque;
    private double taxaAdministrativa;

    public ContaCorrente(String senha, Agencia agencia, double limiteDoCheque, double taxaAdministrativa) {
        super(senha, agencia);
        LimiteDoCheque = limiteDoCheque;
        this.taxaAdministrativa = taxaAdministrativa;
    }

    public double getLimiteDoCheque() {
        return LimiteDoCheque;
    }

    public void setLimiteDoCheque(double limiteDoCheque) {
        LimiteDoCheque = limiteDoCheque;
    }

    public double getTaxaAdministrativa() {
        return taxaAdministrativa;
    }

    public void setTaxaAdministrativa(double taxaAdministrativa) {
        this.taxaAdministrativa = taxaAdministrativa;
    }

    @Override
    public boolean Saque(String senha,Transacoes t) {
        if(t.getValor() <= 0)
            return false;
        if(!super.isAtiva())
            return false;
        if(!super.IsValidPassword(senha))
            return false;
        if(t.getValor() > getSaldo()+getLimiteDoCheque()) {
            return false;
        } else {
                setSaldo(getSaldo()-t.getValor());
            t.setTipo(TipoTransacao.SAQUE);
            return true;
        }
    }

    @Override
    public boolean deposito(String senha, Transacoes t) {
        if(!super.isAtiva())
            return false;
        if(!super.IsValidPassword(senha))
            return false;
        if(t.getValor() <= 0)
            return false;

        setSaldo(getSaldo()+t.getValor());
        t.setTipo(TipoTransacao.DEPOSITO);
        return true;
    }

    @Override
    public double consultarSaldo(String senha, Transacoes t) {
        if(!isAtiva())
            throw new IsAtivaException();
        if(!IsValidPassword(senha))
            throw new IncorrectPasswordException("Senha Incorreta");
        t.setTipo(TipoTransacao.CONSULTAR);
        return getSaldo();
    }

    @Override
    public boolean efetuarpagamento(String senha, Transacoes transacoes) {
        if(transacoes.getValor() <= 0)
            return false;
        if(!isAtiva())
            return false;
        if(!IsValidPassword(senha))
            return false;
        if(this.getSaldo() < transacoes.getValor())
            return false;

        this.setSaldo(transacoes.getValor());
        transacoes.setTipo(TipoTransacao.EFETUARPAGAMENTO);
        return true;
    }
}
