import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Square {

    public static Square[] squares = new Square[40];

    public static Parking parking = null;

    static String path = "src/main/java/files/fields.csv";

    public static int rName=0, rPosition=1, rType=2, rPrice=3, rHousePrice=4, rRent0=5, rRent1=6, rRent2=7, rRent3=8, rRent4=9, rRent5=10;

    public String name;
    public int position;
    public String type;


    public Square() {


    }

    public static void initializeSquares() throws Exception {
        List<String> squaresConfig = Files.readAllLines(Paths.get(path));
        int no=0;
        for(String s:squaresConfig) {
            if (no == 0) {
                no++;
                continue;
            }
            Square square = null;
            String[] values = s.split(";");
            String sq = values[rType].trim();
            if (sq.equals("street")) {
                square = new Street(values);
            }
            else if (sq.equals("chance")) {
                square = new Chance(values);
            }
            else if (sq.equals(("start"))) {
                square = new Start();
            }
            else if (sq.equals(("tax"))) {
                square = new Tax();
            }
            else if (sq.equals("ferry")) {
                square = new Ferry(values);
            }
            else if (sq.equals("brewery")) {
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
                // set common properties on square
                square.name = values[rName].trim();
                square.position = Integer.parseInt((values[rPosition]));
                square.type = values[rType].trim();
                squares[no - 1] = square;
            }
            no++;
        }

    }

    public String getSquare(int currentPosition, Player currentPlayer) throws IOException {

        return squares[currentPosition].type;

    }

    public abstract void handlePlayer(Game game);

}
