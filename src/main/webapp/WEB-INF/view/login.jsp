<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V2</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div><h2>Login page</h2></div>
	 <form method="POST" action="loginuser" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <input name="email" type="email" style="max-width: 250px" class="form-control" placeholder="email"
                   autofocus="true" required="required"/><br>
            <input name="password" type="password"  style="max-width: 250px" class="form-control" placeholder="password" required="required"/><br>
             <input type="hidden" name="seatId" value="${param.id}"/>
             <input type="hidden" name="cancel" value="${param.cancel}"/>
            <span>${message}</span><br>
            <button class="btn btn-lg btn-primary btn-block"  style="max-width: 250px" type="submit">Log In</button>
            <h4 class=""><a href="/register">Create an account</a></h4>
        </div>

    </form>

</body>
</html>