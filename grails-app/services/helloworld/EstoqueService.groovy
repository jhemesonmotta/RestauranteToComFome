package helloworld

import grails.gorm.services.Service

@Service(Estoque)
interface EstoqueService {

    Estoque get(Serializable id)

    List<Estoque> list(Map args)

    Long count()

    void delete(Serializable id)

    Estoque save(Estoque estoque)

}