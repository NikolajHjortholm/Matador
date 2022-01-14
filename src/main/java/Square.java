import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Square{

    Property[] properties = new Property[40];

    String path = "src/main/java/files/fields.csv";

    int rName=0, rPosition=1, rType=2, rPrice=3, rHousePrice=4, rRent0=5, rRent1=6, rRent2=7, rRent3=8, rRent4=9, rRent5=10;


    public Square() {


    }


    public String reader(int currentPosition, int line) throws IOException {

        String reader = Files.readAllLines(Paths.get(path)).get(currentPosition+1);
        String[] value = reader.split(",");

        return value[line];

    }

    public int intreader(int currentPosition, int line) throws IOException {

        String reader = Files.readAllLines(Paths.get(path)).get(currentPosition+1);
        String[] value = reader.split(",");

        int rValue = Integer.parseInt(value[line]);
        return rValue;

    }


    public String getSquare(int currentPosition, Player currentPlayer) throws IOException {

        String type = reader(currentPosition, rType);
        return type;



    }
    public static void Square() {


    }

}
