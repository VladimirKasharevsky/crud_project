<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<title>Web project</title>

</head>
    <body>
        <h2>Hello World!</h2>
        <a href="/tableserv">Click here to see servlet</a>


        <form action="/filter" method="post">
        <h4>Sign In</br></h4>
           <p>Name: </p> <input type="text" name="Name" value = ""/>
           <p>Password:</p> <p><input type="password" name="Password" value = "" />
            <input type="submit" value="update">
        </form>

    </body>
</html>
