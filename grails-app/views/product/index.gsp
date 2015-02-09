
<%@ page import="storagectrl.Product" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title>Storage control system/></title>
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
				<li><g:link class="last" action="last"><g:message code="default.button.last.label"/></g:link></li>
				<sec:ifAnyGranted roles="ROLE_ADMIN">
					<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link>
					<li>
						<g:form controller="Product" action="imexcel" method="post" enctype="multipart/form-data">
		  					<label for="file"><g:message code="default.import.label"/></label>
		  					<input type="file" name="file" id="file"/>
		  					<input type="submit" value="Upload"/>
		  				</g:form>
					</li>
				</sec:ifAnyGranted>
			</ul>
		</div>
		<div id="list-product" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div class="form">
				<ul>
					<li>
						<g:form action="index" method="GET">
				            <label for="query">Search for products:</label>
				            <g:textField name="query" value="${params.query}"/>
					    </g:form>							
					</li>
					<li>
						<g:form action="excel" method="post">
							<div class="form">
								<span class="button"><g:submitButton name="export" value="${message(code: 'default.button.export.exel.label')}" action="excel"/></span>	
							</div>
						</g:form>	
					</li>
				</ul>
			</div>
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
				<tbody>
				<g:each in="${productInstanceList}" status="i" var="productInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<sec:ifAnyGranted roles="ROLE_ADMIN">
							<td><g:link action="show" id="${productInstance.id}">${fieldValue(bean: productInstance, field: "externalid")}</g:link></td>
						</sec:ifAnyGranted >
						<sec:ifAnyGranted roles="ROLE_USER">
							<td>${fieldValue(bean: productInstance, field: "externalid")}</td>
						</sec:ifAnyGranted>
						<td>${fieldValue(bean: productInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: productInstance, field: "brand")}</td>
					
						<td>${fieldValue(bean: productInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: productInstance, field: "size")}</td>
					
						<td>${fieldValue(bean: productInstance, field: "amount")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productInstanceTotal ?: 0}" />
			</div>			
		</div>
	</body>
</html>
