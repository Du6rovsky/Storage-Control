
<%@ page import="storagectrl.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<div class="logged">
				<sec:ifLoggedIn >
				You are logged in as <span>${applicationContext.springSecurityService.currentUser.username}</span>
				</sec:ifLoggedIn>
			</div><!--end logged-->
			<ul>
				<li><g:link controller='logout' action='index'>Logout</g:link></li>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-product" class="content scaffold-list" role="main">
			<h1><g:message code="default.last.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="externalid" title="${message(code: 'product.externalid.label', default: 'Externalid')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'product.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="brand" title="${message(code: 'product.brand.label', default: 'Brand')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'product.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="size" title="${message(code: 'product.size.label', default: 'Size')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'product.amount.label', default: 'Amount')}" />
					
					</tr>
				</thead>
				<g:if test="${lasts[0] != null}">
					<tbody>
					<g:each in="${lasts}" status="i" var="last">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td>${fieldValue(bean: last, field: "externalid")}</td>
						
							<td>${fieldValue(bean: last, field: "name")}</td>
						
							<td>${fieldValue(bean: last, field: "brand")}</td>
						
							<td>${fieldValue(bean: last, field: "price")}</td>
						
							<td>${fieldValue(bean: last, field: "size")}</td>
						
							<td>${fieldValue(bean: last, field: "amount")}</td>
						
						</tr>
					</g:each>
					</tbody>
				</g:if>
			</table>
			<div class="pagination">
				<g:paginate total="${productInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
