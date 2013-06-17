package org.openpm

class Activity {

	String name
	User consultant
	Date startDate
	Date endDate
	Double feeRates
	
	static hasMany = [countries: Country]
	
    static constraints = {
		name minSize:3
		countries minSize: 1
    }
}
