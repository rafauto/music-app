//Programação Orientada a Objetos (POO) - linguagem Java
//Trabalho final: opção 1
//Aplicativo de música
//Desenvolvedora: Rafaela Uto

package TrabalhoFinal;

//Classe pai:
public class Musica {

// -------------------- Atributos --------------------
    private String nome;
    private String cantor;

// -------------------- Método construtor --------------------
    public Musica (String nome, String cantor) {
        this.nome = nome;
        this.cantor = cantor;
    }

// -------------------- Métodos especiais --------------------
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCantor() {
        return cantor;
    }
    public void setCantor(String cantor) {
        this.cantor = cantor;
    }
// -------------------- Método público --------------------
    public void categoria() {
        System.out.println("\n---------- CATEGORIAS MUSICAIS ----------");
    }
}

