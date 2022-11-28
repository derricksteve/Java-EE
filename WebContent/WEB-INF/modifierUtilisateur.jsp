<%@include file="inc/header.jsp" %>
<body>
	<h1>Modification d'un utilisateur</h1>
	<%
	Utilisateur utilisateur= (Utilisateur) request.getAttribute("utilisateur");
	%>
		
		
		<form  method="post">
		<div class="idem">
		<label for="nom">Nom</label>
		<input type="text" name="nom" value="${utilisateur.nom }"></div>
		<div class="idem">
		<label for="prenom">Prenom</label>
		<input type="text" name="prenom" value="${utilisateur.prenom }"></div>
		<div class="idem">
		<label for="login">Login</label>
		<input type="text" name="login"  value="${utilisateur.login }"></div>
		<div class="idem">
		<label for="password">Password</label>
		<input type="text" name="password"  value="${utilisateur.password }"><br></div>
		<div class="idem">
		<label></label>
		<input type="submit" value="Valider"> </div>
		
		
		
		
		
		
		
		
		</form>
		
		
<%@include file="inc/footer.jsp" %>


</body>
</html>