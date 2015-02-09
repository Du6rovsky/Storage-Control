import storagectrl.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_storagectrl_productlast_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/last.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'product.label', default: 'Product'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(applicationContext.springSecurityService.currentUser.username)
printHtmlPart(6)
})
invokeTag('ifLoggedIn','sec',15,[:],2)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',18,['controller':("logout"),'action':("index")],2)
printHtmlPart(9)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(10)
invokeTag('message','g',19,['code':("default.home.label")],-1)
printHtmlPart(11)
invokeTag('message','g',23,['code':("default.last.label"),'args':([entityName])],-1)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('sortableColumn','g',31,['property':("externalid"),'title':(message(code: 'product.externalid.label', default: 'Externalid'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',33,['property':("name"),'title':(message(code: 'product.name.label', default: 'Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("brand"),'title':(message(code: 'product.brand.label', default: 'Brand'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',37,['property':("price"),'title':(message(code: 'product.price.label', default: 'Price'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',39,['property':("size"),'title':(message(code: 'product.size.label', default: 'Size'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',41,['property':("amount"),'title':(message(code: 'product.amount.label', default: 'Amount'))],-1)
printHtmlPart(17)
if(true && (lasts[0] != null)) {
printHtmlPart(18)
loop:{
int i = 0
for( last in (lasts) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
expressionOut.print(fieldValue(bean: last, field: "externalid"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: last, field: "name"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: last, field: "brand"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: last, field: "price"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: last, field: "size"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: last, field: "amount"))
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('paginate','g',68,['total':(productInstanceCount ?: 0)],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423502639278L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
