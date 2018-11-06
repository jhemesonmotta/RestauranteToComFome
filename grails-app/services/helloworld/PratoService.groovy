package helloworld

import grails.gorm.services.Service

@Service(Prato)
interface PratoService {

    Prato get(Serializable id)

    List<Prato> list(Map args)

    Long count()

    void delete(Serializable id)

    Prato save(Prato prato)

}