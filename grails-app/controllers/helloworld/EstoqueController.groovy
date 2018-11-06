package helloworld

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EstoqueController {

    EstoqueService estoqueService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond estoqueService.list(params), model:[estoqueCount: estoqueService.count()]
    }

    def show(Long id) {
        respond estoqueService.get(id)
    }

    def create() {
        respond new Estoque(params)
    }

    def save(Estoque estoque) {
        if (estoque == null) {
            notFound()
            return
        }

        try {
            estoqueService.save(estoque)
        } catch (ValidationException e) {
            respond estoque.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'estoque.label', default: 'Estoque'), estoque.id])
                redirect estoque
            }
            '*' { respond estoque, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond estoqueService.get(id)
    }

    def update(Estoque estoque) {
        if (estoque == null) {
            notFound()
            return
        }

        try {
            estoqueService.save(estoque)
        } catch (ValidationException e) {
            respond estoque.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'estoque.label', default: 'Estoque'), estoque.id])
                redirect estoque
            }
            '*'{ respond estoque, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        estoqueService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'estoque.label', default: 'Estoque'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'estoque.label', default: 'Estoque'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
