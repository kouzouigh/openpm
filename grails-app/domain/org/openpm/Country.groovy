package org.openpm

class Country {
	
	String name

    static constraints = {
		name minSize: 3, unique: true
    }
}
