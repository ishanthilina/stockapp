<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>${message}</h1>
<a href="<c:url value='login' />">Login form</a>
</body>
</html>