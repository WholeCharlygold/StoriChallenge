//Class that represents the KeyPoints or the coordinates of the skyline
public class KeyPoint {
    //Properties
    public int x; //X Coordinate
    public int y; //Y Coordinate

    //Constructor
    public KeyPoint(int x, int y) {
        this.x = x;
        this.y = y;

    }

    //Methods
    /**Display the coordinates of the keypoint */
    public void display() {
        System.out.println("[" + this.x + ',' + this.y + ']');
    }


    public static void main(String...args){
        KeyPoint point = new KeyPoint(2, 3);
        point.display();
    }
}