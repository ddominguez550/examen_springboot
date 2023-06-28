package net.ddr.apirest.exceptions;

public class GeneralException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralException(String message, Throwable cause) {
		super(message, cause);
	}
}
