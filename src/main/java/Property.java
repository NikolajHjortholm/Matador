

import java.io.IOException;

public class Property extends Square {

    String name;
    int ownedBy, price, mortgageValue, position, housePrice, rent0, rent1, rent2, rent3, rent4, rent5;
    boolean mortgaged, owned;

    public Property(int pos) throws IOException {

        ownedBy = 0;
        mortgaged = false;
        owned = true;
        position=pos;

        name = reader(position, rName);

        name = reader(position, rHousePrice);
        rent0 = intreader(position, rRent0);
        rent1 = intreader(position, rRent1);
        rent2 = intreader(position, rRent2);
        rent3 = intreader(position, rRent3);
        rent4 = intreader(position, rRent4);
        rent5 = intreader(position, rRent5);


    }



    public int getPrice() {

        return price;

    }

    public int getRent() {

        return rent0;

    }

}
