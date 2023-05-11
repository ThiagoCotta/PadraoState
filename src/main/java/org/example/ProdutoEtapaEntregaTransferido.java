package org.example;
public class ProdutoEtapaEntregaTransferido extends ProdutoEtapaEntrega {

    private ProdutoEtapaEntregaTransferido() {};
    private static ProdutoEtapaEntregaTransferido instance = new ProdutoEtapaEntregaTransferido();
    public static ProdutoEtapaEntregaTransferido getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Transferido";
    }

    public boolean sairParaEntrega(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        return true;
    }
}
