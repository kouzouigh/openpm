package org.openpm

import grails.test.mixin.*
import org.junit.*
import org.openpm.User;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

	void setUp() {
		mockForConstraintsTests(User)
	}
	
	void testPasswordNull() {
		def user = new User(passwordHash: null)
		
		assert !user.validate()
		
		assert 'nullable' == user.errors['passwordHash']
	}
	
	void testPasswordBlank() {
		def user = new User(passwordHash: '')
		
		assert !user.validate()
		
		assert 'blank' == user.errors['passwordHash']
	}

	void testEmailNull() {
		def user = new User(email: null)
		
		assert !user.validate()
		
		assert 'nullable' == user.errors['email']
	}
	
	void testEmailPattern() {
		def user = new User(email: 'client@email')
		
		assert !user.validate()
		
		assert 'email' == user.errors['email']
	}
	
	void testCodeNull() {
		def user = new User()
		
		assert !user.validate()
		
		assert 'nullable' == user.errors['code']
	}
	
	void testCodeSizeLessThan3() {
		def user = new User(code:'SA')
		
		assert !user.validate()
		
		assert 'size' == user.errors['code']
	}
	
	void testCodeSizeMoreThan3() {
		def user = new User(code:'ADMIN')
		
		assert !user.validate()
		
		assert 'size' == user.errors['code']
	}
	
	
	void testCountryNull() {
		def user = new User(country: null)
		
		assert !user.validate()
		
		assert 'nullable' == user.errors['country']
	}
	
}
