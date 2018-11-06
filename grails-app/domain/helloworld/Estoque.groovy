package helloworld

class Estoque {
    
    int quantidade
    int quantidadeMinima
    Produto produto
    // grails já entende que só é pra guardar o ID e manda essa infor para o hibernate
    
    static constraints = {
    }
}
