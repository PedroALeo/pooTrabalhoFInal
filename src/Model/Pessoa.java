package Model;



import Exceptions.InvalidCpfException;
import Util.IoUtil;
import Util.Validations;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class  Pessoa implements Serializable {

    private String CPF;
    private String Nome;
    private Endereco EndereçoCompleto;
    private String EstadoCivil;
    private Date DataDeNascimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa that = (Pessoa) o;
        return getCPF().equals(that.getCPF());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCPF());
    }

    public Pessoa(String CPF, String nome, String endereçoCompleto, String estadoCivil, String dataDeNascimento) {
        setCPF(CPF);
        Nome = nome;
        EstadoCivil = estadoCivil;
        SetDataDeNascimento(dataDeNascimento);
        setEndereço(endereçoCompleto);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "CPF='" + CPF + '\'' +
                ", Nome='" + Nome + '\'' +
                ", EndereçoCompleto=" + EndereçoCompleto +
                ", EstadoCivil='" + EstadoCivil + '\'' +
                ", DataDeNascimento=" + DataDeNascimento +
                '}';
    }

    public Pessoa() {
    }

    public void SetDataDeNascimento(String data){
        try {
            this.DataDeNascimento = IoUtil.StringToDate(data);
        }catch (ParseException ex){
            System.out.println("ERRO AO Transformar string em data");
        }


    }

    public void setEndereço(String endereço){
        List<String> endereçodata = Arrays.stream(endereço.split(";")).toList(  );
        if(endereçodata.size() == 4){
            Endereco end = new Endereco(Integer.parseInt(endereçodata.get(0)), endereçodata.get(1), endereçodata.get(2), endereçodata.get(3));
            this.EndereçoCompleto = end;
        }else{
            Endereco end = new Endereco(Integer.parseInt(endereçodata.get(0)), endereçodata.get(1), endereçodata.get(2), endereçodata.get(3), endereçodata.get(4));
            this.EndereçoCompleto = end;
        }

    }


    public Pessoa(String CPF, String nome) {
        setCPF(CPF);
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if(Validations.isCpf(CPF)){
            this.CPF = CPF;
            return;
        }

        throw new InvalidCpfException();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Endereco getEndereçoCompleto() {
        return EndereçoCompleto;
    }

    public void setEndereçoCompleto(Endereco endereçoCompleto) {
        EndereçoCompleto = endereçoCompleto;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        EstadoCivil = estadoCivil;
    }

    public Date getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }
}
