package helloworld

class Cliente {

    String nome
    String email
    String senha
    
    static hasMany = [pedidos:Pedido, produtosPreferidos:Produto]
    // pedidos
        // a nível de banco de dados, não é feito nada com o "hasMany", mas ele já identifica aqui,
        // pelo groovy, a lista de pedidos do cliente
    // produtosPreferidos representará uma relação many to many
    
    static constraints = {
    }
}
