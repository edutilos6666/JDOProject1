<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h3>annotated worker example</h3>
<s:form action="annotatedWorkerAction" method="post">
    <s:textfield name="worker.id" label="Id" />
    <s:textfield name="worker.name" label="Name" />
    <s:textfield name="worker.age" label="Age" />
    <s:textfield name="worker.wage" label="Wage" />
    <s:textfield name="worker.active" label="Active" />
    <s:submit label="Submit" />
</s:form>

</body>
</html>
