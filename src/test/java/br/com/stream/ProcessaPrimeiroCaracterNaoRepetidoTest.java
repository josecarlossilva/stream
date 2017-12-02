package br.com.stream;

import org.junit.Test;

import java.util.Optional;

import static br.com.stream.ProcessaPrimeiroCaracterNaoRepetido.MENSAGEM_DE_ERRO;
import static br.com.stream.ProcessaPrimeiroCaracterNaoRepetido.processa;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProcessaPrimeiroCaracterNaoRepetidoTest {

    @Test
    public void deveEncontrarPrimeiraVogalNaoRepetida() throws Exception {
        Stream stream = new StreamImpl("AABBABacafe");
        final Optional<Character> characterOptional = processa(stream);
        assertThat(characterOptional.get()).isEqualTo('e');
    }

    @Test
    public void deveDeveExistirOCaracterVogalNaoRepetido() throws Exception {
        Stream stream = new StreamImpl("AABBABacaf");
        final Optional<Character> characterOptional = processa(stream);

        assertThat(characterOptional).isEmpty();
    }

    @Test
    public void deveNaoEncontrarVogalQuandoStreamForNull() {
        assertThatThrownBy(() -> processa(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(MENSAGEM_DE_ERRO);
    }

    @Test
    public void quandoStringVaziaNaoDeveExistirRepetidoOuDarErro() throws Exception {
        String entrada = "";
        Stream stream = new StreamImpl(entrada);

        final Optional<Character> characterOptional = processa(stream);
        assertThat(characterOptional).isEmpty();
    }
}
