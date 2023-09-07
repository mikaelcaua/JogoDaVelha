public class Jogada {
    //linha da jogada
    private int linha;

    //coluna da jogada
    private int coluna;

    // jogador que fez a jogada
    private Jogador player;



    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getLinha() {
        return linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getColuna() {
        return coluna;
    }

    public void setPlayer(Jogador player) {
        this.player = player;
    }

    public Jogador getPlayer() {
        return player;
    }
}
