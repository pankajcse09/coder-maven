package org.coder.mail.impl;

import java.io.FileNotFoundException;
import java.util.List;
import javax.mail.MessagingException;

import org.coder.mail.GenericMailManager;
import org.coder.mail.MailContentManager;
import org.coder.mail.MailManager;
import org.coder.mail.beans.MailRuleEvent;
import org.coder.mail.beans.UserBean;
import org.coder.mail.exception.MailEventException;
import org.coder.mail.exception.MailServiceException;
import org.coder.mail.util.MailEventFactory;
import org.coder.mail.util.MailUtil;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;

public class MailManagerImpl implements MailManager {
	private GenericMailManager genericMailManager = null;
	private MailUtil mailUtil = null;
	private MailEventFactory mailEventFactory = null;
	private MailContentManager mailContentManager = null;

	public void sendMail(String mailEventName, List<UserBean> userList, Object dataModal) throws FileNotFoundException, MailEventException, MailServiceException {
		List<MailRuleEvent> eventList = this.mailEventFactory.getInstance().getMailRuleEventList();

		MailRuleEvent mailRuleEvent = this.mailUtil.getMailRuleEvent(mailEventName, eventList);

		List<String> toList = this.mailUtil.getUserEmailList(mailRuleEvent.getTo(), userList);
		List<String> ccList = this.mailUtil.getUserEmailList(mailRuleEvent.getCc(), userList);

		String subject = this.mailContentManager.createStringContent(mailRuleEvent.getSubject(), dataModal);

		String mailBodyText = this.mailContentManager.createTemplateContent(mailRuleEvent.getTemplate(), dataModal);
		try {
			this.genericMailManager.sendMail(toList, ccList, subject, mailBodyText);
		} catch (MailException e) {
			throw new MailServiceException(e);
		} catch (MessagingException e) {
			throw new MailServiceException(e);
		}
	}

	public void sendMail(String mailEventName, List<UserBean> userList, List<Resource> attachment, Object dataModal)
			throws FileNotFoundException, MailEventException, MailServiceException, MailException, MessagingException {
		List<MailRuleEvent> eventList = this.mailEventFactory.getInstance().getMailRuleEventList();

		MailRuleEvent mailRuleEvent = this.mailUtil.getMailRuleEvent(mailEventName, eventList);

		List<String> toList = this.mailUtil.getUserEmailList(mailRuleEvent.getTo(), userList);
		List<String> ccList = this.mailUtil.getUserEmailList(mailRuleEvent.getCc(), userList);

		String subject = this.mailContentManager.createStringContent(mailRuleEvent.getSubject(), dataModal);

		String mailBodyText = this.mailContentManager.createTemplateContent(mailRuleEvent.getTemplate(), dataModal);
		if ((attachment != null) && (!attachment.isEmpty())) {
			this.genericMailManager.sendMail(toList, ccList, subject, mailBodyText);
		} else {
			this.genericMailManager.sendAttachmentMail(toList, ccList, subject, mailBodyText, attachment);
		}
	}

	public GenericMailManager getGenericMailManager() {
		return this.genericMailManager;
	}

	public void setGenericMailManager(GenericMailManager genericMailManager) {
		this.genericMailManager = genericMailManager;
	}

	public MailUtil getMailUtil() {
		return this.mailUtil;
	}

	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}

	public MailEventFactory getMailEventFactory() {
		return this.mailEventFactory;
	}

	public void setMailEventFactory(MailEventFactory mailEventFactory) {
		this.mailEventFactory = mailEventFactory;
	}

	public MailContentManager getMailContentManager() {
		return this.mailContentManager;
	}

	public void setMailContentManager(MailContentManager mailContentManager) {
		this.mailContentManager = mailContentManager;
	}
}
