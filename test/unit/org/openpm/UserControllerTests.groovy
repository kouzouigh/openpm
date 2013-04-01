package org.openpm

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock(User)
class UserControllerTests {

  void testLoginUserNotFound() {
		request.method = 'POST'
		
		params.email = 'kamel@openpm.org'
		params.password = 'password'
		
		controller.login()
		def cmd = model.loginCmd
		
		assert cmd.hasErrors()
		assert 'user.not.found' == cmd.errors['email'].code
		assert session.user == null
		assert '/index' == view
	}
  
  void testLoginFailurePasswordInvalid() {
	  request.method = 'POST'
	  
	  def user = new User(email:'kamel@openpm.org', password: 'openpm').save()
	  
	  assert user != null
	  
	  params.email = 'kamel@openpm.org'
	  params.password = 'password'
	  
	  controller.login()
	  def cmd = model.loginCmd
	  
	  assert cmd.hasErrors()
	  assert 'user.password.invalid' == cmd.errors['password'].code
	  assert session.user == null
	  assert '/index' == view
  }
  
  void testLoginSuccess() {
	  request.method = 'POST'
	  
	  def user = new User(email:'kamel@openpm.org', password: 'openpm').save()
	  
	  assert user != null
	  
	  params.email = 'kamel@openpm.org'
	  params.password = 'openpm'
	  
	  controller.login()
	  
	  assert session.user != null
	  assert '/project' == response.redirectedUrl
  }
}
