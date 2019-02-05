<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Leaders</title>
    </head>
    <body>
        Only for admins

        <p>Some admins stuff</p>

        <a href="${pageContext.request.contextPath}/">Back to home page</a>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Logout"/>
        </form:form>

    </body>
</html>