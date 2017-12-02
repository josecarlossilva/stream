package br.com.stream;

import java.util.*;

import static java.util.Optional.empty;

public class ProcessaPrimeiroCaracterNaoRepetido {

    public static final String MENSAGEM_DE_ERRO = "Stream não pode ser vazio!";
    private static final String VOGAIS = "aeiou";

    private static List<Character> processaVogais(Stream stream) {
        Set<Character> repetida = new HashSet<>();
        List<Character> naoRepetida = new ArrayList<>();

        while (stream.hasNext()) {

            char letra = Character.toLowerCase(stream.getNext());

            if (repetida.contains(letra)) {
                continue;
            }
            if (naoRepetida.contains(letra)) {
                naoRepetida.remove((Character) letra);
                repetida.add(letra);
            } else {
                if (isVogal(letra)) {
                    naoRepetida.add(letra);
                }
            }
        }

        return naoRepetida;
    }

    public static Optional<Character> processa(Stream stream) {

        if (stream == null) {
            throw new IllegalArgumentException(MENSAGEM_DE_ERRO);
        }

        List<Character> listaDeCaractersNaoRepetidos = processaVogais(stream);

        try {
            return Optional.of(listaDeCaractersNaoRepetidos.get(0));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Não foi encontrado nenhuma vogal não repetida");
        }

        return empty();
    }

    private static boolean isVogal(char letra) {
        return VOGAIS.indexOf(letra) >= 0;
    }
}