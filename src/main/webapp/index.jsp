<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<title>Web project</title>

</head>
    <body>
        <form action="/login" method="post">
        <h4>Sign In</br></h4>
           <p>Name: </p> <input type="text" name="name" value = ""/>
           <p>Password:</p> <p><input type="password" name="pass" value = "" />
            <input type="submit" value="signin">
        </form>

    </body>
</html>
