package squares;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Property extends Square{

    String name;
    int ownedBy, price, mortgageValue, position;
    boolean mortgaged, owned;

    public Property() {

    ownedBy = 0;
    mortgaged = false;
    owned = false;

    }

    public <Player> void landOnProperty(int currentPosition, Player currentPlayer) throws IOException {

        System.out.println(this.ownedBy);







        //Checks if property owned and allows player to buy the property if not owned
        if (!this.owned){

        reader(position,rPrice);


        //checks if property is mortgaged and if not player must pay its rent
        } else if (this.mortgaged) {



        }

    }

}
