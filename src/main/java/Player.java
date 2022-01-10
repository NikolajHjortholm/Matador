public class Player {

    private String Name;
    private int moneyHeld = 20;
    private int age;
    public int getPosition;

    public Player() {
    }

    public void useMoney(int amount){this.moneyHeld -=amount;}

    public int getMoneyHeld(){return this.moneyHeld;}

    public String getName(){
        return this.Name;}

    public void setName(String Name){
        this.Name = Name;}

    public int getAge(){
        return this.age;}

    public void setAge(int age){
        this.age=age;}

}

