//Programação Orientada a Objetos (POO) - linguagem Java
//Trabalho final: opção 1
//Aplicativo de música
//Desenvolvedora: Rafaela Uto

package TrabalhoFinal;

public class Principal {
    //Polimorfismo:
    public void categMusica(Musica musica, Pop pop, Sertanejo sertanejo, Rock rock, MPB mpb, Funk funk) {
        musica.categoria();
        pop.categoria();
        sertanejo.categoria();
        rock.categoria();
        mpb.categoria();
        funk.categoria();
    }
    public static void main(String[] args) {
// ------------------------ Instanciar (criar  objetos): ------------------------
        App a = new App();
        Principal p = new Principal();
        
        a.abrirApp();
        a.play();
        a.abrirMenu();
        p.categMusica(new Musica(null,null), new Pop(null,null), new Sertanejo(null,null), new Rock(null,null), new MPB(null,null), new Funk(null,null));
        a.inserir();
        a.remover();
        a.busca();
    }
}
