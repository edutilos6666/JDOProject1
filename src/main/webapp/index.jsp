<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 29/08/2016
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <s:form action="indexAction" method="post">
   <s:select list="{'foo', 'bar', 'bim'}" name="name" />
  <s:submit label="Submit" />
  </s:form>

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


  <h3>iterator , sort , subset example</h3>
  <h4>iterator alone example </h4>
  <s:iterator value="workerList">
    [<s:property value="id" />, <s:property value="name" /> , <s:property value="age" />, <s:property value="wage" /> , <s:property value="active" />] <br/>
  </s:iterator>
  <h4>iterator with sort and comparator</h4>
  <s:sort comparator="workerComparator" source="workerList">
    <s:iterator>
      [<s:property value="id" />, <s:property value="name" /> , <s:property value="age" />, <s:property value="wage" /> , <s:property value="active" />] <br/>
    </s:iterator>
  </s:sort>
  <h4>iterator with subset and decider</h4>
  <s:subset  source="workerList" decider="workerDecider" >
    <s:iterator>
      [<s:property value="id" />, <s:property value="name" /> , <s:property value="age" />, <s:property value="wage" /> , <s:property value="active" />] <br/>
    </s:iterator>
  </s:subset>
  <h4>iterator with subset</h4>
  <s:subset source="workerList" count="3">
    <s:iterator>
      [<s:property value="id" />, <s:property value="name" /> , <s:property value="age" />, <s:property value="wage" /> , <s:property value="active" />] <br/>
    </s:iterator>
  </s:subset>
  <!-- beans -->
  <s:bean name="com.edutilos.comparator.WorkerByWageComparator" var="comp1" />
  <s:bean name="com.edutilos.decider.WorkerByNameDecider" var="decider1" />
  <h4>comp1</h4>
  <s:sort comparator="comp1" source="workerList">
    <s:iterator>
      [<s:property value="id" />, <s:property value="name" /> , <s:property value="age" />, <s:property value="wage" /> , <s:property value="active" />] <br/>
    </s:iterator>
  </s:sort>
  <h4>decider1</h4>
  <s:subset source="workerList" decider="decider1">
    <s:iterator>
      [<s:property value="id" />, <s:property value="name" /> , <s:property value="age" />, <s:property value="wage" /> , <s:property value="active" />] <br/>
    </s:iterator>
  </s:subset>
  <h4>merge</h4>
  <s:merge var="merge1">
    <s:param value="list1" />
    <s:param value="list2" />
    <s:param value="list3" />
  </s:merge>
  <s:iterator value="merge1">
    <s:property />
  </s:iterator>
  <h4>append</h4>
  <s:append var="append1">
    <s:param value="list1" />
    <s:param value="list2" />
    <s:param value="list3" />
  </s:append>
  <s:iterator value="append1">
    <s:property />
  </s:iterator>
  <h4>generator</h4>
  <s:generator separator="," val="%{'foo,bar,bim'}">
    <s:iterator>
      <s:property />
    </s:iterator>
  </s:generator>
  <h4>action tag</h4>
  <s:action name="extraIndexAction" executeResult="true" />

  </body>
</html>
