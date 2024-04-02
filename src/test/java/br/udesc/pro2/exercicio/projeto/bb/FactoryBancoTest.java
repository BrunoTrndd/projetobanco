package br.udesc.pro2.exercicio.projeto.bb;

import br.udesc.pro2.exercicio.projeto.bb.factory.banco.BancoDoBrasilFactory;
import br.udesc.pro2.exercicio.projeto.bb.factory.banco.IFactoryBanco;
import br.udesc.pro2.exercicio.projeto.bb.model.banco.IBanco;
import br.udesc.pro2.exercicio.projeto.bb.model.banco.ModelBancoDoBrasil;
import br.udesc.pro2.exercicio.projeto.bb.model.banco.ModelBancoItau;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FactoryBancoTest {

    @Test
    public void deveCriarBancoDoBrasil() {
        //Arrange
        IFactoryBanco factory = mock(BancoDoBrasilFactory.class);
        IBanco banco1 = new ModelBancoDoBrasil("BB");
        IBanco banco2 = new ModelBancoItau("Itaú da XV");
        String nome = "nome";
        when(factory.criarBanco(nome)).thenReturn(banco1, banco2);

        //Act
        IBanco bancoDoBrasil = factory.criarBanco(nome);
        IBanco bancoItau = factory.criarBanco(nome);
        //Assert
        assertTrue(bancoDoBrasil instanceof ModelBancoDoBrasil);
        assertFalse(bancoItau instanceof ModelBancoDoBrasil);
    }

}
