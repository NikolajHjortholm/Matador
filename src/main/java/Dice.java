public class Dice {
    private int die1;
    private int die2;
    int rot1;
    int rot2;

    public Dice() {
        roll();
        rota();
    }

    public void roll() {
        die1 = (int)(Math.random()*6)+1;
        die2 = (int)(Math.random()*6)+1;
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int getTotal() {
        return die1 + die2;
    }

    public void rota() {
        rot1 = (int)(Math.random()*360)+1;
        rot2 = (int)(Math.random()*360)+1;
    }

    public int getRot1() {
        return rot1;
    }

    public int getRot2() {
        return rot2;
    }


}
