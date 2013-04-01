package org.openpm

class UserController {
	
	def index() {}

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
