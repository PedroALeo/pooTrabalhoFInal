package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Agencia implements Serializable {

    private int numero;
    private String nome;

    @Override
    public String toString() {
        return "Agencia{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", Endereço=" + Endereço +
                ", gerente=" + gerente +
                ", contas=" + contas +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agencia)) return false;
        Agencia that = (Agencia) o;
        return getNumero() == that.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    private Endereco Endereço;
    private Gerente gerente;

    private Set<Conta> contas = new HashSet<>();

    public Set<Conta> getContas() {
        return contas;
    }

    public Agencia(int numero, String nome, Endereco endereço) {
        this.numero = numero;
        this.nome = nome;
        Endereço = endereço;

    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereço() {
        return Endereço;
    }

    public void setEndereço(Endereco endereço) {
        Endereço = endereço;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
