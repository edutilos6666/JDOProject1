<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success.jsp</title>
</head>
<body>
<h3>Employee details</h3>
id: <s:property value="employee.id" /> <br/>
name: <s:property value="employee.name" /> <br/>
age: <s:property value="employee.age" /> <br/>
wage: <s:property value="employee.wage" /> <br/>
active: <s:property value="employee.active" /> <br/>
</body>
</html>
