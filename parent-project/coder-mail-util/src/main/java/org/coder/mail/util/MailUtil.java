package org.coder.mail.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coder.mail.beans.MailRuleEvent;
import org.coder.mail.beans.UserBean;
import org.coder.mail.exception.MailEventException;
import org.coder.mail.exception.MailServiceException;
import org.springframework.util.StringUtils;

public class MailUtil {
	public MailRuleEvent getMailRuleEvent(String mailEvent, List<MailRuleEvent> eventList) throws MailEventException {
		if ((eventList == null) || (eventList.isEmpty())) {
			throw new MailEventException("MailEventList is null or is empty");
		}
		boolean isEventFound = false;

		MailRuleEvent mailRuleEvent = null;
		for (MailRuleEvent event : eventList) {
			if (event.getId().equals(mailEvent)) {
				mailRuleEvent = event;
				isEventFound = true;
				break;
			}
		}
		if (!isEventFound) {
			throw new MailEventException("Mail Event :" + mailEvent + " ,do not exist in mail event list");
		}
		return mailRuleEvent;
	}

	public List<String> getUserEmailList(String roleNameList, List<UserBean> userList) throws MailServiceException {
		if ((roleNameList == null) || ("".equals(roleNameList))) {
			throw new MailServiceException("The role name is null or empty string");
		}
		if ((userList == null) || (userList.isEmpty())) {
			throw new MailServiceException("User list is null or empty");
		}
		List<String> emailUserList = new ArrayList<String>();

		String[] roleNameArray = StringUtils.tokenizeToStringArray(roleNameList, ",");

		int size = roleNameArray.length;
		int i;
		for (UserBean user : userList) {
			for (i = 0; i < size; i++) {
				if (roleNameArray[i].equals(user.getRoleName())) {
					if (emailUserList.contains(user.getUserEmail())) {
						break;
					}
					emailUserList.add(user.getUserEmail());
					break;
				}
			}
		}
		Set<String> emailUserSet = new HashSet<String>();
		for (String email : emailUserList) {
			emailUserSet.add(email);
		}
		emailUserList.clear();
		for (String email : emailUserSet) {
			emailUserList.add(email);
		}
		return emailUserList;
	}
}
