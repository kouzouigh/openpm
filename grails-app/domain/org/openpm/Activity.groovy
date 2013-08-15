package org.openpm

class Activity {

	enum Status {
		Open, Closed
	}
	
	String name
	User consultant
	Date startDate
	Date endDate
	Double hourlyChargeRate
	Country country
	
	
    static constraints = {
		name minSize:3
		endDate nullable: true
    }
	
	Status getStatus() {
		endDate == null ? Status.Open : Status.Closed
	}
}
