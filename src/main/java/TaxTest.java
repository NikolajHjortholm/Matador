import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class TaxTest {

    @Test
    public void TestTax() {
        Tax tax = new Tax();
        Assert.assertEquals(100, tax.calculateTax(1000));
    }
}
