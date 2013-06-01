package org.openpm

class Invoice {
	
	enum Status {
		Todo,
		Sent,
		Paid,
		Outstranding
	}
	
	String name
	Client client
	Status status
	Project project
	InvoiceEvents events

    static constraints = {
		name blank:false
    }
}
