<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="common/header.jspf"%>
<c:set var="pageTitle" value="home" />


	<!-- park Content -->


<div class="jumbotron">

	<div class="ParkContent">
		<c:forEach var="parks" items="${park}">
		<div class="row">
			<div class="parksdiv col-sm">
				<c:url var="parkImgUrl" value="/img/parks/${parks.parkcode.toLowerCase()}.jpg" />
				<c:url var="detailUrl" value="/detail"/>
				<a href="${detailUrl}?parkcode=${parks.parkcode}"><img src="${parkImgUrl}" class="img-fluid"></a>
			</div>
			<div class="parkNotes col-sm">
				<a href="${detailUrl}?parkcode=${parks.parkcode}"><strong><c:out value="${parks.parkname}" /></strong></a><br><br>
				<c:out value="${parks.parkdescription}" />
			</div>
			</div>
		</c:forEach>
	</div> 
</div>

<%@include file="common/footer.jspf"%>
