package handlers;

import Model.Agencia;
import Model.Funciorario;
import Model.Gerente;

import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class GerenteHandler {

    private static Scanner sc= new Scanner(System.in);

    public static void CriarGerenteInterface(Set<Agencia> Agencias, Set<Funciorario> funcionarios){
        System.out.println("Criando um novo gerente:");
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
        System.out.print("Numero da agencia: ");
        int agenciaNum = sc.nextInt();
        Gerente f = new Gerente(cpf,nome,Endereço,estadocivil,datadenascimento,trab,RG,sexo,cargo,salario,ano);

        List<Agencia>l = Agencias.stream().toList();
        for(int i = 0; i < l.size(); i++){
            if(l.get(i).getNumero() == agenciaNum){
                l.get(i).setGerente(f);
                funcionarios.add(f);
            }
        }



    }
}