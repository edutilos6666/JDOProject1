<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>npe.jsp</title>
</head>
<body>
<h3>Exception Handling example</h3>
<s:form action="npeAction" method="post">
    <s:textfield name="name" label="Name" />
    <s:submit label="Submit" />
</s:form>
</body>
</html>
