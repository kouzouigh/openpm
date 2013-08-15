package org.openpm

import grails.test.*
import groovy.mock.interceptor.MockFor;
import spock.lang.Specification
import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.PrincipalCollection
import org.apache.shiro.subject.Subject

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
		
		controller.params.id = userInstance.id
		
		expect:
		controller.edit() == [userInstance:userInstance]
		
		where:
		userInstance = new User(email:"kamel@site.com")
	}
	
	def "test user profile"() {
		setup:"a loggedIn user"
		userInstance.save(flush:true, validate:false)
		
		setupShiroSecurity()
		
		expect:
		controller.profile() == [userInstance:userInstance]
		
		where:
		userInstance = new User(username:"kamel", email:"kamel@site.com")
	}
	
	void setupShiroSecurity() {
		def subjectMock = mockFor(Subject)
		def principals = mockFor(PrincipalCollection)
		
		SecurityUtils.metaClass.static.getSubject = {
			subjectMock.createMock()
		}
		
		principals.demand.oneByType {
			return "kamel"
		}
		subjectMock.demand.getPrincipals {
			-> return principals.createMock()
		}
	}
	
}
