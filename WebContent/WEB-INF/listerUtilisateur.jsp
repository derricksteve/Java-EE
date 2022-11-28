
<%@include file="inc/header.jsp" %>


<section>

<h1 class="titre_secondaire">Liste des utilisateurs</h1>
<c:choose>
<c:when test="${empty utilisateurs }">
<p class="titre_secondaire">La liste des utilisateurs est vide !</p>

</c:when>
<c:otherwise>

<table border="1" cellspacing="0" cellpadding="10">
<tr id="first_ligne">
<th>ID</th>
<th>Prenom</th>
<th>Nom</th>
<th>Login</th>
<th>Password</th>
<th colspan="2">Action</th>
</tr>
  <c:forEach var="utilisateur" items="${utilisateurs }">
  <tr>
<td><c:out value=" ${utilisateur.id }"/>   </td>
<td><c:out value=" ${utilisateur.prenom }"/>  </td>
<td><c:out value=" ${utilisateur.nom }"/> </td>
<td> <c:out value=" ${utilisateur.login }"/>  </td>
<td><c:out value=" ${utilisateur.password }"/>  </td>
<td><a href="update?id=${utilisateur.id }">Modifier</a>    </td>
<td><a href="delete?id=${utilisateur.id }" onclick="return confirm('En etes vous sure?')">Supprimer</a>    </td></tr>
  

  </c:forEach>
  </table>
</c:otherwise>

</c:choose>


 </section>

<%@include file="inc/footer.jsp" %>