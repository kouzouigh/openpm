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
		
		println activity.errors['name']
		
		assert 'minSize' == activity.errors['name']
	}
}
