package helloworld

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EstoqueServiceSpec extends Specification {

    EstoqueService estoqueService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Estoque(...).save(flush: true, failOnError: true)
        //new Estoque(...).save(flush: true, failOnError: true)
        //Estoque estoque = new Estoque(...).save(flush: true, failOnError: true)
        //new Estoque(...).save(flush: true, failOnError: true)
        //new Estoque(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //estoque.id
    }

    void "test get"() {
        setupData()

        expect:
        estoqueService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Estoque> estoqueList = estoqueService.list(max: 2, offset: 2)

        then:
        estoqueList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        estoqueService.count() == 5
    }

    void "test delete"() {
        Long estoqueId = setupData()

        expect:
        estoqueService.count() == 5

        when:
        estoqueService.delete(estoqueId)
        sessionFactory.currentSession.flush()

        then:
        estoqueService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Estoque estoque = new Estoque()
        estoqueService.save(estoque)

        then:
        estoque.id != null
    }
}
