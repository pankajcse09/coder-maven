<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
head>
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
</head>

<body>
	<a href="<s:url action="view.action"/>">Display Records</a>
	<br>
	<br>

	<%--   This is -- <s:property value="#application.a" /> --%>

	<b><font color="#5d8122" face="verdana">Update Details</font></b>

	<s:form action="updates">

		<s:textfield label="Number" value="%{#application.a}" name="mb.no"
			readonly="true" cssClass="bord" />
		<s:textfield label="Name" value="%{#application.b}" name="mb.nam"
			cssClass="bord" />
		<s:textfield label="Country" value="%{#application.c}" name="mb.ct"
			cssClass="bord" />

		<s:submit value="Update" />

	</s:form>

</body>
</html>