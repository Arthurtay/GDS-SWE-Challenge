package com.gds.restaurant.exception;

/**
 * Exception if there is no data at all.
 */
public class NoDataException extends RuntimeException  {
	

	private static final long serialVersionUID = 1L;

	public NoDataException() {
        super("The attribute or request is empty");
    }

    public NoDataException(String message) {
        super(message);
    }
	
}
