package org.openpm

class Country {
	
	String name
	String code

    static constraints = {
		name minSize: 3, unique: true
		code size: 3..3, unique: true
    }
}
