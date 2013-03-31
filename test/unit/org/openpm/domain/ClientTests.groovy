package org.openpm.domain

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Client)
class ClientTests {

	void setUp() {
		mockForConstraintsTests(Client)
	}
	
	void testNameNull() {
		def client = new Client(name: null)
		
		assert !client.validate()
		
		assert 'nullable' == client.errors['name']
	}
	
	void testNameBlank() {
		def client = new Client(name: '')
		
		assert !client.validate()
		
		assert 'blank' == client.errors['name']
	}
	
    void testNameMinSize() {
		def client = new Client(name: 'Cl')
		
		assert !client.validate()
		
		assert 'minSize' == client.errors['name']
    }
	
	void testEmailNull() {
		def client = new Client(email: null)
		
		assert !client.validate()
		
		assert 'nullable' == client.errors['email']
	}
	
	void testEmailPattern() {
		def client = new Client(email: 'client@email')
		
		assert !client.validate()
		
		assert 'email' == client.errors['email']
	}
	
	void testContactNameNull() {
		def client = new Client()
		
		assert !client.validate()
		
		assert 'nullable' == client.errors['contactName']
	}
	
	void testContactNameBlank() {
		def client = new Client(contactName: '')
		
		assert !client.validate()
		
		assert 'blank' == client.errors['contactName']
	}
	
	void testContactNameMinSize() {
		def client = new Client(contactName: 'CL')
		
		assert !client.validate()
		
		assert 'minSize' == client.errors['contactName']
	}
	
	void testCountryNull() {
		def client = new Client(country: null)
		
		assert !client.validate()
		
		assert 'nullable' == client.errors['country']
	}
}
