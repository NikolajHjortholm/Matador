import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


public class DiceTest {

    Dice dice = new Dice();
    @BeforeEach
    void setUp() {
        dice = new Dice();
    }

    @Test
    @DisplayName("Test dice 1")
    public void faceValueTest() {
        int dValue = dice.getDie1();
        int dValue2 = dice.getDie2();
        boolean test = dValue >0 && dValue <7;
        boolean test2 = dValue2 >0 && dValue2 <7;

        Assert.assertEquals(test,
                true);
        Assert.assertEquals(test2,
                true);
    }
    @Test
    @DisplayName("Sum")
    public void sumTest() {
        int sum = dice.getDie1() + dice.getDie2();
        Assert.assertEquals(sum,
                dice.getTotal());
    }
    @Test
    @DisplayName("Test Rotation")
    public void rotValueTest() {
        int rValue = dice.getRot1();
        int rValue2 = dice.getRot2();
        boolean test = rValue > -1 && rValue <361;
        boolean test2 = rValue2 > -1 && rValue2 <361;
        Assert.assertEquals(test,
                true);
        Assert.assertEquals(test2,
                true);
    }
}
