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
	InvoiceEvents event

    static constraints = {
		name blank:false
    }
	
	Status getStatus() {
		if( event?.paidDate ) {
			return Status.Paid
		}
		if( event?.sentDate ) {
			return Status.Sent
		}
		return Status.Todo
	}
}
