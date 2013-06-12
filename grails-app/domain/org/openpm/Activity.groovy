package org.openpm

class Activity {

	String name
	User consultant
	Date startDate
	Date endDate
	
    static constraints = {
		name minSize:3
    }
}
