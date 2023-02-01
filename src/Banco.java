import Model.Agencia;
import Model.Cliente;
import Model.Funciorario;
import Util.StreamIoUtil;
import handlers.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

public class Banco {


   private static Set<Cliente> clientes = new HashSet<>();
   private static Set<Agencia> Agencias = new HashSet<>();
   private static Set<Funciorario> funcionarios = new HashSet<>();



    public static void setClientes() {


        try {
            clientes = (Set<Cliente>) StreamIoUtil.ReadOne("src/Data/Cliente.txt");
        }catch (RuntimeException ex){
            System.out.println("Cliente não foi carregado");
        }


    }

    public static void setAgencias() {
        try {
            Agencias = (Set<Agencia>) StreamIoUtil.ReadOne("src/Data/Agencia.txt");
        }catch (RuntimeException ex){
            System.out.println("Agencia não foi carregado");
        }


    }

    public static void setFuncionarios() {
        try {
            Banco.funcionarios = (Set<Funciorario>) StreamIoUtil.ReadOne("src/Data/Funciorario.txt");
        }catch (RuntimeException ex){
            System.out.println("Funcionario não foi carregado");
        }


    }

    public static void main(String[] args) throws ParseException {
        setClientes();
        setAgencias();
        setFuncionarios();
        while(true){
            int Escolha =  Menus.MenuInicial();
            if(Escolha == 1){
                int Result =  Menus.BancoMenu();
                switch (Result){
                    case(1):
                        ClienteHandler.CriarClienteInterface(clientes);
                        break;
                    case(2):
                        AgenciaHandler.CriarAgenciaInterface(Agencias);
                        break;
                    case(3):
                        FuncionarioHandler.CriarFuncionarioInterface(funcionarios);
                        break;
                    case(4):
                        GerenteHandler.CriarGerenteInterface(Agencias,funcionarios);
                        break;
                    case(5):
                        ContaHandler.CriarContaInterface(Agencias,clientes);
                        break;
                    case(6):
                        FuncionarioHandler.CalcularSarioInterface(funcionarios);
                        break;

                    case(9):  continue;
                }

            }

            if(Escolha == 2){
                ClienteHandler.ClienteMenu(clientes);
            }


            if(Escolha == 0) break;



        }


        StreamIoUtil.WriteOne((Serializable) clientes);
        StreamIoUtil.WriteOne((Serializable) Agencias);
        StreamIoUtil.WriteOne((Serializable) funcionarios);




    }





}
