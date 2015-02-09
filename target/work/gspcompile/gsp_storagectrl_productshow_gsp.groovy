import storagectrl.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_storagectrl_productshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/show.gsp" }
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
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
createTagBody(2, {->
invokeTag('message','g',20,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',20,['class':("create"),'action':("create")],2)
printHtmlPart(12)
invokeTag('message','g',24,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (productInstance?.externalid)) {
printHtmlPart(17)
invokeTag('message','g',32,['code':("product.externalid.label"),'default':("Externalid")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',34,['bean':(productInstance),'field':("externalid")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (productInstance?.name)) {
printHtmlPart(21)
invokeTag('message','g',41,['code':("product.name.label"),'default':("Name")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',43,['bean':(productInstance),'field':("name")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (productInstance?.brand)) {
printHtmlPart(23)
invokeTag('message','g',50,['code':("product.brand.label"),'default':("Brand")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',52,['bean':(productInstance),'field':("brand")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (productInstance?.price)) {
printHtmlPart(25)
invokeTag('message','g',59,['code':("product.price.label"),'default':("Price")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',61,['bean':(productInstance),'field':("price")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (productInstance?.size)) {
printHtmlPart(27)
invokeTag('message','g',68,['code':("product.size.label"),'default':("Size")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',70,['bean':(productInstance),'field':("size")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (productInstance?.amount)) {
printHtmlPart(29)
invokeTag('message','g',77,['code':("product.amount.label"),'default':("Amount")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',79,['bean':(productInstance),'field':("amount")],-1)
printHtmlPart(19)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',87,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',87,['class':("edit"),'action':("edit"),'resource':(productInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',88,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',90,['url':([resource:productInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',92,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423501806042L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
