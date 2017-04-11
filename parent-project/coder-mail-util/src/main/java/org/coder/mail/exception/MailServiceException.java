package org.coder.mail.exception;

public class MailServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	public MailServiceException(String text) {
		super(text);
	}

	public MailServiceException(Throwable t) {
		super(t);
	}
}
