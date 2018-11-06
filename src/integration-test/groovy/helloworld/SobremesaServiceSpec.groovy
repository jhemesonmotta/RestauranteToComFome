package helloworld

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SobremesaServiceSpec extends Specification {

    SobremesaService sobremesaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Sobremesa(...).save(flush: true, failOnError: true)
        //new Sobremesa(...).save(flush: true, failOnError: true)
        //Sobremesa sobremesa = new Sobremesa(...).save(flush: true, failOnError: true)
        //new Sobremesa(...).save(flush: true, failOnError: true)
        //new Sobremesa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sobremesa.id
    }

    void "test get"() {
        setupData()

        expect:
        sobremesaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Sobremesa> sobremesaList = sobremesaService.list(max: 2, offset: 2)

        then:
        sobremesaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sobremesaService.count() == 5
    }

    void "test delete"() {
        Long sobremesaId = setupData()

        expect:
        sobremesaService.count() == 5

        when:
        sobremesaService.delete(sobremesaId)
        sessionFactory.currentSession.flush()

        then:
        sobremesaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Sobremesa sobremesa = new Sobremesa()
        sobremesaService.save(sobremesa)

        then:
        sobremesa.id != null
    }
}
