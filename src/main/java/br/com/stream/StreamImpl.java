package br.com.stream;

public class StreamImpl implements Stream {

    private String entrada = "";
    private Integer indexAtual = -1;


    public StreamImpl(String entrada) {
        this.entrada = entrada;
    }

    @Override
    public char getNext() {
        indexAtual++;
        return entrada.charAt(indexAtual);
    }

    @Override
    public boolean hasNext() {
        try {
            entrada.charAt(indexAtual + 1);

            return true;
        }catch (IndexOutOfBoundsException ex){
//           throw new RuntimeException("Não existe mais nenhum caracter na String");
        }
        return false;
    }
}
