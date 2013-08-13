package org.openpm

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

class UserController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	static defaultAction = 'list'
	
	def edit() {
		def userInstance = User.get(params.id)

		if (!userInstance) {
			render status:404
			return
		}
		[userInstance:userInstance]
	}
	
	def profile() {
		def username = SecurityUtils.subject.principals.oneByType(String)
		println username
		def userInstance = User.findByUsername(username)
		if( !userInstance ) {
			flash.message = "User ${params.id} not found"
		}
		[userInstance:userInstance]
	}
	
	def create() {
		[userInstance: new User()]
	}
	
	def save() {
		def user = new User(params)
		if( user.save() ) {
			redirect(action: "list")
		}
		render view:'create', model: [userInstance: user]
	}
	
	def update() {
		def userInstance = User.get(params.id)
		if( userInstance ) {
			if( params.version ) {
				def version = params.version.toLong()
				if( userInstance.version > version) {
					userInstance.errors.rejectValue("version", "user.optimistic.locking.failure", "Another user has updated this Client while you were editing.")
					render(view: 'edit', model:[clientInstance:userInstance])
					return
				}
			}
			userInstance.properties = params
			if( userInstance.save() ) {
				flash.message = "User updated"
				redirect(action:'edit')
			}
		}
	}
	
	def list() {
		[users: User.findAll()]
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
