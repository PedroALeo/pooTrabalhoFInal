package handlers;

import Enuns.Canal;
import Model.Cliente;
import Model.Conta;
import Model.Transacoes;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ClienteHandler {


    private static Scanner sc = new Scanner(System.in);

    public static void CriarClienteInterface(Set<Cliente> allclitents){
         System.out.println(" Criando um novo cliente ");
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
         Cliente cliente = new Cliente(cpf,nome,Endereço,estadocivil,datadenascimento);
         allclitents.add(cliente);
    }


    public
    static void ClienteMenu(Set<Cliente> allclitents)
    {
        Canal []vet = new Canal[]{Canal.CaixaEletronico,Canal.CaixoFisico,Canal.INTERNETBanking};
        System.out.println("Escolha o canal:");
        System.out.println("0 - Caixa Eletronico");
        System.out.println("1 - Caixa Fisico");
        System.out.println("2 - Internet Banking");
        System.out.print("Escolha a opcao:");
        int CanalIndex = sc.nextInt();

        sc.nextLine(); // <- erro de IO
        System.out.print("Insira o CPF:");
        String CPF = sc.nextLine();
        List<Cliente> c = allclitents.stream().toList();

        for (int i = 0; i < c.size(); i++)
        {
            if (CPF.equals(c.get(i).getCPF()))
            {
                List<Conta> contas = c.get(i).getContas();
                for (int j = 0; j < contas.size(); j++){
                    System.out.println(contas.get(j).getNumeroConta());
                }
                String[] conta = ContaHandler.AuthConta();

                for (int j = 0; j < contas.size(); j++)
                {
                    if (contas.get(j).getNumeroConta() == Integer.parseInt(conta[0]) && contas.get(j).IsValidPassword(conta[1]))
                    {

                        while (true)
                        {
                            System.out.println("1 - Sacar");
                            System.out.println("2 - Depositar");
                            System.out.println("3 - Pagar");
                            System.out.println("4 - Consultar Saldo");
                            System.out.println("5 - Voltar");
                            System.out.print("Escolha sua opcao:");

                            int escolha = sc.nextInt();
                            int saida = 0;

                            switch (escolha)
                            {

                                case (1):
                                    {
                                        double value = sc.nextDouble();
                                        contas.get(j).Saque(conta[1], new Transacoes(vet[CanalIndex],value));
                                        break;
                                    }


                                case (2):
                                    {
                                        double value = sc.nextDouble();
                                        contas.get(j).deposito(conta[1], new Transacoes(vet[CanalIndex],value));
                                        break;
                                    }

                                case (3):
                                {
                                    double value = sc.nextDouble();
                                    contas.get(j).efetuarpagamento(conta[1], new Transacoes(vet[CanalIndex],value));
                                    break;
                                }

                                case (4):
                                {
                                    System.out.println(contas.get(j).consultarSaldo(conta[1], new Transacoes(vet[CanalIndex], 0.0)));
                                    break;
                                }

                                case (5) :
                                    saida = 1;
                            }
                            if(saida == 1){
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


}
