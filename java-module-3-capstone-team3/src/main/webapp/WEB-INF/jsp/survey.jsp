<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="common/header.jspf"%>
<div class="jumbotron">
<c:set var="pageTitle" value="survey" />
<c:url var="newSurveyUrl" value="/survey" />
<div id =" surveyDiv"class="row">
	<div class="col-sm">
		<div class="carousel slide" data-ride="carousel" data-interval="3000">
  <div class="carousel-inner">
    <div class="carousel-item active">
    <c:url var="npLogoImgUrl" value="/img/parks/arrowheadNP.png"/>
      <img class="d-block w-100" src="${npLogoImgUrl}" alt="park pic">
    </div>
    <c:forEach var="park" items="${park}">
    <c:url var="parkImgUrl" value="/img/parks/${park.parkcode.toLowerCase()}.jpg" />
    <div class="carousel-item">
    <c:url var="detailUrl" value="/detail"/>
      <a href="${detailUrl}?parkcode=${park.parkcode}"><img class="d-block w-100" id ="Cimg"src="${parkImgUrl}" alt="park pic"></a>
    <div class="carousel-caption d-none d-md-block">
    <h5><c:out value="${park.parkname}"/></h5>
  </div>
    </div>
    </c:forEach>
  </div>
</div>
	</div>
	<div class="col-sm">
		<form action="${newSurveyUrl}" method="post">

			<div class="form-group">
				<label for="Favorite Park"><strong>Favorite Park</strong></label> 
				<select class="form-control" name="parkcode">
 					<c:forEach var="park" items="${park}">
 						<option value="${park.parkcode}">${park.parkname}</option>
 					</c:forEach>
 				</select>
			</div>

			<div class="form-group">
				<label for="emailaddress"><strong>Email address</strong></label> <input type="email"
					class="form-control" name="emailaddress"
					placeholder="name@example.com">
			</div>

			<div class="form-group">
				<label for="state"><strong>Where ye be from?</strong></label> <select
					class="form-control" name="state">
					<optgroup label="states">
            <option value="AL">AL</option>
            <option value="AK">AK</option>
            <option value="AR">AR</option>
            <option value="AZ">AZ</option>
            <option value="CA">CA</option>
            <option value="CO">CO</option>
            <option value="CT">CT</option>
            <option value="DE">DE</option>
            <option value="FL">FL</option>
            <option value="GA">GA</option>
            <option value="HI">HI</option>
            <option value="IA">IA</option>
            <option value="ID">ID</option>
            <option value="IL">IL</option>
            <option value="IN">IN</option>
            <option value="KS">KS</option>
            <option value="LA">LA</option>
            <option value="MA">MA</option>
            <option value="MD">MD</option>
            <option value="ME">ME</option>
            <option value="MI">MI</option>
            <option value="MN">MN</option>
            <option value="MO">MO</option>
            <option value="MS">MS</option>
            <option value="MT">MT</option>
            <option value="NC">NC</option>
            <option value="ND">ND</option>
            <option value="NE">NE</option>
            <option value="NH">NH</option>
            <option value="NJ">NJ</option>
            <option value="NM">NM</option>
            <option value="NV">NV</option>
            <option value="NY">NY</option>
            <option value="OH">OH</option>
            <option value="OK">OK</option>
            <option value="OR">OR</option>
            <option value="PA">PA</option>
            <option value="RI">RI</option>
            <option value="SC">SC</option>
            <option value="SD">SD</option>
            <option value="TN">TN</option>
            <option value="TX">TX</option>
            <option value="UT">UT</option>
            <option value="VT">VT</option>
            <option value="VA">VA</option>
            <option value="WA">WA</option>
            <option value="WV">WV</option>
            <option value="AS">AS</option>
            <option value="DC">DC</option>
            <option value="FM">FM</option>
            <option value="GU">GU</option>
            <option value="MH">MH</option>
            <option value="MP">MP</option>
            <option value="PW">PW</option>
            <option value="PR">PR</option>
            <option value="VI">VI</option>
            </optgroup>
				</select>
			</div>

			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activitylevel"
						value="inactive" checked> <label class="form-check-label"
						for="activityLevel"> Inactive </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activitylevel"
						id="sedentary" value="sedentary" > <label
						class="form-check-label" for="activityLevel"> Sedentary </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activitylevel"
						id="active" value="active" > <label
						class="form-check-label" for="activityLevel"> Active </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activitylevel"
						id="extremelyActive" value="extremelyActive" > <label
						class="form-check-label" for="activityLevel"> Extremely
						Active </label>
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Submit form</button>
		</form>
	</div>
</div>
</div>

<%@include file="common/footer.jspf"%>
