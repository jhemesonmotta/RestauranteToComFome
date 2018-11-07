package helloworld

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PratoController {
    PratoService pratoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pratoService.list(params), model:[pratoCount: pratoService.count()]
    }

    def show(Long id) {
        respond pratoService.get(id)
    }

    def create() {
        respond new Prato(params)
    }

    def save(Prato prato) {
        if (prato == null) {
            notFound()
            return
        }

        try {
            pratoService.save(prato)
        } catch (ValidationException e) {
            respond prato.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'prato.label', default: 'Prato'), prato.id])
                redirect prato
            }
            '*' { respond prato, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pratoService.get(id)
    }

    def update(Prato prato) {
        if (prato == null) {
            notFound()
            return
        }

        try {
            pratoService.save(prato)
        } catch (ValidationException e) {
            respond prato.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'prato.label', default: 'Prato'), prato.id])
                redirect prato
            }
            '*'{ respond prato, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pratoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'prato.label', default: 'Prato'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'prato.label', default: 'Prato'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
