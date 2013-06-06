package org.openpm

class Invoice {
	
	enum Status {
		Todo,
		Sent,
		Paid,
		Outstanding
	}
	
	String name
	Client client
	Status status
	Project project
	InvoiceEvents event
	Integer terms

    static constraints = {
		name blank:false
		terms blank: false
    }
	
	Status getStatus() {
		if( event?.paidDate ) {
			return Status.Paid
		}
		if( event?.sentDate ) {
			return isOutstanding() ? Status.Outstanding : Status.Sent
		}
		return Status.Todo
	}
	
	private isOutstanding() {
		def now = new Date()
		def deadline = event.sentDate.plus(terms)
		now.after(deadline)
	}
}
