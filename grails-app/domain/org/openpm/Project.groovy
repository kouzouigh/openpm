package org.openpm

class Project {
	
	String name
	String code
	String description
	Client client
	
	static hasMany = [countries: Country]

    static constraints = {
		name nullable: false, blank: false, minSize: 4
		code nullable: false, blank: false, minSize: 3
		countries minSize: 1
		client nullable: false
    }
}
