package org.example;
public class ProdutoEtapaEntregaFinalizado extends ProdutoEtapaEntrega {

    private ProdutoEtapaEntregaFinalizado() {};
    private static ProdutoEtapaEntregaFinalizado instance = new ProdutoEtapaEntregaFinalizado();
    public static ProdutoEtapaEntregaFinalizado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Finalizado";
    }
}
