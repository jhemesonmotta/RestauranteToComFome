package helloworld

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ItemPedidoServiceSpec extends Specification {

    ItemPedidoService itemPedidoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ItemPedido(...).save(flush: true, failOnError: true)
        //new ItemPedido(...).save(flush: true, failOnError: true)
        //ItemPedido itemPedido = new ItemPedido(...).save(flush: true, failOnError: true)
        //new ItemPedido(...).save(flush: true, failOnError: true)
        //new ItemPedido(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //itemPedido.id
    }

    void "test get"() {
        setupData()

        expect:
        itemPedidoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ItemPedido> itemPedidoList = itemPedidoService.list(max: 2, offset: 2)

        then:
        itemPedidoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemPedidoService.count() == 5
    }

    void "test delete"() {
        Long itemPedidoId = setupData()

        expect:
        itemPedidoService.count() == 5

        when:
        itemPedidoService.delete(itemPedidoId)
        sessionFactory.currentSession.flush()

        then:
        itemPedidoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ItemPedido itemPedido = new ItemPedido()
        itemPedidoService.save(itemPedido)

        then:
        itemPedido.id != null
    }
}
