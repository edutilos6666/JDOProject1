<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<h3><s:text name="global.heading" /></h3>

<s:url var="indexEN"  namespace="/" action="localeChangeAction">
    <s:param name="request_locale">en</s:param>
</s:url>

<s:url var="indexDE" namespace="/" action="localeChangeAction">
    <s:param name="request_locale">de</s:param>
</s:url>

<s:url var="indexFR" namespace="/" action="localeChangeAction">
    <s:param name="request_locale">fr</s:param>
</s:url>

<s:a href="%{indexEN}">indexEN</s:a>
<s:a href="%{indexDE}">indexDE</s:a>
<s:a href="%{indexFR}">indexFR</s:a>

<s:form action="localeAction" method="post" namespace="/" >
    <s:textfield name="employee.id" key="global.id" />
    <s:textfield name="employee.name" key="global.name" />
    <s:textfield name="employee.age" key="global.age" />
    <s:textfield name="employee.wage" key="global.wage" />
    <s:textfield name="employee.active" key="global.active" />
    <s:submit key="global.submit" />
</s:form>
</body>
</html>
