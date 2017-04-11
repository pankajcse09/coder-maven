package org.coder.mail.exception;

public class MailEventException extends Exception {
	private static final long serialVersionUID = 1L;

	public MailEventException(String text) {
		super(text);
	}

	public MailEventException(Throwable t) {
		super(t);
	}
}
