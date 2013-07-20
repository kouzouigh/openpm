package org.openpm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ChargeRate)
class ChargeRateSpec extends Specification {

	def setup() {
		mockForConstraintsTests(ChargeRate)
	}

	def cleanup() {
	}

	void "date should be not null"() {
		given:
		def chargeRate = new ChargeRate()
		
		when:
		chargeRate.validate()
		
		then:
		'nullable' == chargeRate.errors['date']
	}
	
	
}