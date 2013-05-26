package org.openpm

import grails.test.mixin.*
import org.junit.*
import org.openpm.Project;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Project)
class ProjectTests {

	static final String DATE_FORMAT = 'dd/MM/yyyy'
	
    void setUp() {
		mockForConstraintsTests(Project)
	}
	
	void testNameNull() {
		def project = new Project(name:null)
		
		assert !project.validate()
		
		assert 'nullable' == project.errors['name']
	}
	
	void testNameBlank() {
		def project = new Project(name:'')
		
		assert !project.validate()
		
		assert 'blank' == project.errors['name']
	}
	
	void testNameLengthLessThan4() {
		def project = new Project(name:'prj')
		
		assert !project.validate()
		
		assert 'minSize' == project.errors['name']
	}
	
	void testCodeNull() {
		def project = new Project(code:null)
		
		assert !project.validate()
		
		assert 'nullable' == project.errors['code']
	}
	
	void testCodeBlank() {
		def project = new Project(code:'')
		
		assert !project.validate()
		
		assert 'blank' == project.errors['code']
	}
	
	void testCodeLengthLessThan3() {
		def project = new Project(code:'pr')
		
		assert !project.validate()
		
		assert 'minSize' == project.errors['code']
	}
	
	void testClientNull() {
		def project = new Project(client:null)
		
		assert !project.validate()
		
		assert 'nullable' == project.errors['client']
	}
	
	void testCountriesEmpty() {
		def project = new Project(countries:[])
		
		assert !project.validate()
		
		assert 'minSize' == project.errors['countries']
	}
	
	void testStartDateNull() {
		def project = new Project(startDate: null)
		
		assert !project.validate()
		
		assert 'nullable' == project.errors['startDate']
	}
	
	void testEndDateBeforeStartDate() {
		def project = new Project(
			startDate: Date.parse(DATE_FORMAT, '10/05/2013'), 
			endDate: Date.parse(DATE_FORMAT, '01/05/2013')
		)
		
		assert !project.validate()
		
		assert 'validator' == project.errors['endDate']
	}
	
	void testStatusOpen() {
		def project = new Project(
			startDate: Date.parse(DATE_FORMAT, '01/05/2013'),
			endDate: null
		)
		
		assert Project.Status.open == project.getStatus()
	}
	
	void testStatusClosed() {
		def project = new Project(
			startDate: Date.parse(DATE_FORMAT, '01/05/2013'), 
			endDate: Date.parse(DATE_FORMAT, '10/05/2013')
		)
		
		assert Project.Status.closed == project.getStatus()
	}
}
