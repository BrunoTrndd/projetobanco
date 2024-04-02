package br.udesc.pro2.exercicio.projeto.bb;

import br.udesc.pro2.exercicio.projeto.bb.exceptions.SaldoInsuficienteException;
import br.udesc.pro2.exercicio.projeto.bb.repositorio.ContaRepositorio;
import br.udesc.pro2.exercicio.projeto.bb.service.TransacaoService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransacaoServiceTest {

    @Test
    public void deveLancarExcecaoQuandoSaldoInsuficiente() {
        // Arrange
        ContaRepositorio repositorio = mock(ContaRepositorio.class);
        TransacaoService service = new TransacaoService(repositorio);
        Long clienteId = 1L;
        double valorTransacao = 500.0;

        when(repositorio.obterSaldoCliente(clienteId)).thenReturn(100.0); // Saldo insuficiente

        // Act & Assert
        SaldoInsuficienteException excecao = assertThrows(SaldoInsuficienteException.class, () -> {
            service.realizarTransacao(clienteId, valorTransacao);
        });

        // Mensagem da exceção
        assertEquals("Saldo insuficiente para realizar a transação", excecao.getMessage());
    }

}
