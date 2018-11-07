package helloworld

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ItemPedidoController {
    ItemPedidoService itemPedidoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond itemPedidoService.list(params), model:[itemPedidoCount: itemPedidoService.count()]
    }

    def show(Long id) {
        respond itemPedidoService.get(id)
    }

    def create() {
        respond new ItemPedido(params)
    }

    def save(ItemPedido itemPedido) {
        if (itemPedido == null) {
            notFound()
            return
        }

        try {
            itemPedidoService.save(itemPedido)
        } catch (ValidationException e) {
            respond itemPedido.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itemPedido.label', default: 'ItemPedido'), itemPedido.id])
                redirect itemPedido
            }
            '*' { respond itemPedido, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond itemPedidoService.get(id)
    }

    def update(ItemPedido itemPedido) {
        if (itemPedido == null) {
            notFound()
            return
        }

        try {
            itemPedidoService.save(itemPedido)
        } catch (ValidationException e) {
            respond itemPedido.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'itemPedido.label', default: 'ItemPedido'), itemPedido.id])
                redirect itemPedido
            }
            '*'{ respond itemPedido, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        itemPedidoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemPedido.label', default: 'ItemPedido'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemPedido.label', default: 'ItemPedido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
