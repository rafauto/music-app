//Programação Orientada a Objetos (POO) - linguagem Java
//Trabalho final: opção 1
//Aplicativo de música
//Desenvolvedora: Rafaela Uto

package TrabalhoFinal;

//Classe filha:
public class Sertanejo extends Musica {

    public Sertanejo(String nome, String cantor) {
        super(nome, cantor);
    }
    @Override
    public void categoria() {
        System.out.println("Sertanejo");
    }
}
