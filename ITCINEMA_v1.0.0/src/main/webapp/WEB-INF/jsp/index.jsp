<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/addmovie" onsubmit = "return Validate()">
		Movie Id : <input type="text" name="movieId" id="movieId" required><br>
		<b id="err" style="display:none">Enter Numbers only in Movie ID.</b><br>
		Movie Name : <input type="text" name="movieName" required><br>
		Movie Rating : <input type="text" name="movieRating" required><br>
		Poster URL : <input type="text" name="posterURL" required><br>
		<input type="submit" value="Add Movie"><br>
		<input type="text" name="availableSeats" value="40" style="display:none">
		<input type="text" name="totalSeats" value="40" style="display:none">
		
		
	</form>
	<script type="text/javascript">
		function Validate(){
				var movieId= document.getElementById("movieId").value;
				var pattern = "^[0-9]{4}$";
				if(!movieId.match(pattern)){
					document.getElementById("err").style="display:inline"
						return false;
					}
				return true;
			}
	</script>
</body>
</html>