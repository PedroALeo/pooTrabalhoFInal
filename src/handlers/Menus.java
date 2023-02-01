package handlers;

import java.util.Scanner;

public class Menus {

    private static Scanner sc = new Scanner(System.in);

    public static int MenuInicial(){
        int x;
        while(true){
            System.out.println("Escolha uma opcao: ");
            System.out.println("1 - Banco ");
            System.out.println("2 - Cliente ");
            System.out.println("0 - Sair");
            System.out.print("Sua escolha: ");
             x = sc.nextInt();
            if(x == 0) {
                break;
            };
            if(x == 2 || x == 1){
               return x;
            }else{
                System.out.println("\nValor Invalido\n");
            }

        }

        return x;
    }


    public static int BancoMenu() {
        int x;
        while(true){
            System.out.println("Escolha uma opcao como Banco: ");
            System.out.println("1 - Criar Cliente ");
            System.out.println("2 - Criar Agencia ");
            System.out.println("3 - Criar Funcionario ");
            System.out.println("4 - Criar Gerente ");
            System.out.println("5 - Criar Conta ");
            System.out.println("6 - Calcular Salario Funcionarios ");
            System.out.println("9 - Voltar");
            System.out.print("Sua escolha: ");
            x = sc.nextInt();
            if(x == 0) {
                break;
            };
            if(x >= 1 && x <= 6 || x == 9 ){
                return x;
            }else{
                System.out.println("\nValor Invalido\n");
            }

        }

        return x;
    }


}
