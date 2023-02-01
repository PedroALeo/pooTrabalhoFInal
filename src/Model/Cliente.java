package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa  {

    private List<Conta> contas;

    public Cliente(String CPF, String nome, String endereçoCompleto, String estadoCivil, String  dataDeNascimento) {
        super(CPF, nome, endereçoCompleto, estadoCivil, dataDeNascimento);
        this.contas = new ArrayList<>();
    }



    public Cliente(String CPF, String nome) {
        super(CPF, nome);
    }

    public Cliente() {
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Agencia> GetAllAgencias(){
        return contas.stream().map(e -> e.getAgencia()).toList();
    }
    //Agencia vai sair daqui ??????


}
