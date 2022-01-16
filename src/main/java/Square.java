import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class  Square {

    public static Square[] squares = new Square[40];

    public static int streetGroups[][] = new int[8][3];

    public static Parking parking = null;

    static String path = "src/main/java/files/fields.csv";

    // Used for reading the fields.csv file
    public static int rName=0, rPosition=1, rType=2, rPrice=3, rHousePrice=4, rRent0=5, rRent1=6, rRent2=7, rRent3=8, rRent4=9, rRent5=10, rGroup=11, rMortgageValue=12;

    public String name;
    public int position;
    public String type;


    public Square() {


    }

    public static void initializeSquares() throws Exception {

        // Puts fields.csv in String list
        List<String> squaresConfig = Files.readAllLines(Paths.get(path));

        // Goes through all lines except 0 which is headlines
        int no=0;
        for(String s:squaresConfig) {
            if (no == 0) {
                no++;
                continue;
            }
            // Splits line by ; and puts them in String array
            String[] values = s.split(";");
            Square square = null;

            // Reads values type and test against different square types then creates that square type
            String sq = values[rType].trim();
            if (sq.equals("street")) {

                // Puts in values for streets
                square = new Street(values);
            }
            else if (sq.equals("chance")) {
                square = new Chance();
            }
            else if (sq.equals(("start"))) {
                square = new Start();
            }
            else if (sq.equals(("tax"))) {
                square = new Tax();
            }
            else if (sq.equals("ferry")) {

                // Puts in values for ferry
                square = new Ferry(values);
            }
            else if (sq.equals("brewery")) {

                // Puts in values for brewery
                square = new Brewery(values);
            }
            else if (sq.equals(("jail"))) {
                square = new Prison();
            }
            else if (sq.equals(("refugee"))) {
                square = new Parking();
                parking = (Parking) square;
            }
            if (square == null) {
                throw  new Exception("Unknown square type: "+sq);
            }
            else {

                // Sets common properties on square
                square.name = values[rName].trim();
                square.position = Integer.parseInt((values[rPosition]));
                square.type = values[rType].trim();
                squares[no - 1] = square;
            }
            // Starts over with next line
            no++;
        }

    }

    public String getSquare(int currentPosition, Player currentPlayer) throws IOException {

        return squares[currentPosition].type;

    }

    public abstract void handlePlayer(Game game);


    public static void updateSquaresGui(Game game){



    }

}



