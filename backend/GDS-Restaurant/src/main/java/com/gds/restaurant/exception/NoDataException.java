package com.gds.restaurant.exception;

/**
 * Exception if there is no data at all.
 */
public class NoDataException extends RuntimeException  {
	
    public NoDataException() {
        super("The attribute or request is empty");
    }

    public NoDataException(String message) {
        super(message);
    }
	
}
