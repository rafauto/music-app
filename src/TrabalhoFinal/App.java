//Programação Orientada a Objetos (POO) - linguagem Java
//Trabalho final: opção 1
//Aplicativo de música
//Desenvolvedora: Rafaela Uto

package TrabalhoFinal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class App implements Tela {
    Scanner ler = new Scanner(System.in);

// -------------------- Atributos --------------------
    private int volume, musAtual;
    private boolean ligado, tocando;

// ---------------------- Listas: ----------------------
    ArrayList<Musica> musicas = new ArrayList<>();
    Musica m0 = new Musica("Musica0","Cantor0");
    Musica m1 = new Musica("Musica1","Cantor1");
    Musica m2 = new Musica("Musica2","Cantor2");

// -------------------- Método construtor --------------------
    public App() {
        this.volume = 50;
        this.musAtual = 0;
        this.ligado = false;
        this.tocando = false;

        //Adiciona músicas pré-definidas da playlist (uma única vez):
        musicas.add(m0);
        musicas.add(m1);
        musicas.add(m2);
    }

// -------------------- Métodos especiais --------------------
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getMusAtual() {
        return musAtual;
    }
    public void setMusAtual(int musAtual) {
        this.musAtual = musAtual;
    }
    public boolean isLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    public boolean isTocando() {
        return tocando;
    }
    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
// -------------------- Implementação de métodos abstratos --------------------
    @Override
    public void abrirApp() {
        this.setLigado(true);
    }
    @Override
    public void fecharApp() {
        this.setLigado(false);
    }
    @Override
    public void abrirMenu() {
        System.out.println("\n========== Menu ==========");     //Exibe menu
        System.out.println("Ligado? "+isLigado());
        System.out.println("Tocando? "+isTocando());
        System.out.printf("Volume: "+this.getVolume());
        for(int i=0; i<=this.getVolume(); i+=10) {
            System.out.printf("|");     //Exibe barrinhas que representam volume
        }
        if(!musicas.isEmpty()) {
            Musica atual = musicas.get(this.getMusAtual());
            System.out.println("\nEsta tocando: "+atual.getNome()+" - "+atual.getCantor());
        }

        //Exibe músicas da playlist:
        System.out.println("\nMúsicas da playlist:");
        for(int m=0; m<musicas.size(); m++) {
            System.out.println(m+": "+musicas.get(m).getNome()+" cantada por "+musicas.get(m).getCantor());
        }
        
        totMusicas();     //Exibe quantidade de músicas pré-definidas na playlist:
    }
    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");
    }
    @Override
    public void aumentaVol() {
        if(this.isLigado()) {
            this.setVolume(Math.min(100, this.getVolume()+5));     //Volume máximo: 100
        }
    }
    @Override
    public void diminuiVol() {
        if(this.isLigado()) {
            this.setVolume(Math.max(0, this.getVolume()-5));     //Volume mínimo: 0
        }
    }
    @Override
    public void inserir() {
        String novoNome, novoCantor;
        int adiciona;

        //Pergunta ao usuário se deseja adicionar uma música a playlist:
        System.out.println("\n---------- ADICIONAR MÚSICA ----------");
        System.out.printf("Deseja adicionar uma música a playlist? \n<1>Sim \n<2>Não \nResposta: ");
        adiciona = ler.nextInt();

        //Enquanto o usuário digitar um valor inválido não adiciona música a playlist:
        while(adiciona!=1 && adiciona!=2){
            System.out.printf("Valor inválido, digite 1 ou 2! Deseja adicionar uma música a playlist/ \n<1>Sim \n<2>Não \nResposta: ");
            adiciona = ler.nextInt();
        }

        //Adiciona música a playlist:
        novoNome = ler.nextLine();
        if(adiciona==1){
            System.out.printf("Digite o nome da música a ser adicionada: ");
            novoNome = ler.nextLine();
            System.out.printf("Digite o nome do cantor/banda de %s: ",novoNome);
            novoCantor = ler.nextLine();

            Musica m = new Musica(novoNome,novoCantor);
            musicas.add(m);
            
            System.out.println(novoNome+" tocada por "+novoCantor+" foi adicionado com sucesso!");

        //Finaliza processo de adicionar música:
        }else{
            System.out.println("Nenhuma música adicionada");
        }
        totMusicas();     //Exibe quantidade de músicas pré-definidas na playlist:
    }
    @Override
    public void remover() {
        String eMusica;
        int exclui;

        //Pergunta ao usuário se deseja excluir uma música da playlist:
        System.out.println("\n---------- EXCLUIR MÚSICA ----------");
        System.out.printf("Deseja remover uma música da playlist? \n<1>Sim \n<2>Não \nResposta: ");
        exclui = ler.nextInt();

        //Enquanto o usuário digitar um valor inválido não é possíver excluir uma música da playlist:
        while(exclui!=1 && exclui!=2){
            System.out.printf("Valor inválido, digite 1 ou 2! Deseja remover uma música da playlist? \n<1>Sim \n<2>Não \nResposta: ");
            exclui = ler.nextInt();
        }

        //Exclui música da playlist:
        eMusica = ler.nextLine();
        
        if(exclui==1){
            System.out.printf("Digite o nome da música ou cantor/banda a ser excluida: ");
            eMusica = ler.nextLine();

            Musica encontrada = procurar(eMusica);
            if(encontrada != null) {
                musicas.remove(encontrada);
                if(this.getMusAtual() >= musicas.size()) {
                    this.setMusAtual(0);     //Evita apontar para uma música que não existe mais
                }
                System.out.println(eMusica+" foi excluido com sucesso!");
            } else {
                System.out.println(eMusica+" não foi encontrada na playlist");
            }

        //Finaliza processo de excluir música:
        }else{
            System.out.println("Nenhuma música excluida");
        }
        totMusicas();     //Exibe quantidade de músicas pré-definidas na playlist:
    }
    @Override
    public void play() {
        if (this.isLigado() && !(this.isTocando())){
            this.setTocando(true);
        }
    }
    @Override
    public void pause() {
        if (this.isLigado() && this.isTocando()){
            this.setTocando(false);
        }
    }
    @Override
    public void avancar() {
        if(!musicas.isEmpty()) {
            this.setMusAtual((this.getMusAtual()+1) % musicas.size());     //Volta ao início no fim da playlist
        }
    }
    @Override
    public void voltar() {
        if(!musicas.isEmpty()) {
            this.setMusAtual((this.getMusAtual()-1+musicas.size()) % musicas.size());     //Vai para o fim se estiver no início
        }
    }
    @Override
    public void aleatorio() {
        Collections.shuffle(musicas);
        for (int i=0; i<musicas.size(); i++){
            System.out.println(i+": "+musicas.get(i).getNome()+" - "+musicas.get(i).getCantor());
        }
    }
    @Override
    public void busca() {
        String n;
        int op;

        //Pergunta se o usuário deseja pesquisar uma música:
        System.out.println("\n---------- PESQUISAR MÚSICA ----------");
        System.out.printf("Deseja pesquisar: \n<1>Uma música ou cantor/banda \n<2>Não quero pesquisar nada \nResposta: ");
        op = ler.nextInt();
        
        //Enquanto o usuário digitar um valor inválido não poderá pesquisar uma música ou cantor/banda:
        while(op!=1 && op!=2){
            System.out.printf("Valor inválido, digite 1 ou 2! Deseja pesquisar: \n<1>Uma música \n<2>Não quero pesquisar nada \nResposta: ");
            op = ler.nextInt();
        }

        //Pesquisa o nome da música ou cantor/banda na playlist:
        n = ler.nextLine();
        if(op==1){
            System.out.printf("Digite o nome da música ou cantor/banda que deseja pesquisar: ");
            n = ler.nextLine();

            //A busca apenas consulta a playlist, sem remover nada:
            Musica encontrada = procurar(n);
            if(encontrada != null) {
                System.out.println(n+" foi encontrado na playlist: "+encontrada.getNome()+" - "+encontrada.getCantor());
            } else {
                System.out.println(n+" não foi encontrada na playlist");
            }

        //Finaliza a busca:
        }else{
            System.out.println("Finalizando busca...");
        }
        ler.close();
    }

// -------------------- Métodos públicos --------------------
    public void totMusicas(){
        System.out.println("Quantidade total de músicas na playlist: "+musicas.size());
    }

    //Retorna a primeira música cujo nome ou cantor/banda seja igual ao texto (sem diferenciar maiúsculas), ou null:
    public Musica procurar(String texto) {
        for(Musica m : musicas) {
            if(m.getNome().equalsIgnoreCase(texto.trim()) || m.getCantor().equalsIgnoreCase(texto.trim())) {
                return m;
            }
        }
        return null;
    }
}












