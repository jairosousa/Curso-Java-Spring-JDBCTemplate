<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cargos</title>
</head>
<body>
	
	<c:import url="menu.jsp"/>

	<c:url var="save" value="/cargo/save"/>
	<form:form modelAttribute="cargo" action="${save}" method="post" >
		<form:hidden path="idCargo"/>
		<fieldset style="width: 500px; margin: 0 auto;">
			<legend> Cargo </legend>
			<div>
				<form:label path="cargo">Cargo</form:label><br>
				<form:input path="cargo" type="text" required='true'/>
			</div>
			<br>
			<div>
				<form:label path="departamento">Departamento</form:label><br>
				<form:select path="departamento" required="true">
					<form:option value="" label="--- Select ---"/>
					<form:options items="${departamentos}" 
						itemValue="idDepartamento"
						itemLabel="departamento"/>
				</form:select>
			</div>
			<br>
			<div>
				<input type="submit" value="Salvar">
				<input type="reset" value="Limpa">
			</div>
		</fieldset>
	</form:form>
	
	<fieldset style="width: 500px; margin: 0 auto;">
		<legend>Cargos</legend>
		<table style="width: 490px;">
			<tr>
				<th>Código</th>
				<th>Descrição</th>
				<th>Departamento</th>
				<th>Ação</th>
			</tr>
			<c:forEach var="c" items="${cargos}" varStatus="i">
			<tr bgcolor='${i.count % 2 != 0 ? '#f1f1f1' : 'white'}'>
				<td> ${c.idCargo} </td>
				<td> ${c.cargo}</td>
				<td> ${c.departamento.departamento}
				<td>
					<c:url var="update" value="/cargo/update/${c.idCargo}"></c:url>
					<a href="${update}" title="Ver/Editar">&#9445;</a>
					|
					<c:url var="delete" value="/cargo/delete/${c.idCargo}"></c:url>
					<a href="${delete}" title="Delete">&#9447;</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>