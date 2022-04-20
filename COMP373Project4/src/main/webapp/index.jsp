<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Timer" %>
</h1>
<br/>
<h2><%= "Enter a time to countdown from" %>
</h2>
<form>
    <label for="time">Time: </label>
    <input type="text" id="time" name="time">
</form>
<jsp:include page="/timer-servlet" flush="true" >
    <jsp:param name="time" value="time"/>
</jsp:include>
</body>
</html>