package helloworld

import grails.gorm.services.Service

@Service(Sobremesa)
interface SobremesaService {

    Sobremesa get(Serializable id)

    List<Sobremesa> list(Map args)

    Long count()

    void delete(Serializable id)

    Sobremesa save(Sobremesa sobremesa)

}