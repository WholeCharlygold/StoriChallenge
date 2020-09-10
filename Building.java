import java.lang.Comparable;

//Class to represent Buildings
public class Building implements Comparable<Building> {

    // Properties
    private final int li; // X Coordinate of the left edge
    private final int ri; // X Coordinate of the right
    private final int hi; // Height of the building

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

    /**
     * Get the propierty li
     * @return int Li
     */
    public int getLi(){
        return this.li;
    }

    /**
     * Get the propierty ri
     * @return int ri
     */
    public int getRi(){
        return this.ri;
    }

    /**
     * Get the propierty hi
     * @return int hi
     */
    public int getHi(){
        return this.hi;
    }

    /**
     * See if a point in x lays in the roof or a building
     * @param x x point to be analyze
     * @return false if x is not inside the x-axis of the bulding
     */
    public boolean xInside(int x){
        if (this.li<=x && x<=this.ri) return true;
        else return false;


    }

    /**
     * See if a point in y lays in the roof or a building
     * @param y  point to be analyze
     * @return false if xy is not inside the y-axis of the bulding
     */
    public boolean yInside(int y){
        if (this.hi>=y) return true;
        else return false;

    }
    


    @Override
    public int compareTo(Building o) {
        if (this.li<o.getLi()){
            return -1;
        }else if(this.li == o.getLi()){
            if (this.hi<o.getHi()) return -1;
        }
        return 1;
    }

    @Override
    public String toString(){
        return "[Li,Ri,Hi]=[" + this.li + ',' + this.ri + ',' + this.hi + ']';
    }

}
