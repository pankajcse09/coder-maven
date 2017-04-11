package org.coder.mail.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringReader;

import org.coder.mail.MailContentManager;
import org.coder.mail.exception.MailServiceException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

public class MailContentManagerImpl implements MailContentManager {
	private FreeMarkerConfig freeMarkerConfig = null;

	public String createTemplateContent(String templateName, Object dataModel) throws MailServiceException {
		Template template = null;
		try {
			template = this.freeMarkerConfig.getConfiguration().getTemplate(templateName);
		} catch (IOException e) {
			throw new MailServiceException(e);
		}
		String content = null;
		try {
			content = FreeMarkerTemplateUtils.processTemplateIntoString(template, dataModel);
		} catch (IOException e) {
			throw new MailServiceException(e);
		} catch (TemplateException e) {
			throw new MailServiceException(e);
		}
		return content;
	}

	public String createStringContent(String templateString, Object dataModel) throws MailServiceException {
		String content = null;
		try {
			@SuppressWarnings("deprecation")
			Template template = new Template("name", new StringReader(templateString), new Configuration());

			content = FreeMarkerTemplateUtils.processTemplateIntoString(template, dataModel);
		} catch (IOException e) {
			throw new MailServiceException(e);
		} catch (TemplateException e) {
			throw new MailServiceException(e);
		}
		return content;
	}

	public FreeMarkerConfig getFreeMarkerConfig() {
		return this.freeMarkerConfig;
	}

	public void setFreeMarkerConfig(FreeMarkerConfig freeMarkerConfig) {
		this.freeMarkerConfig = freeMarkerConfig;
	}
}
