<%@include file="inc/header.jsp" %>
	<body>
		<h1 class="titre_secondairee">Ajout d'un utilisateur</h1>
		
		
		<form  method="post" >
		
		<div class="idem">
		<label for="nom">Nom</label>
		<input type="text" name="nom" required></div>
	
		<div class="idem">
		<label for="prenom">Prenom</label>
		
		<input type="text" name="prenom" required></div>
		
		<div class="idem">
		<label for="login">Login</label>
		<input type="text" name="login" required></div>
		<div class="idem">
		<label for="password">Password</label>
		<input type="password" name="password" required></div>
		<div class="idem">
		<label></label>
		<input type="submit" value="Ajouter">
			</div>
		
		
		
		
		
		
		
		</form>
		
		
		<%@include file="inc/footer.jsp" %>
	</body>
</html>