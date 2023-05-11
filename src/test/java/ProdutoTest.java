import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Thiago Cotta", "Bom Pastor 243, Juiz de Fora - MG");
    }

    // produto Pagamento Confirmado

    @Test
    public void naoDeveConfirmarPagamentoProdutoPago() {
        produto.setEstado(ProdutoEtapaEntregaPagamentoConfirmado.getInstance());
        assertFalse(produto.pagamentoConfirmado());
    }

    @Test
    public void deveSepararProdutoPago() {
        produto.setEstado(ProdutoEtapaEntregaPagamentoConfirmado.getInstance());
        assertTrue(produto.separar());
        assertEquals(ProdutoEtapaEntregaSeparacao.getInstance(), produto.getEtapa());
    }

    @Test
    public void naoDeveDespacharProdutoPago() {
        produto.setEstado(ProdutoEtapaEntregaPagamentoConfirmado.getInstance());
        assertFalse(produto.despachar());
    }

    @Test
    public void naoDeveFinalizarProdutoPago() {
        produto.setEstado(ProdutoEtapaEntregaPagamentoConfirmado.getInstance());
        assertFalse(produto.finalizar());
    }

    @Test
    public void naoDeveSairParaEntregaProdutoPago() {
        produto.setEstado(ProdutoEtapaEntregaPagamentoConfirmado.getInstance());
        assertFalse(produto.sairParaEntrega());
    }

    @Test
    public void naoDeveTransferirProdutoPago() {
        produto.setEstado(ProdutoEtapaEntregaPagamentoConfirmado.getInstance());
        assertFalse(produto.transferir());
    }

    // Produto Despachado

    @Test
    public void naoDeveDespacharProdutoDespachado() {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        assertFalse(produto.despachar());
    }

    @Test
    public void naoDeveConfirmarPagamentoProdutoDespachado() {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        assertFalse(produto.pagamentoConfirmado());
    }

    @Test
    public void naoDeveFinalizarProdutoDespachado() {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        assertFalse(produto.finalizar());
    }

    @Test
    public void naoDeveSepararProdutoDespachado() {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        assertFalse(produto.separar());
    }

    @Test
    public void deveTransferirProdutoDespachado() {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        assertTrue(produto.transferir());
        assertEquals(ProdutoEtapaEntregaTransferido.getInstance(), produto.getEtapa());
    }

    @Test
    public void deveSairParaEntregaProdutoDespachado() {
        produto.setEstado(ProdutoEtapaEntregaDespachado.getInstance());
        assertTrue(produto.sairParaEntrega());
        assertEquals(ProdutoEtapaEntregaRotaDeEntrega.getInstance(), produto.getEtapa());
    }

    // Produto Separado

    @Test
    public void naoSairParaEntregaProdutoSeparado() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.sairParaEntrega());
    }

    @Test
    public void naoDeveConfirmarPagamentoProdutoSeparado() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.pagamentoConfirmado());
    }

    @Test
    public void naoDeveFinalizarProdutoSeparado() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.finalizar());
    }

    @Test
    public void naoDeveSepararProdutoSeparado() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.separar());
    }

    @Test
    public void naoDeveTransferirProdutoSeparado() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.transferir());
    }

    @Test
    public void deveSairParaDespacharProdutoSeparado() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertTrue(produto.despachar());
        assertEquals(ProdutoEtapaEntregaDespachado.getInstance(), produto.getEtapa());
    }

    // Produto Transferido

    @Test
    public void naoDeveConfirmarPagamentoProdutoTransferido() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.pagamentoConfirmado());
    }

    @Test
    public void naoDeveFinalizarProdutoTransferido() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.finalizar());
    }

    @Test
    public void naoDeveSepararProdutoTransferido() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.separar());
    }

    @Test
    public void naoDeveTransferirProdutoTransferido() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.transferir());
    }

    @Test
    public void naoDespacharProdutoTransferido() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertFalse(produto.sairParaEntrega());
    }

    @Test
    public void deveSairParaEntregaProdutoTransferido() {
        produto.setEstado(ProdutoEtapaEntregaSeparacao.getInstance());
        assertTrue(produto.despachar());
        assertEquals(ProdutoEtapaEntregaDespachado.getInstance(), produto.getEtapa());
    }

    // Produto RotaDeEntrega

    @Test
    public void naoDeveConfirmarPagamentoProdutoRotaDeEntrega() {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        assertFalse(produto.pagamentoConfirmado());
    }

    @Test
    public void naoDeveSairParaEntregaProdutoRotaDeEntrega() {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        assertFalse(produto.sairParaEntrega());
    }

    @Test
    public void naoDeveSepararProdutoRotaDeEntrega() {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        assertFalse(produto.separar());
    }

    @Test
    public void naoDeveTransferirProdutoRotaDeEntrega() {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        assertFalse(produto.transferir());
    }

    @Test
    public void naoDespacharProdutoRotaDeEntrega() {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        assertFalse(produto.sairParaEntrega());
    }

    @Test
    public void deveFinalizarProdutoRotaDeEntrega() {
        produto.setEstado(ProdutoEtapaEntregaRotaDeEntrega.getInstance());
        assertTrue(produto.finalizar());
        assertEquals(ProdutoEtapaEntregaFinalizado.getInstance(), produto.getEtapa());
    }

    // Produto Finalizado

    @Test
    public void naoDeveConfirmarPagamentoProdutoFinalizado() {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        assertFalse(produto.pagamentoConfirmado());
    }

    @Test
    public void naoDeveSairParaEntregaProdutoFinalizado() {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        assertFalse(produto.sairParaEntrega());
    }

    @Test
    public void naoDeveSepararProdutoFinalizado() {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        assertFalse(produto.separar());
    }

    @Test
    public void naoDeveTransferirProdutoFinalizado() {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        assertFalse(produto.transferir());
    }

    @Test
    public void naoDespacharProdutoFinalizado() {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        assertFalse(produto.sairParaEntrega());
    }

    @Test
    public void naoDeveFinalizarProdutoFinalizado() {
        produto.setEstado(ProdutoEtapaEntregaFinalizado.getInstance());
        assertFalse(produto.finalizar());
    }
}