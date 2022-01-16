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
    public void Test() {
        Assert.assertEquals(1,dice.getDie1());
        Assert.assertEquals(1,dice.getDie2());
    }
}
