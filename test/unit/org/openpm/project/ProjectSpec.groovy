package org.openpm.project

import grails.test.mixin.*
import org.junit.*
import org.openpm.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Project)
class ProjectSpec extends Specification {

	static final String DATE_FORMAT = 'dd/MM/yyyy'
	
    void setup() {
		mockForConstraintsTests(Project)
	}
	
	@Unroll
	def "property #property is mandatory"() {
		setup:
		def project = new Project("$property": null)
		project.validate()
		
		expect:
		project.errors["$property"]  == 'nullable'
		
		where:
		property    	 | _
		"name"      	 | _
		"code"      	 | _
		"client"    	 | _
		"startDate" 	 | _
		"projectManager" | _
	}
	
	@Unroll
	def "property #property should be not blank"() {
		setup:
		def project = new Project("$property": '')
		project.validate()
		
		expect:
		project.errors["$property"]  == 'blank'
		
		where:
		property | _
		"name"   | _
		"code"   | _
	}
	
	@Unroll
	def "property #property size should be greater than #minSize"() {
		setup:
		def project = new Project("$property": value)
		project.validate()
		
		expect:
		project.errors["$property"] == 'minSize'
		
		where:
		property | value | minSize
		"name"   | "prj" | 4 
		"code"   | "pr"  | 3
	}
	
	def "project should be related at least to one country"() {
		setup:
		project.validate()
		
		expect:
		project.errors['countries'] == 'minSize'
		
		where:
		project = new Project(countries:[])
		
	}
	
	def "project should be managed by project manager"() {
		setup:
		project.validate()
		
		expect:
		project.errors['projectManager'] == 'validator'
		
		where:
		consultant = new Role(name: 'CONSULTANT')
		project = new Project(projectManager: new User(roles : [consultant]))
	}
	
	def "project end date should be after start date"() {
		setup:
		project.validate()
		
		expect:
		project.errors['endDate'] == 'validator'
		
		where:
		project = new Project(
			startDate: Date.parse(DATE_FORMAT, '10/05/2013'), 
			endDate: Date.parse(DATE_FORMAT, '01/05/2013')
		)
	}
	
	def "project status should be open when only start date is set"() {
		expect:
		project.getStatus() == Project.Status.open
		
		where:
		project = new Project(
			startDate: Date.parse(DATE_FORMAT, '01/05/2013'),
			endDate: null
		)
	}
	
	def "project status should be clsed when end date is set"() {
		expect:
		project.getStatus() == Project.Status.closed
		
		where:
		project = new Project(
						startDate: Date.parse(DATE_FORMAT, '01/05/2013'), 
						endDate: Date.parse(DATE_FORMAT, '10/05/2013'))
	}
}
