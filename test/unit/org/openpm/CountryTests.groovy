package org.openpm

import grails.test.mixin.*
import org.junit.*
import org.openpm.Country;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Country)
class CountryTests {
	
	void testNameMinSize() {
		mockForConstraintsTests(Country)
		
		def country = new Country(name: 'FR',
								  code: 'FRA')
		
		assert !country.validate()
		
		assert 'minSize' == country.errors['name']
	}
}
