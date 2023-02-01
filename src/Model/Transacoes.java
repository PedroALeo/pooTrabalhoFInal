package Model;

import Enuns.Canal;
import Enuns.TipoTransacao;

import java.io.Serializable;
import java.util.Date;

public class Transacoes implements Serializable {

    private Canal CanalDaTransação;
    private Double Valor;
    private Date date;
    private TipoTransacao tipo;
    private Conta conta;

    public Transacoes(Canal canalDaTransação, Double valor) {
        CanalDaTransação = canalDaTransação;
        Valor = valor;
        this.date = new Date();
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Canal getCanalDaTransação() {
        return CanalDaTransação;
    }

    public Double getValor() {
        return Valor;
    }

    public Date getDate() {
        return date;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public Conta getConta() {
        return conta;
    }
}
