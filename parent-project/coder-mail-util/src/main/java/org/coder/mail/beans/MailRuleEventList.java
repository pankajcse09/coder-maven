package org.coder.mail.beans;

import java.util.ArrayList;
import java.util.List;

public class MailRuleEventList {
	
	private List<MailRuleEvent> list;

	public MailRuleEventList() {
		this.list = new ArrayList<MailRuleEvent>();
	}

	public void addMailEvent(MailRuleEvent mailRuleEvent) {
		this.list.add(mailRuleEvent);
	}

	public List<MailRuleEvent> getMailRuleEventList() {
		return this.list;
	}

	public int size() {
		return this.list.size();
	}
}
