

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grigorios Tsoumakas
 */
public class TransactionTest {
    
    public TransactionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test 1.
     */
    @Test
    public void test1() {
        String product = "μπανάνες";
        Transaction instance = new Transaction();
        instance.scanItem(product);
        int amount = instance.getAmountOfProduct(product);
        int expResult = 1;
        assertEquals(expResult, amount);        
        instance = new Transaction();
        instance.scanItems(product, 2);
        amount = instance.getAmountOfProduct(product);
        expResult = 2;
        assertEquals(expResult, amount);        
    }

    /**
     * Test 3.
     */
    @Test
    public void test3() {
        System.out.println("scanItem");
        String product = "μπανάνες";
        Transaction instance = new Transaction();
        instance.scanItem(product);
        instance.scanItems(product, 2);
        int amount = instance.getAmountOfProduct(product);
        int expResult = 3;
        assertEquals(expResult, amount);        
        product = "μπαμάνες";
        instance = new Transaction();
        instance.scanItem(product);
        instance.scanItems(product, 2);
        amount = instance.getAmountOfProduct("μπανάνες");
        expResult = 0;
        assertEquals(expResult, amount);        
    }

    
}
