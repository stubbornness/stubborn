package com.stubborn.exception;

public class RemoteInvocationFailureException extends RuntimeException {
    private static final long serialVersionUID = 5251278627873515144L;

    public RemoteInvocationFailureException() {
        super();
    }

    public RemoteInvocationFailureException(String message) {
        super(message);
    }

    public RemoteInvocationFailureException(Throwable cause) {
        super(cause);
    }

    public RemoteInvocationFailureException(String message, Throwable cause) {
        super(message, cause);
    }

}