package org.openpm.invoice



import grails.test.mixin.*
import org.junit.*
import org.openpm.InvoiceEvents
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(InvoiceEvents)
class InvoiceEventsSpec extends Specification {

    void setup() {
        mockForConstraintsTests(InvoiceEvents)
    }

    @Unroll
    def "property #property is mandatory"() {
        setup:
        def event = new InvoiceEvents("$property": null)
        event.validate()

        expect:
        event.errors["$property"] == 'nullable'

        where:
        property        |_
        "createdDate"   |_

    }
}
