package com.senla.exceptions;

public class ServiceExceptions extends RuntimeException {

    public ServiceExceptions(String massage) {
        super(massage);
    }

    public ServiceExceptions(String massage, Throwable cause) {
        super(massage, cause);
    }

    public ServiceExceptions(Throwable cause) {
        super(cause);
    }
}
