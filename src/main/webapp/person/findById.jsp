<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findById</title>
</head>
<body>
<h3>Person details</h3>
id: <s:property value="person.id" /> <br/>
name: <s:property value="person.name" /> <br/>
age: <s:property value="person.age" /> <br/>
wage: <s:property value="person.wage" /> <br/>
active: <s:property value="person.active"/> <br/>
</body>
</html>
