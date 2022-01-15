public class Ferry extends Company {


    public Ferry(String[] values) {
        ownedBy = 0;
        owned = false;
        price = Integer.parseInt((values[rPrice]));
        rent0 = Integer.parseInt((values[rRent0]));
        rent1 = Integer.parseInt((values[rRent1]));
        rent2 = Integer.parseInt((values[rRent2]));
        rent3 = Integer.parseInt((values[rRent3]));
    }


}
