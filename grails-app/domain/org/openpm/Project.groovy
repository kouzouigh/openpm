package org.openpm

class Project {
	
	String name
	String code
	String description
	Client client
	
	static hasMany = [countries: Country]

    static constraints = {
		
    }
}
