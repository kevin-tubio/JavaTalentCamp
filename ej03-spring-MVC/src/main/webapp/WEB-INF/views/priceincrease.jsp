<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title><fmt:message key="title"/></title>
    <style>
      .error { color: red; }
    </style>
  </head>
  <body>
    <h1><fmt:message key="priceincrease.heading"/></h1>
    <form:form method="post" modelAttribute="priceIncrease">
      <table>
        <tr>
          <td style="alignment: right;width: 10%">Increase (%):</td>
          <td style="width: 20%">
            <form:input path="percentage"/>
          </td>
          <td style="width: 60%">
            <form:errors path="percentage" cssClass="error"/>
          </td>
        </tr>
      </table>
      <br>
      <input type="submit" value="Execute">
    </form:form>
    <a href="<c:url value="hello.htm"/>">Home</a>
  </body>
</html>
