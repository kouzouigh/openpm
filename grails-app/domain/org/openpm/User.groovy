package org.openpm

class User {
	
	String email
	String password
	Country country
	
    static constraints = {
		email email:true, blank:false, nullable:false, unique:true
		password blank:false, nullable: false, size:5..15
		country nullable: false
    }
}
