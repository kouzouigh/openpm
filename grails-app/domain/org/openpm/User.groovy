package org.openpm

class User {
	
	String email
	String username
	String passwordHash
	String code
	Country country
	
	static hasMany = [ roles: Role, permissions: String ]
	
	
    static constraints = {
		email email:true, blank:false, nullable:false, unique:true
		username nullable: false, blank: false, unique: true
		passwordHash blank:false, nullable: false
		code blank: false, size: 3..3
		country nullable: false
    }
}
