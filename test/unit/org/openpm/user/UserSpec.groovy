package org.openpm.user

import grails.test.mixin.*
import org.junit.*
import org.openpm.User
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

	void setup() {
		mockForConstraintsTests(User)
	}
	
	@Unroll
	def "property #property is mandatory"() {
		setup:
		def user = new User("$property": null)
		user.validate()
		
		expect:
		user.errors["$property"]  == 'nullable'
		
		where:
		property    	 | _
		"firstName"		 | _
		"lastName"		 | _
		"passwordHash"   | _
		"email"			 | _
		"code"			 | _
		"country"		 | _
	}
	
	@Unroll
	def "property #property should be not blank"() {
		setup:
		def user = new User("$property": '')
		user.validate()
		
		expect:
		user.errors["$property"]  == 'blank'
		
		where:
		property 		 | _
		"firstName"   	 | _
		"lastName"		 | _
		"passwordHash"   | _
		"code"			 | _
	}
	
	@Unroll
	def "code property size should be equal 3"() {
		setup:
		def user = new User(code: value)
		user.validate()
		
		expect:
		user.errors["code"] == 'size'
		
		where:
		
		property | value
		"code"   | "SA"
		"code"	 | "ADMIN"
	}

	def "email should be valid"() {
		setup:
		client.validate()
		
		expect:
		user.errors['email'] == 'email'
		
		where:
		user = new User(email: 'user@email')
	}
	
}
