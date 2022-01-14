

import java.io.IOException;

public class Property extends Square {

    String name;
    int ownedBy, price, mortgageValue, position, housePrice, rent0, rent1, rent2, rent3, rent4, rent5;
    boolean mortgaged, owned;



    public Property(int pos) throws IOException {

        ownedBy = 0;
        mortgaged = false;
        owned = false;
        position=pos;

        name = reader(position, rName);
        price = intreader(position, rPrice);
        housePrice = intreader(position,rHousePrice);
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



    public void setPrice(int price) {
        this.price = price;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }


}
