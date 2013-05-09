package org.openpm

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Role)
class RoleTests {

	void setUp() {
		mockForConstraintsTests(Role)
	}
	
    void testNullName() {
     	def role = new Role(name:null)
		
		 assert !role.validate()
		 
		 assert 'nullable' == role.errors['name']
		
    }
}
