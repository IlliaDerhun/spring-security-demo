<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Registration page</title>
    </head>
    <body>

        <form:form action="${pageContext.request.contextPath}/saveUser" modelAttribute="user" method="post">

            <div>
                <label>First name:</label>
                <form:input path="firstName"/>
                <form:errors path="firstName" />
            </div>

            <div>
                <label>Last name:</label>
                <form:input path="lastName"/>
                <form:errors path="lastName" />
            </div>

            <div>
                <label>Email:</label>
                <form:input type="email" path="email"/>
                <form:errors path="email" />
            </div>

            <div>
                <label>Password</label>
                <form:input type="password" path="password"/>
            </div>

            <div>
                <label>Confirm</label>
                <form:input type="password" path="matchingPassword"/>
            </div>

            <div>
                <label></label>
                <input type="submit" value="Submit"/>
            </div>

        </form:form>

    </body>
</html>