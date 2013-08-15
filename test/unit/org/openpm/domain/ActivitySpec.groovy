package org.openpm.domain

import grails.test.mixin.*
import org.junit.*
import org.openpm.Activity;

import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Activity)
class ActivitySpec extends Specification {

	static final String DATE_FORMAT = 'dd/MM/yyyy'
	
	void setup() {
		mockForConstraintsTests(Activity)
	}

	def "start date is mandatory"() {
		setup:
		activity.validate()
		
		expect:
		activity.errors['startDate'] == 'nullable'
		
		where:
		activity = new Activity(startDate: null)
	}
	
	def "activity name length should be greater than 3"() {
		setup:
		activity.validate()
		
		expect:
		activity.errors['name'] == 'minSize'
		
		where:
		activity = new Activity(name: 'AC')
	}
	
	def "country is mandatory"() {
		setup:
		activity.validate()
		
		expect:
		activity.errors['name'] == 'nullable'
		
		where:
		activity = new Activity(country: null)
	}
	
	def "consultant is mandatory"() {
		setup:
		activity.validate()
		
		expect:
		activity.errors['consultant'] == 'nullable'
		
		where:
		activity = new Activity(consultant: null)
	}
	
	def "activity msut be relate to a project"() {
		setup:
		activity.validate()
		
		expect:
		activity.errors['project'] == 'nullable'
		
		where:
		activity = new Activity(project: null)
	}
	
	def "activity charge rate is mandatory"() {
		setup:
		activity.validate()
		
		expect:
		activity.errors['hourlyChargeRate'] == 'nullable'
		
		where:
		activity = new Activity(hourlyChargeRate: null)
	}	
	
	def "activity has status closed if end date is set"() {
		expect:
		activity.status == Activity.Status.Closed
		
		where:
		activity = new Activity(startDate: Date.parse(DATE_FORMAT, '01/08/2013'),
			endDate: Date.parse(DATE_FORMAT, '10/08/2013'))
	}
	
	def "activity has status open if end date is not set"() {
		expect:
		activity.status == Activity.Status.Open
		
		where:
		activity = new Activity(startDate: Date.parse(DATE_FORMAT, '01/08/2013'))
	}
	
}
