package org.openpm.client

import spock.lang.*;

import grails.test.mixin.*
import org.junit.*
import org.openpm.Client;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Client)
class ClientSpec extends Specification {

	void setup() {
		mockForConstraintsTests(Client)
	}
	
	@Unroll
	def "property #property is mandatory"() {
		setup:
		def client = new Client("$property": null)
		client.validate()
		
		expect:
		client.errors["$property"]  == 'nullable'
		
		where:
		property      | _
		"name"        | _
		"email"	      | _
		"contactName" | _
		"country"     | _
	}
	
	@Unroll
	def "property #property should be not blank"() {
		setup:
		def client = new Client("$property": '')
		client.validate()
		
		expect:
		client.errors["$property"]  == 'blank'
		
		where:
		property      | _
		"name"        | _
		"contactName" | _
	}
	
	@Unroll
	def "property #property size should be greater than #minSize"() {
		setup:
		def client = new Client("$property": value)
		client.validate()
		
		expect:
		client.errors["$property"] == 'minSize'
		
		where:
		property      | value | minSize
		"name"        | "Cl"  | 3
		"contactName" | "CL"  | 3
	}
	
	def "email should be valid"() {
		setup:
		client.validate()
		
		expect:
		client.errors['email'] == 'email'
		
		where:
		client = new Client(email: 'client@email')		
	}
	
}
