package org.openpm

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Invoice)
class InvoiceTests {

	void setUp() {
		mockForConstraintsTests(Invoice)
	}
	
	void testNullName() {
		def invoice = new Invoice()
		
		assert !invoice.validate()
	
		assert 'nullable' == invoice.errors['name']
	}
	
	void testNullBlank() {
		def invoice = new Invoice(name:"")
		
		assert !invoice.validate()
	
		assert 'blank' == invoice.errors['name']
	}
	
	void testClientNull() {
		def invoice = new Invoice(client: null)
		
		assert !invoice.validate()
	
		assert 'nullable' == invoice.errors['client']
	}
	
	void testProjectNull() {
		def invoice = new Invoice(project: null)
		
		assert !invoice.validate()
	
		assert 'nullable' == invoice.errors['project']
	}
	
	void testStatusNull() {
		def invoice = new Invoice(status: null)
		
		assert !invoice.validate()
	
		assert 'nullable' == invoice.errors['status']
	}
}
