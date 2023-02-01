package handlers;

import Model.Agencia;
import Model.Endereco;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AgenciaHandler {

    private static Scanner sc =new Scanner(System.in);

    public static void CriarAgenciaInterface(Set<Agencia> agencias){
        System.out.println("Criando uma nova agencia:");
        System.out.print("Insira o numero de uma agencia:");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("Insira o nome de agencia:");
        String nome = sc.nextLine();
        System.out.print("Insira o Endereco:");
        String []endereco = sc.nextLine().split(";");
        Endereco ende = new Endereco(Integer.parseInt(endereco[0]),endereco[1],endereco[2],endereco[3]);
        Agencia agencia = new Agencia(num, nome, ende);
        List<Agencia> l = agencias.stream().toList();
        if(l.contains(agencia)){
            return;
        }
        agencias.add(agencia);
    }
}
