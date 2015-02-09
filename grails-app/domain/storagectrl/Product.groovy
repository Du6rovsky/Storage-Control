package storagectrl

class Product {

	static searchable = true

    String externalid
	String name
	String brand
	Double price
	Double size
	int amount
	
    static constraints = {
		externalid(unique: true , blank: false, nullable: false)
		name(blank: false, nullable: false)
		amount(blank: false, nullable: false)
		brand(nullable:true)
		price(nullable:true)
		size(nullable:true)
    }
    //static mapping = {index: "product_id"}
}
