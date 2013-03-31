package org.openpm.domain

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Country)
class CountryTests {

    void testCodeSize() {
		mockForConstraintsTests(Country)
		
		def country = new Country(name: 'France',
								  code: 'FRANCE')
		
		assert !country.validate()
		
		assert 'size' == country.errors['code']
    }
	
	void testNameMinSize() {
		mockForConstraintsTests(Country)
		
		def country = new Country(name: 'FR',
								  code: 'FRA')
		
		assert !country.validate()
		
		assert 'minSize' == country.errors['name']
	}
}
