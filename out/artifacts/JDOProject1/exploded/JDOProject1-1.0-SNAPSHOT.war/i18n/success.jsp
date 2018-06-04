<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success.jsp</title>
</head>
<body>
<h3><s:text name="global.heading" /></h3>
<h4><s:text name="global.details" /> </h4>
<s:label key="global.id" />  <s:property value="employee.id" /> <br/>
<s:label key="global.name" /> <s:property value="employee.name" /> <br/>
<s:label key="global.wage" /> <s:property value="employee.age" /> <br/>
<s:label key="global.wage" /> <s:property value="employee.wage" /> <br/>
<s:label key="global.active" /> <s:property value="employee.active" /> <br/>
</body>
</html>
