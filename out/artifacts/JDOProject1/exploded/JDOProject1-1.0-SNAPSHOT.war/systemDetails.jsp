<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>systemDetails.jsp</title>
</head>
<body>
 <h3>SystemDetails Converter Example</h3>
<s:form action="systemDetailsAction" method="post">
    <s:textfield name="details" label="System Details" />
    <s:submit label="Submit" />
</s:form>
<br/>
details = <s:property value="details" />
</body>
</html>
