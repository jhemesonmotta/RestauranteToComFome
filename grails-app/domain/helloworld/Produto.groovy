package helloworld

class Produto {
    
    String nome
    double preco
    Estoque estoque
    // grails já entende que só é pra guardar o ID e manda essa infor para o hibernate
    
    static hasMany = [clientesQuePreferem: Cliente, itens: ItemPedido]
    
    static belongsTo = [Cliente]
    // significa que "Cliente" é o lado mais forte.
    
    static constraints = {
    }
}
