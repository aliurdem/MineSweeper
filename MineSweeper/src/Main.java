import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of columns :  ");
        int columns = scanner.nextInt();
        System.out.println("Enter the number of rows : ");
        int rows = scanner.nextInt();

        MineSweeper game = new MineSweeper(rows,columns);
        Element[][] gameBoard = game.createBoard();
        game.elementWriter(gameBoard);
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!");

        while(true){
            System.out.println("============================");
            game.elementWriter(gameBoard);

            System.out.println("Satır giriniz = ");
            int eR = scanner.nextInt();
            System.out.println("Sütun giriniz = ");
            int eC = scanner.nextInt();

            boolean result = gameBoard[eR][eC].isBombEl();
            gameBoard[eR][eC].isClicked = true;

            if(!result){
                game.elementWriter(gameBoard);
            }else{
                System.out.println("Kaybettiniz!!");
                break;
            }
            if(game.isWin(gameBoard)){
                break;
            }

        }




    }
}