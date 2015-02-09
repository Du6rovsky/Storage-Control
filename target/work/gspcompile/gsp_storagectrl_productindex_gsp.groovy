import storagectrl.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_storagectrl_productindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'product.label', default: 'Product'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(applicationContext.springSecurityService.currentUser.username)
printHtmlPart(7)
})
invokeTag('ifLoggedIn','sec',16,[:],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',19,['controller':("logout"),'action':("index")],2)
printHtmlPart(10)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(11)
invokeTag('message','g',20,['code':("default.home.label")],-1)
printHtmlPart(12)
createTagBody(2, {->
invokeTag('message','g',21,['code':("default.button.last.label")],-1)
})
invokeTag('link','g',21,['class':("last"),'action':("last")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
createTagBody(3, {->
invokeTag('message','g',23,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',23,['class':("create"),'action':("create")],3)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('message','g',26,['code':("default.import.label")],-1)
printHtmlPart(17)
})
invokeTag('form','g',29,['controller':("Product"),'action':("imexcel"),'method':("post"),'enctype':("multipart/form-data")],3)
printHtmlPart(18)
})
invokeTag('ifAnyGranted','sec',31,['roles':("ROLE_ADMIN")],2)
printHtmlPart(19)
invokeTag('message','g',35,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(20)
if(true && (flash.message)) {
printHtmlPart(21)
expressionOut.print(flash.message)
printHtmlPart(22)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('textField','g',44,['name':("query"),'value':(params.query)],-1)
printHtmlPart(25)
})
invokeTag('form','g',45,['action':("index"),'method':("GET")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('submitButton','g',50,['name':("export"),'value':(message(code: 'default.button.export.exel.label')),'action':("excel")],-1)
printHtmlPart(28)
})
invokeTag('form','g',52,['action':("excel"),'method':("post")],2)
printHtmlPart(29)
invokeTag('sortableColumn','g',60,['property':("externalid"),'title':(message(code: 'product.externalid.label', default: 'Externalid'))],-1)
printHtmlPart(30)
invokeTag('sortableColumn','g',62,['property':("name"),'title':(message(code: 'product.name.label', default: 'Name'))],-1)
printHtmlPart(30)
invokeTag('sortableColumn','g',64,['property':("brand"),'title':(message(code: 'product.brand.label', default: 'Brand'))],-1)
printHtmlPart(30)
invokeTag('sortableColumn','g',66,['property':("price"),'title':(message(code: 'product.price.label', default: 'Price'))],-1)
printHtmlPart(30)
invokeTag('sortableColumn','g',68,['property':("size"),'title':(message(code: 'product.size.label', default: 'Size'))],-1)
printHtmlPart(30)
invokeTag('sortableColumn','g',70,['property':("amount"),'title':(message(code: 'product.amount.label', default: 'Amount'))],-1)
printHtmlPart(31)
loop:{
int i = 0
for( productInstance in (productInstanceList) ) {
printHtmlPart(32)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: productInstance, field: "externalid"))
})
invokeTag('link','g',78,['action':("show"),'id':(productInstance.id)],4)
printHtmlPart(35)
})
invokeTag('ifAnyGranted','sec',79,['roles':("ROLE_ADMIN")],3)
printHtmlPart(36)
createTagBody(3, {->
printHtmlPart(34)
expressionOut.print(fieldValue(bean: productInstance, field: "externalid"))
printHtmlPart(35)
})
invokeTag('ifAnyGranted','sec',82,['roles':("ROLE_USER")],3)
printHtmlPart(37)
expressionOut.print(fieldValue(bean: productInstance, field: "name"))
printHtmlPart(38)
expressionOut.print(fieldValue(bean: productInstance, field: "brand"))
printHtmlPart(38)
expressionOut.print(fieldValue(bean: productInstance, field: "price"))
printHtmlPart(38)
expressionOut.print(fieldValue(bean: productInstance, field: "size"))
printHtmlPart(38)
expressionOut.print(fieldValue(bean: productInstance, field: "amount"))
printHtmlPart(39)
i++
}
}
printHtmlPart(40)
invokeTag('paginate','g',98,['total':(productInstanceTotal ?: 0)],-1)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',101,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423502777609L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
