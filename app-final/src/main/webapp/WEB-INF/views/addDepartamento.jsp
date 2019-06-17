<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Departamentos</title>
</head>
<body>
	
	<c:import url="menu.jsp"/>

	<c:url var="save" value="/departamento/save"/>
	<form:form modelAttribute="departamento" action="${save}" method="post" >
		<form:hidden path="idDepartamento"/>
		<fieldset style="width: 300px; margin: 0 auto;">
			<legend> Departamento </legend>
			<div>
				<form:label path="departamento">Departamento</form:label><br>
				<form:input path="departamento" type="text" required='true'/>
			</div>
			<br>
			<div>
				<input type="submit" value="Salvar">
				<input type="reset" value="Limpa">
			</div>
		</fieldset>
	</form:form>
	
	<fieldset style="width: 300px; margin: 0 auto;">
		<legend>Departamentos</legend>
		<table style="width: 300px;">
			<tr>
				<th>Código</th>
				<th>Descrição</th>
				<th>Ação</th>
			</tr>
			<c:forEach var="d" items="${departamentos}" varStatus="i">
			<tr bgcolor='${i.count % 2 != 0 ? '#f1f1f1' : 'white'}'>
				<td> ${d.idDepartamento} </td>
				<td> ${d.departamento} </td>
				<td>
					<c:url var="update" value="/departamento/update/${d.idDepartamento}"></c:url>
					<a href="${update}" title="Ver/Editar">&#9445;</a>
					|
					<c:url var="delete" value="/departamento/delete/${d.idDepartamento}"></c:url>
					<a href="${delete}" title="Delete">&#9447;</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>