// This class is used to store a pieces position on the board
public class Tile extends javafx.scene.layout.Pane {
    int row;
    int col;
    
    public Tile(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }


}
