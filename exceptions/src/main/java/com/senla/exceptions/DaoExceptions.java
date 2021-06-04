package com.senla.exceptions;

public class DaoExceptions extends RuntimeException {

    public DaoExceptions(String massage) {
        super(massage);
    }

    public DaoExceptions(String massage, Throwable cause) {
        super(massage, cause);
    }

    public DaoExceptions(Throwable cause) {
        super(cause);
    }
}