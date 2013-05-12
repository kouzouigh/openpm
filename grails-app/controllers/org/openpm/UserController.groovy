package org.openpm

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

class UserController {
	
	def index() {}
	
	def edit = {
		def username = SecurityUtils.subject.principals.oneByType(String)
		def user = User.findByUsername(username)
		if( !user ) {
			flash.message = "User ${params.id} not found"
		}
		def countries = Country.findAll()
		[user:user, countries: countries]
	}

	def login(LoginCommand cmd) {
		if(request.method == 'POST') {
			if(!cmd.hasErrors()) {
				session.user = cmd.getUser()
				redirect controller:'project'
			}
			else {
				render view:'/index', model:[loginCmd:cmd]
			}
		}
		else {
			render view:'/index'
		}
	}
}

class LoginCommand {
	String email
	String password
	private u
	User getUser() {
		if(!u && email) {
			u = User.findByEmail(email)
		}
		return u
	}
	static constraints = {
		email blank:false, validator:{ val, cmd ->
			if(!cmd.user) {
				return "user.not.found"
			}
		}
		password blank:false, validator:{ val, cmd ->
			if(cmd.user && cmd.user.password != val) {
				return "user.password.invalid"
			}
		}
	}
}
