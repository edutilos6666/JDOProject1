<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<h3>Employee form</h3>
<s:form action="employeeAction" method="post">
    <s:textfield name="employee.id" label="Id" size="20" />
    <s:textfield name="employee.name" label="Name" size="20" />
    <s:textfield name="employee.age" label="Age" size="20" />
    <s:textfield name="employee.wage" label="Wage" size="20" />
    <s:textfield name="employee.active" label="Active" size="20" />
    <s:submit label="Submit Employee" />
</s:form>
</body>
</html>
