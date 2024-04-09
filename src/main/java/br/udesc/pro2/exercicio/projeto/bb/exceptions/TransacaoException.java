package br.udesc.pro2.exercicio.projeto.bb.exceptions;

public abstract class TransacaoException extends Exception {

    public TransacaoException(String message) {
        super(message);
    }
}
