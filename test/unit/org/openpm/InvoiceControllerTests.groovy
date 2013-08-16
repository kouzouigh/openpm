package org.openpm

import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(InvoiceController)
@Mock(Invoice)
//@TestMixin(DomainClassUnitTestMixin)
class InvoiceControllerTests {
	
    void testListAction() {
		def invoice1 = new Invoice(name:'inv1')
		def invoice2 = new Invoice(name:'inv2')
	
	   mockDomain(Invoice, [invoice1, invoice2])
	   mockDomain(Country, [new Country(name:'Algerie')])
	   
	   println Country.findAll()
	   println Invoice.findAll()
		
       def model = controller.list()
	   
	   assert model.invoices?.size == 2
    }
	
	/*void testMockDomain(){
		def jdoe = new User(name:"John Doe", role:"user")
		def suziq = new User(name:"Suzi Q", role:"admin")
		def jsmith = new User(name:"Jane Smith", role:"user")
	  
		mockDomain(User, [jdoe, suziq, jsmith])
	  
		//dynamic finder
		def list = User.findAllByRole("admin")
		assertEquals 1, list.size()
	  
		//NOTE: criteria, Hibernate Query Language (HQL)
		//      and Query By Example (QBE) are not supported
	  }*/
	
}
