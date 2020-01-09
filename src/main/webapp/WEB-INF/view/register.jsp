<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>register</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div><h2>Registration page</h2></div>
	 <form method="POST" action="registeruser" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text"  style="max-width: 250px" class="form-control" placeholder="Username" autofocus="true" required="required"/><br>
            <input name="email" type="email"  style="max-width: 250px" class="form-control" placeholder="email" required="required"/><br>
            <input name="password" type="password"  style="max-width: 250px" class="form-control" placeholder="Password" required="required"/><br>
            <span>${error}</span>

            <button class="btn btn-lg btn-primary btn-block"  style="max-width: 250px" type="submit">Register</button>
            <h4 class=""><a href="/login">already have a account</a></h4>
        </div>

    </form>

</body>
</html>