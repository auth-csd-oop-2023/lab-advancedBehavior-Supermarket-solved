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
public class SupermarketTest {
    
    public SupermarketTest() {
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
     * Test 1
     */
    @Test
    public void test1() {
        String product1 = "μπανάνες";
        String product2 = "μήλα";
        Supermarket instance = new Supermarket();
        Transaction t = new Transaction();
        t.scanItem(product1);
        t.scanItems(product2,5);
        instance.addTransaction(t);
        t = new Transaction();
        t.scanItems(product1,3);
        t.scanItems(product2,5);
        instance.addTransaction(t);
        int result = instance.getTotalSalesOfProduct(product1);
        int expResult = 4;
        assertEquals(expResult, result);
        result = instance.getTotalSalesOfProduct(product2);
        expResult = 10;
        assertEquals(expResult, result);
        instance = new Supermarket();
        t = new Transaction();
        t.scanItems(product1,3);
        t.scanItems(product2,6);
        instance.addTransaction(t);
        t = new Transaction();
        t.scanItems(product1,3);
        t.scanItem(product2);
        instance.addTransaction(t);
        result = instance.getTotalSalesOfProduct(product1);
        expResult = 6;
        assertEquals(expResult, result);
        result = instance.getTotalSalesOfProduct(product2);
        expResult = 7;
        assertEquals(expResult, result);
    }
        
    /**
     * Test 3
     */
    @Test
    public void test3() {
        String product1 = "μπανάνες";
        String product2 = "μήλα";
        Supermarket instance = new Supermarket();
        Transaction t = new Transaction();
        t.scanItem(product1);
        t.scanItems(product2,5);
        instance.addTransaction(t);
        t = new Transaction();
        t.scanItems(product1,3);
        t.scanItems(product2,5);
        instance.addTransaction(t);
        int result = instance.uniqueProducts();
        int expResult = 2;
        assertEquals(expResult, result);
        t = new Transaction();
        t.scanItems("αχλάδια", 3);
        instance.addTransaction(t);
        result = instance.uniqueProducts();
        expResult = 3;
        assertEquals(expResult, result);
    }
        
    
}
