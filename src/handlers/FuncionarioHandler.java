package handlers;

import Model.Funciorario;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;

public class FuncionarioHandler {




    public static void CalcularSarioInterface(Set<Funciorario> func){
        Scanner sc= new Scanner(System.in);
        System.out.println("Calcular Salario dos funcionarios\n");
        System.out.println("Informe o cpf do funcionario que você deseja calcular o salario");
        System.out.printf("CPF: ");
        String cpf = sc.nextLine();
        func.stream().filter(e -> cpf.equalsIgnoreCase(e.getCPF())).forEach(e -> {
            System.out.printf("O salario do %s é %.2f reais\n", e.getNome(), e.CalcularSalario());
        });




    }

//70174735669

    public static void CriarFuncionarioInterface(Set<Funciorario> func) throws ParseException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Criando um funcionario: \n");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("nome: ");
        String nome = sc.nextLine();
        System.out.print("Endereco:  ");
        String Endereço = sc.nextLine();
        System.out.print("Estado Civil: ");
        String estadocivil = sc.nextLine();
        System.out.print("Data de nascimento: ");
        String datadenascimento = sc.nextLine();
        System.out.printf("Carteira de trabalho: ");
        String trab = sc.nextLine();
        System.out.printf("RG: ");
        String RG = sc.nextLine();
        System.out.printf("Cargo na empresa: ");
        String cargo = sc.nextLine();
        System.out.printf("Sexo: ");
        String sexo = sc.nextLine();
        System.out.printf("Ano de ingresso: ");
        String ano = sc.nextLine();
        System.out.printf("Salario: ");
        double salario = sc.nextDouble();

        Funciorario f = new Funciorario(cpf,nome,Endereço,estadocivil,datadenascimento,trab,RG,sexo,cargo,salario,ano);
        func.add(f);



    }
}
