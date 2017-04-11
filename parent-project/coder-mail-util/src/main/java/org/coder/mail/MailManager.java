package org.coder.mail;

import java.io.FileNotFoundException;
import java.util.List;

import javax.mail.MessagingException;

import org.coder.mail.beans.UserBean;
import org.coder.mail.exception.MailEventException;
import org.coder.mail.exception.MailServiceException;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;

public abstract interface MailManager {
	
	public abstract void sendMail(String paramString, List<UserBean> paramList, Object paramObject)
			throws FileNotFoundException, MailEventException, MailServiceException;

	public abstract void sendMail(String paramString, List<UserBean> paramList, List<Resource> paramList1,
			Object paramObject)
			throws FileNotFoundException, MailEventException, MailServiceException, MailException, MessagingException;
}
