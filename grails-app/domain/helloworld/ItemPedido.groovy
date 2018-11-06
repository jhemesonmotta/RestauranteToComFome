package helloworld

class ItemPedido {

    int quantidade
    double valorVenda
    String observacao
    
    Produto produto
    Pedido pedido
    
    static belongsTo = [Pedido]
    
    static constraints = {
    }
}
