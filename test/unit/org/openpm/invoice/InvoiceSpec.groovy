package org.openpm.invoice

import grails.test.mixin.*
import org.junit.*
import org.openpm.Invoice
import org.openpm.InvoiceEvents;

import spock.lang.Specification;
import spock.lang.Unroll;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Invoice)
class InvoiceSpec extends Specification {

	def DEFAULT_DATE = new GregorianCalendar(2013, Calendar.APRIL, 01).getTime()
	
	def today = new Date()
	
	void setup() {
		mockForConstraintsTests(Invoice)
	}
	
	@Unroll
	def "property #property is mandatory"() {
		setup:
		def invoice = new Invoice("$property": null)
		invoice.validate()
		
		expect:
		invoice.errors["$property"]  == 'nullable'
		
		where:
		property   | _
		"name"     | _
		"client"   | _
		"project"  | _
		"event"	   | _
		"terms"    | _
	}
	
	@Unroll
	def "property #property should be not blank"() {
		setup:
		def invoice = new Invoice("$property": '')
		invoice.validate()
		
		expect:
		invoice.errors["$property"]  == 'nullable'
		
		where:
		property      | _
		"name"        | _
	}
	
	
	def "when invoice is created the status should be Todo"() {		
		expect:
		invoice.getStatus() == Invoice.Status.Todo
		
		where:
		invoice = new Invoice(events: new InvoiceEvents(createdDate: new Date()))
	}
	
	def "when the invoice is sent and the due date is not exceeded, the status should be Sent"() {
		given:
		def invoice = new Invoice()
		and:
		invoice.terms = 30
		and:
		invoice.event = new InvoiceEvents(createdDate: today, sentDate:today)
		
		expect:
		invoice.getStatus() == Invoice.Status.Sent
			
	}
	
	def "when the invoice is sent and the due date is exceeded, the status should be Outstanding"() {
		given:
		def invoice = new Invoice()
		and: 
		invoice.terms = 30
		and:
		invoice.event = new InvoiceEvents(createdDate: DEFAULT_DATE, sentDate:DEFAULT_DATE)
		
		assert Invoice.Status.Outstanding == invoice.getStatus()
	}
	
	def "when the invoice is paid, the status should be Paid"() {
		given:
		def invoice = new Invoice()
		and:
		invoice.terms = 30
		and:
		invoice.event = new InvoiceEvents(
						createdDate: DEFAULT_DATE,
						sentDate: DEFAULT_DATE,
						paidDate: DEFAULT_DATE)
		expect:
		invoice.getStatus() == Invoice.Status.Paid
	}
	
}
