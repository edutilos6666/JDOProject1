<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>indexResult</title>
</head>
<body>
<h3>details</h3>
<s:if test="name == 'foo'">
    <h5>name is foo</h5>
</s:if>
<s:elseif test="name =='bar' ">
    <h5>name is bar</h5>
</s:elseif>
<s:else>
    <h5>name is bim</h5>
</s:else>
</body>
</html>
