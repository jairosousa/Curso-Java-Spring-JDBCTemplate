<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
	<c:url var="depAdd" value="/departamento/add"/>
	<li>
		<a href="${depAdd}" title="Departamentos">Departamentos</a>
	</li>
	
	<c:url var="cargoAdd" value="/cargo/add"/>
	<li>
		<a href="${cargoAdd}" title="Cargos">Cargos</a>
	</li>
</ul>