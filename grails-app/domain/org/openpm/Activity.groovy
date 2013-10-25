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
	Project project
	String description
	
	
    static constraints = {
		name minSize:3
		description nullable: true
		endDate nullable: true
    }
	
	Status getStatus() {
		endDate == null ? Status.Open : Status.Closed
	}
}
