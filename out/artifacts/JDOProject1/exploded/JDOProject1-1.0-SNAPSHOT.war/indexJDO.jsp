<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 30/08/2016
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>findAllWorker</h3>
<form action="findAllWorker" method="post">
    <button type="submit">Find All Worker</button>
</form>
<h3>findByIdWorker</h3>
<form action="findByIdWorker" method="post">
    id: <input type="text" name="worker.id" /> <br/>
    <button type="submit">Find By Id Worker</button>
</form>
<h3>saveWorker</h3>
<form action="saveWorker" method="post">
    name: <input type="text" name="worker.name" /> <br/>
    age: <input type="text" name="worker.age" /> <br/>
    wage: <input type?="text" name="worker.wage" /> <br/>
    active: <input type="text" name="worker.active" /> <br/>
    <button type="submit">save Worker</button>
</form>
<h3>updateWorker</h3>
<form action="updateWorker" method="post">
    id: <input type="text" name="worker.id" /> <br/>
    name: <input type="text" name="worker.name" /> <br/>
    age: <input type="text" name="worker.age"/> <br/>
    wage: <input type="text" name="worker.wage" /> <br/>
    active: <input type="text" name="worker.active" /> <br/>
    <button type="submit">update Worker</button>
</form>
<h3>deleteWorker</h3>
<form action="deleteWorker" method="post">
    id: <input type="text" name="worker.id" /> <br/>
    <button type="submit">delete Worker</button>
</form>

</body>
</html>
