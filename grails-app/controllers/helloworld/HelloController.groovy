package helloworld

class HelloController {

    def index() {
        // The action is simply a method. In this particular case, it calls a special method provided by Grails to render the page.
        render "Hello World!"
    }
}
