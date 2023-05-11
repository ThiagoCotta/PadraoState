package org.example;
public abstract class ProdutoEtapaEntrega {
    
    public abstract String getEstado();

    public boolean pagamentoConfirmado(Produto produto) {
        return false;
    }

    public boolean despachar(Produto produto) {
        return false;
    }

    public boolean finalizar(Produto produto) {
        return false;
    }

    public boolean sairParaEntrega(Produto produto) {
        return false;
    }

    public boolean separar(Produto produto) {
        return false;
    }

    public boolean transferir(Produto produto) {
        return false;
    }
    
}
