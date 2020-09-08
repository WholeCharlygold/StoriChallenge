import java.util.ArrayList;
import java.util.Scanner;

//Main Class
class Skyline{
    //Properties
    public ArrayList<KeyPoint> pointList; //List of points where the skyline pass OUTPUT
    public ArrayList<Building> bList; //List of buildings where the skyline is

    //Constructor
    public Skyline(ArrayList<Building> bList){
        this.pointList = new ArrayList<KeyPoint>();
        this.bList = bList;
    }

    //Methods
    /**
     *  Display every single keypoint of the skyline.
    */
    public void displayKeyPoints(){
        pointList.forEach(
            (point) -> point.display()
        );
    }

    /**
     * Display the buldings of the skyline
     */
    public void displayBuildings(){
        bList.forEach(
            (building) -> building.display()
        );
    }

    //Static Methods
    /**
     * Get the buildings input to iniatilize a skyline
     * @return Skyline Object
     */
    public static Skyline input(){
        Scanner lapiz = new Scanner(System.in);
        System.out.println("Type how many buildings are with number. Example: 6");
        int number_of_buildings = Integer.parseInt(lapiz.nextLine());
        ArrayList<Building> buildings = new ArrayList<Building>();
        for ( int i = 0;i<number_of_buildings;i++){
            System.out.println("Type the coordinates of the "+(i+1)+" building as li,ri,hi. Example: 1,4,7");
            String str = lapiz.nextLine();
            String[] aux = str.split(",");
            buildings.add(new Building(Integer.parseInt(aux[0]),Integer.parseInt(aux[1]),Integer.parseInt(aux[2])));
        }
        lapiz.close();
        Skyline metro = new Skyline(buildings);
        metro.displayBuildings();
        return metro;
    }

    public static void main(final String...args){
      Skyline metro;
        //Input buildings
        metro = Skyline.input();
        //Analysis

        //Output result

        


    }
}