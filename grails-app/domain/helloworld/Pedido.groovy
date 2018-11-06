package helloworld

class Pedido {
    
    Date dataHora
    Double valorTotal
    
    Cliente ciente
    
    static hasMany = [itens: ItemPedido]
    
    static constraints = {
    }
}
