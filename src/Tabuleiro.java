import java.util.Scanner;

public class Tabuleiro {
    //matriz q representa o tabuleiro
    private char[][] matriz = new char[3][3];


    //determina se alguem ganhou
    private boolean someoneWin;


    //faz todos os elementos da matriz ser igual *
    //someoneWin igual a falso, pq ta no inicio do jogo
    public Tabuleiro(){
        for(int i=0;i< matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                matriz[i][j] = '*';
            }
        }
        someoneWin = false;
    }


    //mostrar tabuleiro
    public void showTabuleiro(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(this.matriz[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public void setSomeone_win(boolean someone_win) {
        this.someoneWin = someone_win;
    }

    public boolean getSomeoneWin(){
        return this.someoneWin;
    }


    //recebe uma jogada, as informações do player são guardadas dentro da jogada
    public void receberJogada(Jogada jogada_atual){
        int tipo_aux = jogada_atual.getPlayer().getType();

        //se n tiver ganhado
        if(this.getSomeoneWin()==false) {
            //impede de jpgar em posicao invalida
            if (jogada_atual.getLinha()>=0 && jogada_atual.getLinha()<3
                && jogada_atual.getColuna()>=0 && jogada_atual.getColuna()<3) {

                //impede de jogar onde ja foi jogado
                if(matriz[jogada_atual.getLinha()][jogada_atual.getColuna()] == '*') {
                    matriz[jogada_atual.getLinha()][jogada_atual.getColuna()] = jogada_atual.getPlayer().getType();
                    System.out.println("------------------------------------------------");
                    this.showTabuleiro();
                    System.out.println("------------------------------------------------");
                    jogada_atual.getPlayer().setJogou(true);
                }
                //impede de jogar onde ja foi jogado
                else{
                    System.out.println("\n");
                    System.out.println("Esta posição já esta ocupada");
                    System.out.println("\n");
                    jogada_atual.getPlayer().setJogou(false);
                }

            //impede de jogar em uma posição invalida
            } else {
                System.out.println("\n");
                System.out.println("Esta posição é inválida");
                System.out.println("\n");
                jogada_atual.getPlayer().setJogou(false);
            }

            //testa se venceu
            if(    matriz[0][0] == tipo_aux && matriz[0][1] == tipo_aux && matriz[0][2] == tipo_aux
                    || matriz[1][0] == tipo_aux && matriz[1][1] == tipo_aux && matriz[1][2] == tipo_aux
                    || matriz[2][0] == tipo_aux && matriz[2][1] == tipo_aux && matriz[2][2] == tipo_aux
                    || matriz[0][0] == tipo_aux && matriz[1][1] == tipo_aux && matriz[2][2] == tipo_aux
                    || matriz[0][2] == tipo_aux && matriz[1][1] == tipo_aux && matriz[2][0] == tipo_aux
                    || matriz[0][0] == tipo_aux && matriz[1][0] == tipo_aux && matriz[2][0] == tipo_aux
                    || matriz[0][1] == tipo_aux && matriz[1][1] == tipo_aux && matriz[2][1] == tipo_aux
                    || matriz[0][2] == tipo_aux && matriz[1][2] == tipo_aux && matriz[2][2] == tipo_aux){
                System.out.println("O jogador "+jogada_atual.getPlayer().getNome()+" ganhou");
                this.setSomeone_win(true);
            }

            //testa se empatou
            this.Draw_Game();
        }

    }

    public void startGame(Jogador jog1, Jogador jog2) {
        //verifica quem vai jogar
        int contVez = 0;

        //verificar se os jogadores tem tipos diferentes, é obrigatório
        if (jog1.getType() != jog2.getType()) {
            while (this.getSomeoneWin() == false) {

                //Se o contador é par, o jogador 1 joga
                if (contVez % 2 == 0 && this.getSomeoneWin() == false) {
                    Scanner lin1 = new Scanner(System.in);
                    Scanner col1 = new Scanner(System.in);
                    System.out.print("\n\n" + jog1.getNome() + ", Insira a linha: ");
                    int lin1_j1 = lin1.nextInt();
                    System.out.print("\n" + jog1.getNome() + ", Insira a coluna: ");
                    int col1_j1 = col1.nextInt();

                    //jogador faz jogada, se a jogada for valida passa a vez para o próximo
                    jog1.fazerJogada(this, lin1_j1, col1_j1);
                    if (jog1.getJogou() == true) {
                        contVez++;

                    }
                }

                //se o contador é impar, o jogador 2 joga
                if (contVez % 2 != 0 && this.getSomeoneWin() == false) {
                    Scanner lin2 = new Scanner(System.in);
                    Scanner col2 = new Scanner(System.in);
                    System.out.print("\n\n" + jog2.getNome() + ", Insira a linha: ");
                    int lin2_j2 = lin2.nextInt();
                    System.out.print("\n" + jog2.getNome() + ", Insira a coluna: ");
                    int col2_j2 = col2.nextInt();

                    //jogador faz jogada, se a jogada for valida, passa a vez para o próximo
                    jog2.fazerJogada(this, lin2_j2, col2_j2);
                    if (jog2.getJogou() == true) {
                        contVez++;
                    }
                }
            }

        }
        //se não tiver tipo diferente
        else{
            System.out.println("--------------------------------------------");
            System.out.println("Os dois jogadores não podem ter o mesmo tipo");
            System.out.println("--------------------------------------------");
        }
    }

    //empatar jogo
    public void  Draw_Game(){
        int cont =0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if(matriz[i][j]=='*'){
                    cont++;
                    i=4;
                    j=4;
                }
            }
        }
        if(cont==0){
            System.out.println("EMPATE");
            this.setSomeone_win(true);
        }
    }
}

