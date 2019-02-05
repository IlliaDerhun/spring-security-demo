<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home page</title>
    </head>
    <body>
        Home page

        <p>User: <security:authentication property="principal.username"/></p>
        <p>Role: <security:authentication property="principal.authorities"/></p>

        <security:authorize access="hasRole('MANAGER')">
            <p><a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
                (Only for manager)
            </p>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
            <p><a href="${pageContext.request.contextPath}/systems">System page</a>
                (Only for admin)
            </p>
        </security:authorize>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Logout"/>
        </form:form>

    </body>
</html>