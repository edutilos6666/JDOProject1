<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>extraAction</title>
</head>
<body>

<s:iterator value="langSkills">
    <s:property />
</s:iterator>

<s:set var="fname" value="%{'foo'}" />
<s:set var="lname" value="%{'bar'}" />
<br/>
fname = <s:property value="fname" /> <br/>
lname = <s:property value="lname" /> <br/>
<h3>push</h3>
<s:push value="worker">
    [<s:property value="id" />, <s:property value="name" /> , <s:property value="age" />, <s:property value="wage" /> , <s:property value="active" />] <br/>
</s:push>

<h3>text</h3>
<s:text name="global.heading" /> <br/>
<s:text name="global.id" /> <br/>
<h3>url example</h3>
<s:url value="http://www.google.com" var="google">
    <s:param name="fname">foo</s:param>
    <s:param name="lname">bar</s:param>
    <s:param name="age">10</s:param>
</s:url>

<s:a href="%{google}">go to google</s:a>
<br/>
</body>
</html>
