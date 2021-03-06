# Sobre o Projeto 

Dada uma stream, encontre o primeiro caractere Vogal, após uma consoante,
onde a mesma é antecessora a uma vogal e que não se repita no resto da stream. O
termino da leitura da stream deve ser garantido através do método hasNext(), ou
seja, retorna falso para o termino da leitura da stream. Voce tera acesso a leitura da
stream através dos métodos de interface fornecidos ao termino do enunciado. 

**Premissas:**

- Uma chamada para hasNext() ir retornar se a stream ainda contem caracteres para processar.

- Uma chamada para getNext() ir retornar o proximo caractere a ser processado na stream.

- Não será possível reiniciar o fluxo da leitura da stream.

**Não poderá ser utilizado nenhum framework Java, apenas código nativo.**

Exemplo:

_Input_:  **aAbBABacafe**

_Output_: **e**

No exemplo, ‘e’ é o primeiro caractere Vogal da stream que não se repete após a primeira

Consoante ‘f’o qual tem uma vogal ‘a’ como antecessora.

Segue o exemplo da interface em Java:

public interface Stream{

    public char getNext();

    public boolean hasNext();

}

public static char firstChar(Stream entrada) {

}

# Resolução

Foi criada uma classe estática chamada **ProcessaPrimeiroCaracterNaoRepetido** que varre todas as vogais 
e busca a primeira vogal não repetida.

Foi criado também uma classe **ProcessaPrimeiroCaracterNaoRepetidoTest** com 4 cenários.

Para os cenários de testes foi utilizado o **AssertJ** para deixar os asserts mais fluentes.