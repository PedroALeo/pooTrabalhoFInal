package Model;

import Util.IoUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Funciorario extends Pessoa implements Serializable {

    private String NumeroCarteiraDeTrabalho;
    private String RG;
    private String sexo;
    private String CargoNaEmpresa;
    private double Salario;
    private Date AnoDeIngresso;




    public Funciorario(String CPF, String nome, String endereçoCompleto, String estadoCivil, String dataDeNascimento, String numeroCarteiraDeTrabalho, String RG, String sexo, String cargoNaEmpresa, double salario, String anoDeIngresso) {
        super(CPF, nome, endereçoCompleto, estadoCivil, dataDeNascimento);
        NumeroCarteiraDeTrabalho = numeroCarteiraDeTrabalho;
        this.RG = RG;
        this.sexo = sexo;
        CargoNaEmpresa = cargoNaEmpresa;
        Salario = salario;
        SetAnodeIngresso(anoDeIngresso);
    }

    public void SetAnodeIngresso(String data){
        try {
            this.AnoDeIngresso = IoUtil.StringToDate(data.trim());
        }catch (ParseException ex){
            System.out.println("ERRO AO Transformar string em data");
        }


    }

    public double CalcularSalario(){
        int TempoDeEmpresa = Period.between( AnoDeIngresso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
        if(TempoDeEmpresa > 15){
            return this.Salario + (this.Salario * 0.10);
        }
        return this.Salario;

    }

    @Override
    public String toString() {
        return "Funciorario{" +
                "NumeroCarteiraDeTrabalho='" + NumeroCarteiraDeTrabalho + '\'' +
                ", RG='" + RG + '\'' +
                ", sexo='" + sexo + '\'' +
                ", CargoNaEmpresa='" + CargoNaEmpresa + '\'' +
                ", Salario=" + Salario +
                ", AnoDeIngresso=" + AnoDeIngresso +
                "} " + super.toString();
    }

    public String getNumeroCarteiraDeTrabalho() {
        return NumeroCarteiraDeTrabalho;
    }

    public void setNumeroCarteiraDeTrabalho(String numeroCarteiraDeTrabalho) {
        NumeroCarteiraDeTrabalho = numeroCarteiraDeTrabalho;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargoNaEmpresa() {
        return CargoNaEmpresa;
    }

    public void setCargoNaEmpresa(String cargoNaEmpresa) {
        CargoNaEmpresa = cargoNaEmpresa;
    }



    public void setSalario(double salario) {
        Salario = salario;
    }

    public Date getAnoDeIngresso() {
        return AnoDeIngresso;
    }

}
