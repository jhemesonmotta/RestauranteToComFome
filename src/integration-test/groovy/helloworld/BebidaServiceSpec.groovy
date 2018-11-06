package helloworld

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BebidaServiceSpec extends Specification {

    BebidaService bebidaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Bebida(...).save(flush: true, failOnError: true)
        //new Bebida(...).save(flush: true, failOnError: true)
        //Bebida bebida = new Bebida(...).save(flush: true, failOnError: true)
        //new Bebida(...).save(flush: true, failOnError: true)
        //new Bebida(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bebida.id
    }

    void "test get"() {
        setupData()

        expect:
        bebidaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Bebida> bebidaList = bebidaService.list(max: 2, offset: 2)

        then:
        bebidaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bebidaService.count() == 5
    }

    void "test delete"() {
        Long bebidaId = setupData()

        expect:
        bebidaService.count() == 5

        when:
        bebidaService.delete(bebidaId)
        sessionFactory.currentSession.flush()

        then:
        bebidaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Bebida bebida = new Bebida()
        bebidaService.save(bebida)

        then:
        bebida.id != null
    }
}
