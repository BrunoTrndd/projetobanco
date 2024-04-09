package br.udesc.pro2.exercicio.projeto.bb.service.transacao;

import br.udesc.pro2.exercicio.projeto.bb.model.conta.ModelContaPoupanca;
import br.udesc.pro2.exercicio.projeto.bb.repositorio.ContaRepositorio;
import br.udesc.pro2.exercicio.projeto.bb.service.transacao.bo.ModelTransacaoBo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransacaoServiceTest {

    @Mock
    private ContaRepositorio repositorio;

    @Spy
    @InjectMocks
    private ModelTransacaoBo boSpy;

    private TransacaoService service;

    @Before
    public void setUp() {
        service = new TransacaoService(repositorio, boSpy);
    }

    @Test
    public void deveValidarSaldoNaTransacao() {
        // Arrange
        ModelContaPoupanca contaOrigem = new ModelContaPoupanca();
        ModelContaPoupanca contaDestino = new ModelContaPoupanca();
        contaOrigem.setCodigo(1);
        contaDestino.setCodigo(2);
        double valorTransacao = 500.0;

        when(repositorio.obterSaldoCliente(contaOrigem)).thenReturn(100.0); // Saldo insuficiente

        // Act
        String resultado = service.realizarTransacao(contaOrigem, contaDestino, valorTransacao);

        // Assert
        assertEquals("Saldo insuficiente para realizar a transação", resultado);
    }

    @Test
    public void deveAuditarTransacaoAposProcessamento() {
        // Arrange
        ModelContaPoupanca contaOrigem = mock(ModelContaPoupanca.class);
        ModelContaPoupanca contaDestino = mock(ModelContaPoupanca.class);
        contaOrigem.setCodigo(1);
        contaDestino.setCodigo(2);
        double valorTransacao = 500.0;

        when(repositorio.obterSaldoCliente(contaOrigem)).thenReturn(1000.0); // Saldo válido
        doNothing().when(boSpy).auditarTransacao();

        // Processar a transação
        service.realizarTransacao(contaOrigem, contaDestino, valorTransacao);

        // Verificar se o método auditarTransacao foi chamado corretamente
        verify(boSpy).auditarTransacao();
    }
}
