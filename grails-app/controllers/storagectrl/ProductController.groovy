package storagectrl

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.touk.excel.export.WebXlsxExporter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.grails.plugins.excelimport.*;
import org.grails.plugins.csv.*;
import java.io.FileReader;
import au.com.bytecode.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.FileNotFoundException;

class ProductController {
    def scaffold = true
    def excelImportService
    def qtext
    def springSecurityService

    def index(Integer max) {
        //Simple search by name and brand without any plugin use
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
        qtext = params.query
        def productList = Product.createCriteria().list (params) {
            if (params.query) {
                or{
                    ilike("name", "%${params.query}%")
                    ilike("brand", "%${params.query}%")
                }
            }
        }
        def totalCount = productList.totalCount
        [productInstanceList: productList, productInstanceTotal: totalCount]
    }

    //<=5
    def last={
        def products = Product.list()
        int count = 0
        def ids = []
        for(int i=0; i<products.size;i++){
            if(products[i].amount<=5){
                ids[count]=i
                count ++
            }
        }
        Product[] lasts = new Product[count];
        int j = 0
        for(int i=0; i<count;i++){
                j = ids[i]
                lasts[i]= products[j]
        }
        [lasts : lasts]
    }

    //Import
    def imexcel = {
        try {
            MultipartHttpServletRequest mpr = (MultipartHttpServletRequest)request;
            CommonsMultipartFile file = (CommonsMultipartFile) mpr.getFile("file");
            String filename = file.getOriginalFilename();
            //excel file import
            if(filename.endsWith(".xlsx") | filename.endsWith(".xlx")){
                Map CONFIG_BOOK_COLUMN_MAP = [
                  sheet:'Sheet1', //required sheet name from file
                  startRow: 1,
                  columnMap:  [
                  //Col, Map-Key
                      'A':'externalid',
                      'B':'name',
                      'C':'brand',
                      'D':'price',
                      'E':'size',
                      'F':'amount'
                    ]
                ]
                Workbook workbook = WorkbookFactory.create(file.inputStream)
                def bookList = excelImportService.columns(workbook, CONFIG_BOOK_COLUMN_MAP)
                for(int i=0;i<bookList.size;i++){
                    Product p = new Product()
                    if(bookList[i].externalid != null){
                        p.externalid = bookList[i].externalid
                    }else{log.error("Externalid is not found. Product can't be created.")}
                    if(bookList[i].name != null){
                        p.name = bookList[i].name
                    }else{log.error("Name is not found. Product can't be created.")}
                    if(bookList[i].brand != null){
                        p.brand = bookList[i].brand
                    }
                    if(bookList[i].price != null){
                        p.price = bookList[i].price
                    }
                    if(bookList[i].size != null){
                        p.size = bookList[i].size
                    }
                    if(bookList[i].amount != null){
                        p.amount = bookList[i].amount
                    }else{log.error("Amount is not found. Product can't be created.")}
                    p.save();
                }
            }
            //.csv file import
            if(filename.endsWith(".csv")) {
                file.inputStream.toCsvReader(['skipLines':1]).eachLine { tokens->
                    Product p = new Product()
                    if(!tokens[0].empty){
                        p.externalid = tokens[0]
                    }else{log.error("Externalid is not found. Product can't be created.")}
                    if(!tokens[1].empty){
                        p.name = tokens[1]
                    }else{log.error("Name is not found. Product can't be created.")}
                    if(!tokens[2].empty){
                        p.brand = tokens[2]
                    }
                    if(!tokens[3].empty){
                        p.price = Double.parseDouble(tokens[3]);
                    }
                    if(!tokens[4].empty){
                        p.size = Double.parseDouble(tokens[4]);
                    }
                    if(!tokens[5].empty){
                        p.amount = Integer.parseInt(tokens[5]);
                    }else{log.error("Amount is not found. Product can't be created.")}
                    p.save();
                }
            }
        }catch(FileNotFoundException e){
                e.printStackTrace()
        }
        redirect(action:index)
    }

    //Excel export method
    def excel(Integer max){
        response.setHeader("Content-Type", "application/vnd.ms-excel")
        response.setHeader("Content-disposition", "attachment; filename=ExportData.xlsx")
        //Search with searhcable plugin
        def prodList
        def prodCount
        if (qtext) {
            prodList = Product.search(qtext + '*').results
            prodCount = prodList.size()
        }else{
            prodList = Product.list(params)
            prodCount = Product.count()
        }

        def headers = ['External Id','Name', 'Brand', 'Price', 'Size', 'Amount']
        def withProperties = ['externalid','name', 'brand', 'price', 'size', 'amount']
        new WebXlsxExporter().with{
            setResponseHeaders(response)
            fillHeader(headers)
            add(prodList, withProperties)
            save(response.outputStream)
        }
        redirect(action:index)

    }
}
