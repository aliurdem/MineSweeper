public class Element {
    public boolean isBomb;
    boolean isClicked = false;
    int row;
    int column;


    Element(int row,int column,boolean isBomb){
        this.row = row;
        this.column = column;
        this.isBomb = isBomb;
        this.isClicked = false;
    }

    boolean Click(){
        this.isClicked = true;
        return this.isClicked;
    }

    boolean isBombEl(){
        return this.isBomb;
    }

}
