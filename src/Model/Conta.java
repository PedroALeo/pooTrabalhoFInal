package Model;

import java.io.Serializable;
import java.util.*;

public abstract class Conta implements Serializable {

    private String senha;
    private boolean IsAtiva;
    private int NumeroConta;
    private double saldo;
    protected List<Transacoes> transacoesList = new ArrayList<>();

    private Agencia agencia;


    public Agencia getAgencia() {
        return agencia;
    }

    public abstract boolean Saque(String senha, Transacoes transacoes);
    public abstract boolean deposito(String senha, Transacoes transacoes);
    public abstract double consultarSaldo(String senha, Transacoes transacoes);
    public abstract boolean efetuarpagamento(String senha, Transacoes transacoes);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta that = (Conta) o;
        return IsAtiva == that.IsAtiva && NumeroConta == that.NumeroConta && Double.compare(that.saldo, saldo) == 0 && Objects.equals(senha, that.senha) && Objects.equals(agencia, that.agencia) && Objects.equals(dataDeAbertura, that.dataDeAbertura) && Objects.equals(DataDaUltimaMovimentação, that.DataDaUltimaMovimentação);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senha, IsAtiva, NumeroConta, saldo, agencia, dataDeAbertura, DataDaUltimaMovimentação);
    }

    private Date dataDeAbertura;
    private Date DataDaUltimaMovimentação;


    public Conta(String senha, Agencia agencia) {
        this.senha = senha;
        IsAtiva = true ;
        NumeroConta = (int) Math.floor(Math.random() * 1000000000) ;
        this.saldo = 0;
        this.dataDeAbertura = new Date();
        DataDaUltimaMovimentação = new Date();
        this.agencia = agencia;

    }



    public boolean IsValidPassword(String password){
        return password.equals(senha);
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected String getSenha() {
        return senha;
    }

    protected void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtiva() {
        return IsAtiva;
    }

    public void setAtiva(boolean ativa) {
        IsAtiva = ativa;
    }

    public int getNumeroConta() {
        return NumeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        NumeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Date getDataDaUltimaMovimentação() {
        return DataDaUltimaMovimentação;
    }

    public void setDataDaUltimaMovimentação(Date dataDaUltimaMovimentação) {
        DataDaUltimaMovimentação = dataDaUltimaMovimentação;
    }
}
