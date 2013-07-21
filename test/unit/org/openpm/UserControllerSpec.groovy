package org.openpm

import grails.test.*
import spock.lang.Specification

@Mock(User)
@TestFor(UserController)
class UserControllerSpec extends Specification {

	void "Test edit with no id"() {
		when:"A GET request is issued with no id"
		request.method = "GET"
		controller.edit()
		
		then:"The not found page is rendered"
		response.status == 404
	}
	
}
