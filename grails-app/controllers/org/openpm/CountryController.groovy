package org.openpm

class CountryController {

	static defaultAction = "list"
	
	def list() {
		[countries: Country.findAll()]
	}
	
	def create() {
		[country: new Country()]
	}
	
	def save() {
		def country = new Country(params)		
		if( country.save() ) {
			redirect(action: "list")
		}
		render view:'create', model: [country: country]
	}
	
}
