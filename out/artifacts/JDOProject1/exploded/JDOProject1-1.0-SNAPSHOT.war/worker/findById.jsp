<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findById</title>
</head>
<body>
<h3>Worker details</h3>
id: <s:property value="worker.id" /> <br/>
name: <s:property value="worker.name" /> <br/>
age: <s:property value="worker.age" /> <br/>
wage: <s:property value="worker.wage" /> <br/>
active: <s:property value="worker.active" /> <br/>
</body>
</html>
