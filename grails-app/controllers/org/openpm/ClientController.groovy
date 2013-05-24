package org.openpm

class ClientController {

	static defaultAction = "list"
	
    def list() {
		def clients = []
		clients.add(new Client(id:1, name:'Google', contactName:'Google customer', email:'admin@google.com'))
		clients.add(new Client(id:2, name:'Microsoft', contactName:'Microsoft customer', email:'admin@microsoft.com'))
		clients.add(new Client(id:3, name:'Zynga', contactName:'Zynga customer', email:'admin@zynga.com'))
		clients.add(new Client(id:4, name:'Yahoo', contactName:'Dupont customer', email:'admin@yahoo.com'))
		clients.add(new Client(id:5, name:'VM Ware', contactName:'VM Ware customer',  email:'admin@vmware.com'))
		clients.add(new Client(id:6, name:'Oracle', contactName:'Oracle customer', email:'admin@oracle.com'))
		clients.add(new Client(id:7, name:'10 gen', contactName:'10gen customer', email:'admin@10gen.com'))
		clients.add(new Client(id:8, name:'JBoss', contactName:'JBoss customer', email:'admin@jboss.org'))
		
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
}
