package org.example;
public class ProdutoEtapaEntregaPagamentoConfirmado extends ProdutoEtapaEntrega {

    private ProdutoEtapaEntregaPagamentoConfirmado() {};
    private static ProdutoEtapaEntregaPagamentoConfirmado instance = new ProdutoEtapaEntregaPagamentoConfirmado();
    public static ProdutoEtapaEntregaPagamentoConfirmado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pagamento confirmado";
    }
    
    public boolean despachar(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        return false;
    }
    
    public boolean finalizar(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        return false;
    }
    
    public boolean sairParaEntrega(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        return false;
    }
    
    public boolean separar(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        return true;
    }

    public boolean transferir(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaTransferido.getInstance());
        return false;
    }

}
