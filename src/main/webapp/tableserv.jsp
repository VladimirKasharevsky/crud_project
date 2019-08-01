<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<title> My servlet </title>

</head>
<body>
<table border="1">
   <tr>
       <th>ID</th><th>Name</th><th>Pass</th><th>DELL</th><th>UPDATE</th>
   </tr>
   <tr>

    <c:forEach items="${list}" var="list">
        <tr>
            <td><c:out value="${list.id}" /></td>
            <td><c:out value="${list.name}" /></td>
            <td><c:out value="${list.password}" /></td>
            <td>
               <form action="/delete?id=${list.id}" method="post">
               <input type="submit" value="delete"></form></td>

             <td>
               <form action="/update" method="get">
               <input type="hidden" name="id" value="${list.id}">
               <input type="hidden" name="name" value="${list.name}">
               <input type="hidden" name="password" value="${list.password}">
               <input type="submit" value="update"></form></td>
        </tr>
    </c:forEach>
</table>

<h2>Add Info</h2>
<form action="/create" method="post">
 <p> Name:      <input type="text" name="name"/> </p>
 <p> Password:  <input type="text" name="pass"/> </p>
    <input type="submit" value="submit">
</form>

</body>
</html>