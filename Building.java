
//Class to represent Buildings
public class Building {

    // Properties
    public int li; // X Coordinate of the left edge
    public int ri; // X Coordinate of the right
    public int hi; // Height of the building

    // Constructor
    public Building(final int li, final int ri, final int hi) {
        this.li = li;
        this.ri = ri;
        this.hi = hi;
    }

    // Methods
    /** Display the coordinates of the building */
    public void display() {
        System.out.println("[Li,Ri,Hi]=[" + this.li + ',' + this.ri + ',' + this.hi + ']');
    }

    public static void main(String... args) {
        Building edificio = new Building(1, 2, 3);
        edificio.display();
    }

}
