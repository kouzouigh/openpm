package org.openpm.client

import spock.lang.Specification;

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
	
	def "client name is mandatory"() {
		setup:
		client.validate()
		
		expect:
		client.errors['name']  == 'nullable' 
		
		where:
		client = new Client(name: null)
	}
	
	def "test with blank name"() {
		setup:
		client.validate()
		
		expect:
		client.errors['name'] == 'blank'
		
		where:
		client = new Client(name: '')
	}
	
	def "client name size should be greater than 3"() {
		setup:
		client.validate()
		
		expect:
		client.errors['name'] == 'minSize'
		
		where:
		client = new Client(name: 'Cl')		
	}
	
	def "email is mandatory"() {
		setup:
		client.validate()
		
		expect:
		client.errors['email'] == 'nullable'
		
		where:
		client = new Client(email: null)
	}
	
	def "email should be valid"() {
		setup:
		client.validate()
		
		expect:
		client.errors['email'] == 'email'
		
		where:
		client = new Client(email: 'client@email')		
	}
	
	def "contact name is mandatory"() {
		def client = new Client()
		
		assert !client.validate()
		
		assert 'nullable' == client.errors['contactName']
	}
	
	def "contact name should be not blank"() {
		setup:
		assert !client.validate()
		
		expect:
		client.errors['contactName'] == 'blank'
		
		where:
		client = new Client(contactName: '')
	}
	
	void "client contact name size should be greater than 3"() {
		setup:
		client.validate()
		
		expect:
		client.errors['contactName'] == 'minSize'
		
		where:
		client = new Client(contactName: 'CL')	
	}
	
	void "client country is mandatory"() {
		setup:
		client.validate()
		
		expect:
		client.errors['country'] == 'nullable'
		
		where:
		client = new Client(country: null)		
	}
	
}
