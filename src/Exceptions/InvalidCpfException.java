package Exceptions;

public class InvalidCpfException extends RuntimeException{

    public InvalidCpfException() {
        super("CPF INVALIDO");
    }
}
