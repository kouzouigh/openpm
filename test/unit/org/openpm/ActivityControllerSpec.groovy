package org.openpm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Activity, User, Country, Project])
@TestFor(ActivityController)
class ActivityControllerSpec extends Specification {

	void "test save succes"() {
		given:
		new User(id:1).save(flush:true, validate:false)
		new Country(id:1).save(flush:true, validate:false)
		new Project(id:1).save(flush:true, validate:false)
		
		request.method = "POST"
		params['project.id'] = 1
		params.name = 'Control activity'
		params['consultant.id'] = 1
		params['country.id'] = 1
		params.hourlyChargeRate = '100'
		params.startDate_month = '8'
		params.startDate_day = '15'
		params.startDate_year = '2013'
		
		when:
		controller.save()
		
		then:
		response.redirectedUrl == "/activity/list"
	}
	
	void "test save fails"() {
		given:
		new User(id:1).save(flush:true, validate:false)
		request.method = "POST"
		params.name = 'Control activity'
		params['consultant.id'] = 1
		params.hourlyChargeRate = '100'
		
		when:
		controller.save()
		
		then:
		view == '/activity/create'
		model.activityInstance.hasErrors()
	}
}