package org.openpm

class Client {
	
	String name
	String contactName
	String email
	Country country
	
    static constraints = {
		name nullable: false, blank: false, minSize: 3
		contactName nullable: false, blank: false, minSize: 3
		email nullable: false, blank:false, email: true
		country nullable: false
    }
}
