package org.openpm

class InvoiceController {

    def list() { 
		[invoices: Invoice.list()]
	}
}
