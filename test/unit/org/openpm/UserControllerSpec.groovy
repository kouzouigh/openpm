package org.openpm

import grails.test.*
import spock.lang.Specification

@Mock(User)
@TestFor(UserController)
class UserControllerSpec extends Specification {

	def "Test edit with no id"() {
		setup:
		request.method = "GET"
		
		when:"A request is issued with no id"
		controller.edit()
		
		then:
		response.status == 404
	}
	
	def "Test edit with valid user id"() {
		setup: "an existing user"
		userInstance.save(flush:true, validate:false)
		
		and:"his id is passed as parameter"
		controller.params.id = userInstance.id
		
		expect:
		controller.edit() == [userInstance:userInstance]
		
		where:
		userInstance = new User(email:"kamel@site.com")
	}
	
}
