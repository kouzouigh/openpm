package org.openpm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Activity, User])
@TestFor(ActivityController)
class ActivityControllerSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "test save succes"() {
		given:
		new User(id:1).save(flush:true, validate:false)
		request.method = "POST"
		params.name = 'Control activity'
		params['consultant.id'] = 1
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