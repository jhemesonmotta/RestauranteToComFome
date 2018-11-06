package helloworld

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SobremesaController {

    SobremesaService sobremesaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sobremesaService.list(params), model:[sobremesaCount: sobremesaService.count()]
    }

    def show(Long id) {
        respond sobremesaService.get(id)
    }

    def create() {
        respond new Sobremesa(params)
    }

    def save(Sobremesa sobremesa) {
        if (sobremesa == null) {
            notFound()
            return
        }

        try {
            sobremesaService.save(sobremesa)
        } catch (ValidationException e) {
            respond sobremesa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sobremesa.label', default: 'Sobremesa'), sobremesa.id])
                redirect sobremesa
            }
            '*' { respond sobremesa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sobremesaService.get(id)
    }

    def update(Sobremesa sobremesa) {
        if (sobremesa == null) {
            notFound()
            return
        }

        try {
            sobremesaService.save(sobremesa)
        } catch (ValidationException e) {
            respond sobremesa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sobremesa.label', default: 'Sobremesa'), sobremesa.id])
                redirect sobremesa
            }
            '*'{ respond sobremesa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sobremesaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sobremesa.label', default: 'Sobremesa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sobremesa.label', default: 'Sobremesa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
