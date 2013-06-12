package org.openpm

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Activity)
class ActivityTests {

	void setUp() {
		mockForConstraintsTests(Activity)
	}
	
	void testNameMinSize() {
		def activity = new Activity(name: 'AC')
		
		assert !activity.validate()
		
		assert 'minSize' == activity.errors['name']
	}
	
	void testCountriesMinSize() {
		def activity = new Activity(countries: [])
		
		assert !activity.validate()
		
		assert 'minSize' == activity.errors['countries']
	}
}
