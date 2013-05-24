package org.openpm

class ProjectController {
	
    def index() { 
		redirect (action: 'list')
	}
	
	def list () { 
		[projects: Project.findAll()]	
	}
	
	def create () {
		def project = new Project(client: new Client())
		[project: project, clients : Client.findAll()]
	}
	
	def update() {
		def project = Project.get(params.id)
		project.properties = params
		project.save()
	}
	
	def save() {
		def project = new Project(params)
		if( project.save() ) {
			redirect(action:'list')
		}
		render view: "create", model: [project: project]
	}
	
}
