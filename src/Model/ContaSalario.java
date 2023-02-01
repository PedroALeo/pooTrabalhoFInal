package Model;

import Enuns.TipoTransacao;
import Exceptions.IncorrectPasswordException;
import Exceptions.IsAtivaException;

import java.io.Serializable;
import java.util.Date;

public class ContaSalario extends Conta implements Serializable {

    private double limitedesaque;
    private double limiteDeTransferencia;

    public ContaSalario(String senha, Agencia agencia, double limitedesaque, double limiteDeTransferencia) {
        super(senha, agencia);
        this.limitedesaque = limitedesaque;
        this.limiteDeTransferencia = limiteDeTransferencia;
    }

    public double getLimitedesaque() {
        return limitedesaque;
    }

    public void setLimitedesaque(double limitedesaque) {
        this.limitedesaque = limitedesaque;
    }

    public double getLimiteDeTransferencia() {
        return limiteDeTransferencia;
    }

    public void setLimiteDeTransferencia(double limiteDeTransferencia) {
        this.limiteDeTransferencia = limiteDeTransferencia;
    }


    @Override
    public boolean Saque(String senha, Transacoes transacoes) {
        if(IsValidPassword(senha)){
            transacoes.setConta(this);
            transacoes.setTipo(TipoTransacao.SAQUE);
            if(transacoes.getValor() <= limitedesaque && transacoes.getValor() <= getSaldo()){
                this.setSaldo(this.getSaldo() - transacoes.getValor());
                this.transacoesList.add(transacoes);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean deposito(String senha, Transacoes transacoes) {
        if(IsValidPassword(senha) && isAtiva()){
            if(transacoes.getValor() > 0){
                transacoes.setTipo(TipoTransacao.DEPOSITO);
                transacoes.setConta(this);
                this.setSaldo(this.getSaldo() + transacoes.getValor());
                this.transacoesList.add(transacoes);
            }
        }
        return false;
    }

    @Override
    public double consultarSaldo(String senha, Transacoes transacoes) {
        if(IsValidPassword(senha)){
            if(isAtiva()){
                transacoes.setTipo(TipoTransacao.CONSULTAR);
                transacoes.setConta(this);
                this.transacoesList.add(transacoes);
                return this.getSaldo();
            }
            throw new IsAtivaException();
        }
        throw new IncorrectPasswordException("Senha Incorreta");
    }

    @Override
    public boolean efetuarpagamento(String senha, Transacoes transacoes) {
        if(IsValidPassword(senha)){
            transacoes.setConta(this);
            transacoes.setTipo(TipoTransacao.EFETUARPAGAMENTO);
            if(this.isAtiva() && transacoes.getValor() <= limiteDeTransferencia && transacoes.getValor() <= getSaldo()){
                this.setSaldo(this.getSaldo() - transacoes.getValor());
                this.transacoesList.add(transacoes);
                return true;
            }
        }
        return false;
    }
}
