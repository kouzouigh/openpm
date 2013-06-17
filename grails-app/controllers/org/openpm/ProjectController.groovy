package org.openpm

class ProjectController {
	
	def userService
	
	def projectService
	
    def index() { 
		redirect (action: 'list')
	}
	
	def list () {
		[projects: Project.findAll()]	
	}
	
	def create () {
		def projectManagers = userService.findByRoleName('PROJECT_MANAGER')
		def project = new Project(client: new Client())
		[project: project, clients : Client.findAll(), projectManagers: projectManagers]
	}
	
	def edit() {
		def project = Project.get(params.id)
		[project: project]
	}
	
	def update() {
		def project = Project.get(params.id)
		project.properties = params
		project.save()
	}
	
	def view() {
		def project = projectService.fetch(params.long('id'))
		session.project = project
		forward controller: 'activity'
	}
	
	def save() {
		def project = new Project(params)
		if( project.save() ) {
			redirect(action:'list')
		}
		render view: "create", model: [project: project]
	}
	
}
