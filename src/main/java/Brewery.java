public class Brewery extends Company {

    public Brewery(String[] values) {
        ownedBy = 0;
        owned = false;
        price = Integer.parseInt((values[rPrice]));
        rent0 = Integer.parseInt((values[rRent0]));
        rent1 = Integer.parseInt((values[rRent1]));
    }

}
