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
		def user = new User(password: null)
		
		assert !user.validate()
		
		assert 'nullable' == user.errors['password']
	}
	
	void testPasswordBlank() {
		def user = new User(password: '')
		
		assert !user.validate()
		
		assert 'blank' == user.errors['password']
	}
	
	void testPasswordSize() {
		def user = new User(password: 'test')
		
		assert !user.validate()
		
		assert 'size' == user.errors['password']
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
	
}
