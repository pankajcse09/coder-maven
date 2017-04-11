package org.coder.mail;

import org.coder.mail.exception.MailServiceException;

public abstract interface MailContentManager
{
  public abstract String createTemplateContent(String paramString, Object paramObject)
    throws MailServiceException;
  
  public abstract String createStringContent(String paramString, Object paramObject)
    throws MailServiceException;
}

