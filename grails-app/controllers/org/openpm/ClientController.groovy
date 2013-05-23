package org.openpm

class ClientController {

	static defaultAction = "list"
	
    def list() {
		def clients = []
		clients.add(new Client(name:'Google', contactName:'Google customer', email:'admin@google.com'))
		clients.add(new Client(name:'Microsoft', contactName:'Microsoft customer', email:'admin@microsoft.com'))
		clients.add(new Client(name:'Zynga', contactName:'Zynga customer', email:'admin@zynga.com'))
		clients.add(new Client(name:'Yahoo', contactName:'Dupont customer', email:'admin@yahoo.com'))
		clients.add(new Client(name:'VM Ware', contactName:'VM Ware customer',  email:'admin@vmware.com'))
		clients.add(new Client(name:'Oracle', contactName:'Oracle customer', email:'admin@oracle.com'))
		clients.add(new Client(name:'10 gen', contactName:'10gen customer', email:'admin@10gen.com'))
		clients.add(new Client(name:'JBoss', contactName:'JBoss customer', email:'admin@jboss.org'))
		
		[clients: clients]
	}
	
	def create() {
		def clientInstance = new Client();
		[clientInstance: clientInstance]
	}
	
	def save() {
		Client client = new Client(params)
		if( client.save() ) {
			redirect(action: "list")
		}
		println client.errors
		render view:'create', model: [clientInstance: client]
	}
}
