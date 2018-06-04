<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>findAll</title>
</head>
<body>
  <h3>findAll result</h3>
  <s:iterator value="personList" var="person">
      <s:property value="#person.id" />
      <s:property value="#person.name" />
      <s:property value="#person.age" />
      <s:property value="#person.wage" />
      <br/>
  </s:iterator>
</body>
</html>
