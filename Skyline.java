import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


//Main Class
class Skyline {
    // Properties
    public ArrayList<KeyPoint> pointList; // List of points where the skyline pass OUTPUT
    public ArrayList<Building> bList; // List of buildings where the skyline is

    // Constructor
    public Skyline(ArrayList<Building> bList) {
        this.pointList = new ArrayList<KeyPoint>();
        this.bList = bList;
    }

    // Methods
    /**
     * Display every single keypoint of the skyline.
     */
    public void displayKeyPoints() {

        pointList.forEach((point) -> point.display());
    }

    /**
     * Display the buldings of the skyline
     */
    public void displayBuildings() {
        this.bList.forEach((building) -> building.display());
    }

    /**
     * This method compliments the one that is in Building but see if one coord lays
     * in a collection of buildings
     * 
     * @param x_edificio Last building not to be count of
     * @param y          pint in y-axis
     * @param edificios  collection of buildings
     * @return Building Object if lays in one of the buildings || null if not
     */
    public Building InsideSkyline(Building x_edificio, int y, PriorityQueue<Building> edificios) {
        PriorityQueue<Building> aux = new PriorityQueue<>(edificios);
        ArrayList<Building> aux_2 = new ArrayList<Building>();
        while (!aux.isEmpty()) {
            Building edificio = aux.remove();
            if (edificio.xInside(x_edificio.getRi()) && edificio != x_edificio){
                aux_2.add(edificio);
                
            }
                
        }
        if(aux_2.isEmpty()){
            return null;
        }else{
            //System.out.println("El edificio para la coordenada ["+x_edificio.getRi()+','+y+"] es:");
            Building res = aux_2.get(0);
            for(Building o: aux_2){
                if(res.getHi()<o.getHi()){
                  //  o.display();
                    res = o;
                }
            }
            //System.out.println("Elegido:");
           // res.display();
            return res;
        }
        
    }


    // Static Methods
    /**
     * Get the buildings input to iniatilize a skyline
     * 
     * @return Skyline Object
     */
    public static Skyline input() {
        int number_of_buildings = 0;
        Scanner lapiz = new Scanner(System.in);
        try{
        System.out.println("Type how many buildings are with number. Example: 6");
        number_of_buildings = Integer.parseInt(lapiz.nextLine());
        }catch(Exception e){
            System.out.println("Type the input like the example pls!");
            System.exit(0);
        }
        
        ArrayList<Building> buildings = new ArrayList<Building>();
        for (int i = 0; i < number_of_buildings; i++) {
            String[] aux=null;
            try{
                System.out.println("Type the coordinates of the " + (i + 1) + " building as li,ri,hi. Example: 1,4,7");
            String str = lapiz.nextLine();
            aux = str.split(",");
            buildings.add(new Building(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2])));
            }catch(Exception e){
                System.out.println("Type the input like the example pls!");
                System.exit(0);
            }
            
        }
        lapiz.close();
        Skyline metro = new Skyline(buildings);
        // metro.displayBuildings();
        return metro;
    }

    public static void main(final String... args) {
        Skyline metro;
        // Input buildings
        metro = Skyline.input();

        // Organize by x coordinate buildings with a priority queue
        PriorityQueue<Building> pBuildings = new PriorityQueue<Building>();
        pBuildings.addAll(metro.bList);
        

        // Analysis
        Building last_edificio = new Building(0, 0, 0);
        PriorityQueue<Building> aux_edificios = new PriorityQueue<Building>(pBuildings);
        while (!pBuildings.isEmpty()) {
            Building edificio = pBuildings.peek();
            int x = edificio.getLi();
            int y = edificio.getHi();
            if (metro.pointList.isEmpty()) { // Case 1: theres no keypoints yet
                metro.pointList.add(new KeyPoint(x, y));
                last_edificio = edificio;
                pBuildings.remove();
            } else { // Case 2: There is even one keypoint in the list of skyline
                KeyPoint last_KeyPoint = metro.pointList.get(metro.pointList.size() - 1);
                Building aux_Building = metro.InsideSkyline(last_edificio, y, aux_edificios);
                if (y > last_KeyPoint.y && x> last_KeyPoint.x) { // Case 2.1: The next building is taller than the last one
                    metro.pointList.add(new KeyPoint(x, y));
                    last_edificio = edificio;
                    pBuildings.remove();
                }  else if (y == last_KeyPoint.y || x<last_KeyPoint.x) { // Case 2.2: The next building is as taller as the last one OR the next building behind the last one
                    last_edificio = edificio;
                   pBuildings.remove();
                }else if (aux_Building != null ) { // Case 2.3: The next building isnt taller
                                                                           // than the last one
                    metro.pointList.add(new KeyPoint(last_edificio.getRi(), aux_Building.getHi()));
                    last_edificio = aux_Building;
                } else { //Case 2.4: Theres no adyacent building so theres floor
                    metro.pointList.add(new KeyPoint(last_edificio.getRi(), 0));
                    //pBuildings.remove();
                }
            }
        }
        metro.pointList.add(new KeyPoint(last_edificio.getRi(), 0));

        // Output and clean result
       
        System.out.println("--------------LIST OF KEYPOINTS OF THE SKYLINE----------- ");
        metro.displayKeyPoints();
    }
}