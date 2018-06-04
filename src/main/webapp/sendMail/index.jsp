<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
  <h3>Send mail</h3>
<form action="sendMail" method="post">
    from: <input type="text" name="from" /> <br/>
    to: <input type="text" name="to" /> <br/>
    subject: <input type="text" name="subject" /> <br/>
    content: <br/>
    <textarea name="content" rows="10" cols="10">

    </textarea>
    <br/>
    <button type="submit">Send mail</button>
</form>
</body>
</html>
