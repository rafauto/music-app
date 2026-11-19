//Programação Orientada a Objetos (POO) - linguagem Java
//Trabalho final: opção 1
//Aplicativo de música
//Desenvolvedora: Rafaela Uto

package TrabalhoFinal;

//Classe filha:
public class Rock extends Musica {

    public Rock(String nome, String cantor) {
        super(nome, cantor);
    }
    @Override
    public void categoria() {
        System.out.println("Rock");
    }
}
