package org.openpm

class ChargeRate {
	
	Date date
	Double rate
	
	static belongsTo = User
	
    static constraints = {
		rate scale: 2
    }
}
