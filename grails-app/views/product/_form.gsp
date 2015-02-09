<%@ page import="storagectrl.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'externalid', 'error')} required">
	<label for="externalid">
		<g:message code="product.externalid.label" default="Externalid" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="externalid" required="" value="${productInstance?.externalid}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${productInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'brand', 'error')} required">
	<label for="brand">
		<g:message code="product.brand.label" default="Brand" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="brand" required="" value="${productInstance?.brand}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="product.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: productInstance, field: 'price')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'size', 'error')} required">
	<label for="size">
		<g:message code="product.size.label" default="Size" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="size" value="${fieldValue(bean: productInstance, field: 'size')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="product.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" type="number" value="${productInstance.amount}" required=""/>

</div>

