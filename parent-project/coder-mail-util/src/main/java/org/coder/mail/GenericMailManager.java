package org.coder.mail;

import java.util.List;

import javax.mail.MessagingException;

import org.coder.mail.exception.MailServiceException;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;

public abstract interface GenericMailManager {
	public abstract void sendMail(List<String> paramList1, List<String> paramList2, String paramString1,
			String paramString2) throws MailException, MessagingException, MailServiceException;

	public abstract void sendAttachmentMail(List<String> paramList1, List<String> paramList2, String paramString1,
			String paramString2, List<Resource> paramList) throws MessagingException, MailServiceException;
}
