package org.example;

public class ProdutoEtapaEntregaSeparacao extends ProdutoEtapaEntrega {

    private ProdutoEtapaEntregaSeparacao() {};
    private static ProdutoEtapaEntregaSeparacao instance = new ProdutoEtapaEntregaSeparacao();
    public static ProdutoEtapaEntregaSeparacao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Separação";
    }

    public boolean despachar(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        return true;
    }

}
