package org.openpm

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Invoice)
class InvoiceTests {
	
	def DEFAULT_DATE = new GregorianCalendar(2013, Calendar.APRIL, 01).getTime()

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
	
	void testEventsNull() {
		def invoice = new Invoice(event: null)
		
		assert !invoice.validate()
	
		assert 'nullable' == invoice.errors['event']
	}
	
	void testTodoStatus() {
		def invoice = new Invoice(events: new InvoiceEvents(createdDate: new Date()))
		
		assert Invoice.Status.Todo == invoice.getStatus()
	}
	
	void testSentStatus() {
		def invoice = new Invoice(
			event: new InvoiceEvents(createdDate: DEFAULT_DATE, 
				sentDate:DEFAULT_DATE))
		
		assert Invoice.Status.Sent == invoice.getStatus()
	}
	
	void testPaidStatus() {
		def invoice = new Invoice(
			event:new InvoiceEvents(createdDate: DEFAULT_DATE, 
					sentDate: DEFAULT_DATE, 
				    paidDate: DEFAULT_DATE))
		
		assert Invoice.Status.Paid == invoice.getStatus()
	}
	
	void testOutstandingStatus() {
		def invoice = new Invoice(
			terms: 30,
			event: new InvoiceEvents(createdDate: DEFAULT_DATE, 
				sentDate:DEFAULT_DATE))
		
		assert Invoice.Status.Outstanding == invoice.getStatus()
	}
	
}
