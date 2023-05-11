package org.example;
public class ProdutoEtapaEntregaDespachado extends ProdutoEtapaEntrega {

    private ProdutoEtapaEntregaDespachado() {};
    private static ProdutoEtapaEntregaDespachado instance = new ProdutoEtapaEntregaDespachado();
    public static ProdutoEtapaEntregaDespachado getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Despachado";
    }
     
   public boolean transferir(Produto produto) {
         produto.setEstado(ProdutoEtapaEntregaTransferido.getInstance());
         return true;
   }
    public boolean sairParaEntrega(Produto produto) {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        return true;
    }
}

