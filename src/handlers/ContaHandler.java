package handlers;

import Model.*;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ContaHandler {



    private static Scanner sc = new Scanner(System.in);

    public static void CriarContaInterface(Set<Agencia> agencias, Set<Cliente> clientes) {
        System.out.println("Criar Conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Salario");
        System.out.println("3 - Poupanca");
        System.out.print("Escolha o tipo de conta a ser inserido:");
        int op = sc.nextInt();
        if (op == 1) {
            CriarContaCorrente(agencias, clientes);
        }

        if (op == 2) {
            CriarContaSalario(agencias, clientes);
        }

        if (op == 3) {
            CriarContaPoupanca(agencias, clientes);
        }

    }

    public static void CriarContaCorrente(Set<Agencia> agencias, Set<Cliente> clientes) {
        sc.nextLine();
        System.out.println("Criando nova conta corrente:");
        System.out.print("Insira CPF do cliente:");
        String CPF = sc.nextLine();
        List<Cliente> c = clientes.stream().toList();
        int clienteIndex = -1;

        for(int i = 0; i < c.size(); i++) {
            if (CPF.equals(((Cliente)c.get(i)).getCPF())) {
                clienteIndex = i;
            }
        }

        List<Agencia> a = agencias.stream().toList();

        System.out.print("Insira o numero da agencia:");
        int AgenciaNum = sc.nextInt();

        int agenciaIndex = -1;
        for(int i = 0; i < a.size(); i++){
            if(AgenciaNum == a.get(i).getNumero()){
                agenciaIndex = i;
            }
        }

        System.out.print("Insira a senha: ");
        String senha = sc.next();
        System.out.println("Limite do cheque especial:");
        Double limite = sc.nextDouble();
        System.out.println("Taxa administrativa:");
        Double taxaAdm = sc.nextDouble();

        if(agenciaIndex < 0 || clienteIndex < 0){
            return;
        }else{
            ContaCorrente conta = new ContaCorrente(senha,a.get(agenciaIndex), limite, taxaAdm);
            a.get(agenciaIndex).getContas().add(conta);
            c.get(clienteIndex).getContas().add(conta);
        }
    }

    public static void CriarContaSalario(Set<Agencia> agencias, Set<Cliente> clientes) {
        sc.nextLine();
        System.out.println("Criando nova conta corrente:");
        System.out.print("Insira CPF do cliente:");
        String CPF = sc.nextLine();
        List<Cliente> c = clientes.stream().toList();
        int clienteIndex = -1;

        for(int i = 0; i < c.size(); i++) {
            if (CPF.equals(((Cliente)c.get(i)).getCPF())) {
                clienteIndex = i;
            }
        }

        List<Agencia> a = agencias.stream().toList();

        System.out.print("Insira o numero da agencia:");
        int AgenciaNum = sc.nextInt();

        int agenciaIndex = -1;
        for(int i = 0; i < a.size(); i++){
            if(AgenciaNum == a.get(i).getNumero()){
                agenciaIndex = i;
            }
        }

        System.out.print("Insira a senha: ");
        String senha = sc.next();
        System.out.print("Limite do Saque");
        Double limiteSaque = sc.nextDouble();
        System.out.print("Limite de Transferencia:");
        Double LimiteTransferencia = sc.nextDouble();

        if(agenciaIndex < 0 || clienteIndex < 0){
            return;
        }else{
            ContaSalario conta = new ContaSalario(senha,a.get(agenciaIndex), limiteSaque, LimiteTransferencia);
            a.get(agenciaIndex).getContas().add(conta);
            c.get(clienteIndex).getContas().add(conta);
        }
    }

    public static void CriarContaPoupanca(Set<Agencia> agencias, Set<Cliente> clientes) {
        sc.nextLine();
        System.out.println("Criando nova conta corrente:");
        System.out.print("Insira CPF do cliente:");
        String CPF = sc.nextLine();
        List<Cliente> c = clientes.stream().toList();
        int clienteIndex = -1;

        for(int i = 0; i < c.size(); i++) {
            if (CPF.equals(((Cliente)c.get(i)).getCPF())) {
                clienteIndex = i;
            }
        }

        List<Agencia> a = agencias.stream().toList();

        System.out.print("Insira o numero da agencia:");
        int AgenciaNum = sc.nextInt();

        int agenciaIndex = -1;
        for(int i = 0; i < a.size(); i++){
            if(AgenciaNum == a.get(i).getNumero()){
                agenciaIndex = i;
            }
        }

        System.out.print("Insira a senha: ");
        String senha = sc.next();

        if(agenciaIndex < 0 || clienteIndex < 0){
            return;
        }else{
            ContaPoupanca conta = new ContaPoupanca(senha,a.get(agenciaIndex));
            a.get(agenciaIndex).getContas().add(conta);
            c.get(clienteIndex).getContas().add(conta);
        }
    }


    public static String[] AuthConta(){
        Scanner authenticator = new Scanner(System.in);
        String []r = new String[2];
        System.out.println("Autenticando em sua Conta");
        System.out.print("Numero: ");
        r[0] = authenticator.nextLine();
        System.out.print("Senha: ");
        r[1] = authenticator.nextLine();
        return r;
    }




}
