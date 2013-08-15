package org.openpm.client

import grails.test.mixin.*
import org.junit.*
import org.openpm.Client;
import org.openpm.ClientController;
import org.openpm.Country;

import spock.lang.Specification;

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Client, Country])
@TestFor(ClientController)
class ClientControllerSpec extends Specification {

	def setup() {
		new Country(id:1).save(validate:false)
	}
	
    def "test save client"() {
		given:
		request.method = "POST"
		params.name = 'VMware'
		params.contatcName = 'Dupont Dupond'
		params.email = 'contact@vmware.com'
		params["country.id"] = '1'
		
		when:
		controller.save()
		
		then:
		response.redirectedUrl == '/client/list'	
	}
}
