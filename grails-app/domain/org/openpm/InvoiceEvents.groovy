package org.openpm

class InvoiceEvents {

	Date createdDate
	Date sentDate
	Date paidDate
	
    static constraints = {
		sentDate nullable: true
		paidDate nullable: true
    }
}
