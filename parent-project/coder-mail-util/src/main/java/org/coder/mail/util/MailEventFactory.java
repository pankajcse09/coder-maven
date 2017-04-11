package org.coder.mail.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.coder.mail.beans.MailRuleEventList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

public class MailEventFactory {
	static MailRuleEventList list = null;

	public MailRuleEventList getInstance() throws FileNotFoundException {
		if (list == null) {
			init();
		}
		return list;
	}

	public static void init() throws FileNotFoundException {
		if (list == null) {
			list = parseXML();
		}
	}

	private static MailRuleEventList parseXML() throws FileNotFoundException {
		Resource ruleFile = new ClassPathResource("mailRuleDigester.xml");
		if (!ruleFile.exists()) {
			throw new FileNotFoundException("mailRuleDigester.xml do not exist in classpath");
		}
		Resource eventFile = new ClassPathResource("mailRule.xml");
		if (!eventFile.exists()) {
			throw new FileNotFoundException("mailRule.xml do not exist in classpath");
		}
		try {
			Digester digester = DigesterLoader.createDigester(ruleFile.getURL());
			list = (MailRuleEventList) digester.parse(eventFile.getInputStream());
		} catch (IOException localIOException) {
		} catch (SAXException localSAXException) {
		}
		return list;
	}
}
