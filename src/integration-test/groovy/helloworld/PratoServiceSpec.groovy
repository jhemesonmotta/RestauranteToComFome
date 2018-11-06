package helloworld

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PratoServiceSpec extends Specification {

    PratoService pratoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Prato(...).save(flush: true, failOnError: true)
        //new Prato(...).save(flush: true, failOnError: true)
        //Prato prato = new Prato(...).save(flush: true, failOnError: true)
        //new Prato(...).save(flush: true, failOnError: true)
        //new Prato(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //prato.id
    }

    void "test get"() {
        setupData()

        expect:
        pratoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Prato> pratoList = pratoService.list(max: 2, offset: 2)

        then:
        pratoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pratoService.count() == 5
    }

    void "test delete"() {
        Long pratoId = setupData()

        expect:
        pratoService.count() == 5

        when:
        pratoService.delete(pratoId)
        sessionFactory.currentSession.flush()

        then:
        pratoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Prato prato = new Prato()
        pratoService.save(prato)

        then:
        prato.id != null
    }
}
