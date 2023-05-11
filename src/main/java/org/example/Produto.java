package org.example;
public class Produto {
    private String destinatario;
    private String endereco;
    private String codigoRastreio;
    private ProdutoEtapaEntrega etapa;

    public Produto(String destinatario, String endereco) {
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.etapa = ProdutoEtapaEntregaPagamentoConfirmado.getInstance();
    }
    
    public void setEstado(ProdutoEtapaEntrega estado) {
        this.etapa = estado;
    }
    
    public boolean pagamentoConfirmado() {
        return etapa.pagamentoConfirmado(this);
    }
    
    public boolean despachar() {
        return etapa.despachar(this);
    }
    
    public boolean finalizar() {
        return etapa.finalizar(this);
    }
    
    public boolean sairParaEntrega() {
        return etapa.sairParaEntrega(this);
    }
    
    public boolean separar() {
        return etapa.separar(this);
    }

    public boolean transferir() {
        return etapa.transferir(this);
    }

    public String getNomeEtapa() {
        return etapa.getEstado();
    }
    
    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getNomeDestinatario() {
        return etapa.getEstado();
    }

    public String getEndereco() {
        return codigoRastreio;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public void setCodigoRastreio(ProdutoEtapaEntrega etapa) {
        this.etapa = etapa;
    }

    public ProdutoEtapaEntrega getEtapa() {
        return etapa;
    }    
}
