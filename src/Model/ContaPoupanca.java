package Model;

import Enuns.TipoTransacao;
import Exceptions.IncorrectPasswordException;
import Exceptions.IsAtivaException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ContaPoupanca extends Conta implements Serializable {

    private double RendimentoDoMesAtual;

    public ContaPoupanca(String senha, Agencia agencia) {
        super(senha,  agencia);
        RendimentoDoMesAtual = 0;
    }

    public boolean Saque(String senha,Transacoes t) {
        if(t.getValor() <= 0)
            return false;
        if(!super.isAtiva())
            return false;
        if(!super.IsValidPassword(senha))
            return false;
        if(this.getSaldo() < t.getValor())
            return false;

        this.setSaldo(getSaldo()-t.getValor());
        t.setTipo(TipoTransacao.SAQUE);
        return true;
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

        this.setSaldo(this.getSaldo()-transacoes.getValor());
        transacoes.setTipo(TipoTransacao.EFETUARPAGAMENTO);
        return true;
    }

    public double getRendimentoDoMesAtual() {
        return RendimentoDoMesAtual;
    }

    public void setRendimentoDoMesAtual(double rendimentoDoMesAtual) {
        Date today = new Date();
        if( today.getDay() == 1)
            rendimentoDoMesAtual = 0;
        setSaldo(getSaldo()+getSaldo()*(0.01/30));
        RendimentoDoMesAtual = rendimentoDoMesAtual + getSaldo()*(0.01/30);
    }
}
