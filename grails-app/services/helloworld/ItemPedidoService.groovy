package helloworld

import grails.gorm.services.Service

@Service(ItemPedido)
interface ItemPedidoService {

    ItemPedido get(Serializable id)

    List<ItemPedido> list(Map args)

    Long count()

    void delete(Serializable id)

    ItemPedido save(ItemPedido itemPedido)

}