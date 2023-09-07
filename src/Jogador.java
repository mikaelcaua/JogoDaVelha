public class Jogador {

    //nome do jogador
    private String nome;

    //se é x ou o
    private char type;

    //se conseguiu jogar ou n
    private boolean jogou;

    //construtor
    public Jogador(String name, char type){
        this.setNome(name);
        this.setType(type);
        this.setJogou(false);
    }

    public void setJogou(boolean jogou){
        this.jogou = jogou;
    }

    public boolean getJogou(){
        return this.jogou;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }


    //faz uma jogada
    public void fazerJogada(Tabuleiro tabuleiro,int lin, int col){
        Jogada jogada_atual = new Jogada();
        jogada_atual.setLinha(lin);
        jogada_atual.setColuna(col);
        jogada_atual.setPlayer(this);
        tabuleiro.receberJogada(jogada_atual);
    }





}
