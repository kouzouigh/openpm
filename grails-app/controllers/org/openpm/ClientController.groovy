package org.openpm

class ClientController {

	static defaultAction = "list"
	
    def list() {
		[clients: Client.findAll() ]
	}
	
	def create() {
		def clientInstance = new Client();
		[clientInstance: clientInstance]
	}
	
	def edit() {
		def clientInstance = Client.get(params.id)
		[clientInstance: clientInstance]
	}
	
	def save() {
		Client client = new Client(params)
		if( client.save() ) {
			redirect(action: "list")
		}
		render view:'create', model: [clientInstance: client]
	}

	def update () {
		def clientInstance = Client.get( params.id )
		if( clientInstance ) {
			if( params.version ) {
				def version = params.version.toLong()
				if( clientInstance.version > version ) {
					clientInstance.errors.rejectValue("version", "client.optimistic.locking.failure", "Another user has updated this Client while you were editing.")
					render(view: 'edit', model:[clientInstance:clientInstance])
					return
				}
			}
			clientInstance.properties = params
			if( !clientInstance.hasErrors() && clientInstance.save() ) {
				flash.message = "Client ${params.name} updated"
				redirect(action:'list')
			}
		}	
	}
	
	def deleteConfirmation() {
		def clientInstance = Client.get(params.id)
		println clientInstance
		render template: '/common/deleteModal', 
			   model: [ clientInstance: clientInstance,
				   	   'headerTitle': 'Deleting client', 
				   	   'bodyContent': "Are you sure about to delete client <b>${clientInstance.name}</b>"]
	}
	
	def delete() {
		def clientInstance = Client.get(params.id)
		if( clientInstance ) {
			clientInstance.delete()
		}
		redirect(action:'list')
	}
}
