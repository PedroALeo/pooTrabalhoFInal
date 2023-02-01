package Model;

import java.util.Date;

public class Gerente extends Funciorario{

    private static double percentege = 0.15;

    public Gerente(String CPF, String nome, String endereçoCompleto, String estadoCivil, String dataDeNascimento, String numeroCarteiraDeTrabalho, String RG, String sexo, String cargoNaEmpresa, double salario, String anoDeIngresso) {
        super(CPF, nome, endereçoCompleto, estadoCivil, dataDeNascimento, numeroCarteiraDeTrabalho, RG, sexo, cargoNaEmpresa, salario, anoDeIngresso);
    }

    @Override
    public double CalcularSalario() {
        return (super.CalcularSalario() + super.CalcularSalario() * percentege);
    }
}
