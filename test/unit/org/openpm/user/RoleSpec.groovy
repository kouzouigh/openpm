package org.openpm.user

import grails.test.mixin.*
import org.junit.*
import spock.lang.*
import org.openpm.Role

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Role)
class RoleSpec extends Specification {

	def setup() {
		mockForConstraintsTests(Role)
	}
	
    def "role name is mandatory"() {
		setup:
		role.validate()
		
		expect:
		role.errors['name'] == 'nullable'
		
		where:
     	role = new Role(name:null)		
    }
}
