package org.example;
public class ProdutoEtapaEntregaRotaDeEntrega extends ProdutoEtapaEntrega {

    private ProdutoEtapaEntregaRotaDeEntrega() {};
    private static ProdutoEtapaEntregaRotaDeEntrega instance = new ProdutoEtapaEntregaRotaDeEntrega();
    public static ProdutoEtapaEntregaRotaDeEntrega getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Em rota de entrega";
    }

    public boolean finalizar(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        return true;
    }
}
