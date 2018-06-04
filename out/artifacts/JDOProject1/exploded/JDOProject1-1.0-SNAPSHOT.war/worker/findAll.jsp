<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findAll</title>
</head>
<body>
 <h3>All workers</h3>
 <s:iterator value="workerList" var="worker">
     [<s:property value="#worker.id" /> , <s:property value="#worker.name" /> , <s:property value="#worker.age" />, <s:property value="#worker.wage" />, <s:property value="#worker.active" />]
     <br/>
 </s:iterator>
</body>
</html>
