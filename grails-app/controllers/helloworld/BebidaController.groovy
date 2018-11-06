package helloworld

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BebidaController {
    String nomeDaFuncionalidade = "Bebidas"
    BebidaService bebidaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bebidaService.list(params), model:[bebidaCount: bebidaService.count()]
    }

    def show(Long id) {
        respond bebidaService.get(id)
    }

    def create() {
        respond new Bebida(params)
    }

    def save(Bebida bebida) {
        if (bebida == null) {
            notFound()
            return
        }

        try {
            bebidaService.save(bebida)
        } catch (ValidationException e) {
            respond bebida.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bebida.label', default: 'Bebida'), bebida.id])
                redirect bebida
            }
            '*' { respond bebida, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bebidaService.get(id)
    }

    def update(Bebida bebida) {
        if (bebida == null) {
            notFound()
            return
        }

        try {
            bebidaService.save(bebida)
        } catch (ValidationException e) {
            respond bebida.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bebida.label', default: 'Bebida'), bebida.id])
                redirect bebida
            }
            '*'{ respond bebida, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bebidaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bebida.label', default: 'Bebida'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bebida.label', default: 'Bebida'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
