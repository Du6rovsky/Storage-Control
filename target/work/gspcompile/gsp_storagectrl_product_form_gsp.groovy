import storagectrl.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_storagectrl_product_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: productInstance, field: 'externalid', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("product.externalid.label"),'default':("Externalid")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("externalid"),'required':(""),'value':(productInstance?.externalid)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'name', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("product.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("name"),'required':(""),'value':(productInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'brand', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("product.brand.label"),'default':("Brand")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("brand"),'required':(""),'value':(productInstance?.brand)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'price', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("product.price.label"),'default':("Price")],-1)
printHtmlPart(2)
invokeTag('field','g',37,['name':("price"),'value':(fieldValue(bean: productInstance, field: 'price')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'size', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("product.size.label"),'default':("Size")],-1)
printHtmlPart(2)
invokeTag('field','g',46,['name':("size"),'value':(fieldValue(bean: productInstance, field: 'size')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'amount', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("product.amount.label"),'default':("Amount")],-1)
printHtmlPart(2)
invokeTag('field','g',55,['name':("amount"),'type':("number"),'value':(productInstance.amount),'required':("")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422967563272L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
