import java.util.ArrayList;
import java.util.HashSet;

/**
 * Η κλάση αυτή αποθηκεύει στη μνήμη τις συναλλαγές σε ένα σούπερ μάρκετ.
 * This class saves in memory all the transactions of a supermarket.
 *
 * @author Grigorios Tsoumakas
 */
public class Supermarket {
    ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * Αυτή η μέθοδος αποθηκεύει μια συναλλαγή
     * This method saves a transaction
     *
     * @param t μια συναλλαγή , a transaction
     */
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    /**
     * Αυτή η μέθοδος επιστρέφει το πλήθος όλων των πωλήσεων ενός προϊόντος σε
     * όλες τις αποθηκευμένες συναλλαγές.
     * This method returns the total number of sales of a product from all saved transactions.
     *
     * @param product ένα προϊόν. A product
     * @return το πλήθος των πωλήσεων του προϊόντος. The total sales number
     */
    public int getTotalSalesOfProduct(String product) {
        int total = 0;
        for (Transaction t : transactions) {
            total += t.getAmountOfProduct(product);
        }
        return total;
    }

    /**
     * Η μέθοδος αυτή επιστρέφει το πλήθος των μοναδικών προϊόντων που έχουν
     * βρεθεί σε συναλλαγές.
     * This method returns the number of unique products that have been found
     * in the transactions.
     *
     * @return Το πλήθος των μοναδικών προϊόντων. The total number of unique products
     */
    public int uniqueProducts() {
        HashSet<String> unique = new HashSet<>();
        for (Transaction t : transactions) {
            String[] products = t.getProducts();
            for (String product : products) {
                unique.add(product);
            }
        }
        return unique.size();
    }

}
