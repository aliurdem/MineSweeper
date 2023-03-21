import java.util.Random;

public class MineSweeper {

    int row;
    int column;

    int mineNum;
    MineSweeper(int row,int column){
        this.row = row;
        this.column = column;
        this.mineNum = (int)Math.ceil((row*column)/4);
    }
    Element[][] createBoard(){
        Element[] elements = new Element[row*column];
        System.out.println(mineNum);
        int bombCounter =0;
        int elm = 0;
        for(int a = 0 ; a<row;a++){
            for(int b = 0;b<column;b++){
                boolean bomb = Math.random() < 0.5;
                if((bomb == true && (bombCounter+1<=mineNum)) ){
                    Element newE = new Element(a,b,bomb);
                    elements[elm] = newE;
                    elm++;
                    bombCounter++;
                }else{
                    bomb = false;
                    Element newE = new Element(a,b,bomb);
                    elements[elm] = newE;
                    elm++;
                }
            }


        }
        Element[][] board = new Element[row][column];
        int b = 0;
        for(int i = 0;i <row;i++){
            for(int z = 0; z<column;z++ ){
                board[i][z] = elements[b];
                b++;
            }
        }

        return board;
    }

    void elementWriter(Element[][] board){
        for(int i = 0 ; i<row;i++){
            for(int z = 0;z<column;z++){
                if(board[i][z].isBombEl() == false){
                   if(board[i][z].isClicked == false){
                       System.out.print(" * ");
                   }
                   else{
                       int arbmb = 0;
                       int r = i-1;
                       int c = z-1;
                       for(int g = 0;g<3;g++){
                           for(int h = 0 ; h<3;h++){
                               if(r<0 || c<0 || r>=row || c>=column){c++; continue;}
                               if(board[r][c].isBombEl()==true){arbmb+=1;}
                               c++;
                           }
                           c = z-1;
                           r++;
                       }
                       System.out.print(" "+arbmb+" ");
                   }


                }else{
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    boolean isWin(Element[][] board){
        int winNum = (row*column)-mineNum;
        int clicks = 0;
        for(int i = 0; i<row;i++){
            for(int z = 0; z<column;z++){
                if(board[i][z].isClicked == true){
                    clicks++;
                }
            }
        }
        if (clicks == winNum){
            System.out.println("Kazandınız Tebrikler");
            return true;
        }
        else{
            return false;
        }



    }




}
