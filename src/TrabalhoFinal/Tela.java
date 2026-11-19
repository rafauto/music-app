//Programação Orientada a Objetos (POO) - linguagem Java
//Trabalho final: opção 1
//Aplicativo de música
//Desenvolvedora: Rafaela Uto

package TrabalhoFinal;

public interface Tela {
// -------------------- Métodos abstratos --------------------
    public abstract void abrirApp();
    public abstract void fecharApp();
    public abstract void abrirMenu();
    public abstract void fecharMenu();
    public abstract void aumentaVol();
    public abstract void diminuiVol();
    public abstract void inserir();
    public abstract void remover();
    public abstract void play();
    public abstract void pause();
    public abstract void avancar();
    public abstract void voltar();
    public abstract void aleatorio();
    public abstract void busca();
}
