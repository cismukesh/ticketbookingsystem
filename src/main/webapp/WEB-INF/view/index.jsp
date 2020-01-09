<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V2</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.button {
	padding: 15px 25px 15px 25px;
	margin: 5px;
	background: #e0e6e6;
	border-radius: 5px;
	border: 1px black solid;
	font-size: 20px;
}
</style>
</head>
<body>
<div> <h1> Booking page</h1></div>
<c:forEach items="${seats}" var="seat">
<c:choose>
     <c:when test="${seat.isBooked}">
      <a href="/cancelticket?id=${seat.id}"> <button class="button"  style="background: #4f5757" >${seat.seatNo}</button></a>
      </c:when>
      <c:otherwise>
        <a href="/bookticket?id=${seat.id}"> <button class="button">${seat.seatNo}</button></a>
      </c:otherwise>
  </c:choose>
      <c:if test="${seat.seatNo%6==0}"><br></c:if>
</c:forEach>
</body>
</html>