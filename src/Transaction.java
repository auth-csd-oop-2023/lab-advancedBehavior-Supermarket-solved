import java.util.HashMap;
import java.util.Iterator;

/**
 * Η κλάση αυτή αφορά μια συναλλαγή ενός πελάτη με ένα supermarket. Με άλλα
 * λόγια αντιπροσωπεύει το καλάθι με τα προϊόντα που αγόρασε σε μια επίσκεψη.
 * This class represents a transaction of a super market customer. In other words,
 * the basket with the products of a visit to the supermarket.
 *
 * @author Grigorios Tsoumakas
 */
public class Transaction {
    private HashMap<String, Integer> items;

    public Transaction() {
        items = new HashMap<>();
    }

    /**
     * Η μέθοδος αυτή αντιστοιχεί στο σκανάρισμα ενός προϊόντος και άρα στην
     * προσθήκη του στην τρέχουσα συναλλαγή ενός πελάτη.
     * This method represents the scanning process in a supermarket. It adds the product
     * to the current transaction.
     *
     * @param product συμβολοσειρά με το όνομα του προϊόντος, π.χ. γάλα. String containing the name of
     *                the product e.g. milk
     */
    public void scanItem(String product) {
        scanItems(product, 1);
    }

    /**
     * Η μέθοδος αυτή αντιστοιχεί στο σκανάρισμα πολλών προϊόντων του ίδιου
     * είδους και προσθήκη τους στην τρέχουσα συναλλαγή ενός πελάτη.
     * <p>
     * This method represents the scanning of the same product multiple times
     * and adds them to the customers transactions.
     *
     * @param product συμβολοσειρά με το όνομα του προϊόντος, π.χ. γάλα. String containing the name of
     *                the product e.g. milk
     * @param amount  ποσότητα προϊόντος. The amount of the products
     */
    public void scanItems(String product, int amount) {
        if (items.containsKey(product)) {
            items.put(product, items.get(product) + amount);
        } else {
            items.put(product, amount);
        }
    }

    /**
     * Η μέθοδος αυτή επιστρέφει τo πλήθος εμφάνισης ενός προϊόντος στο
     * καλάθι ενός πελάτη.
     * The number of times a product appears in the basket.
     *
     * @param product συμβολοσειρά με το όνομα του προϊόντος, π.χ. γάλα. String containing the name of
     *                the product e.g. milk
     */
    public int getAmountOfProduct(String product) {
        //return items.getOrDefault(product, 0);

        if (items.containsKey(product)) {
            return items.get(product);
        } else {
            return 0;
        }
    }

    /**
     * Η μέθοδος αυτή επιστέφει έναν πίνακα με τα ονόματα των προϊόντων που
     * υπάρχουν στο καλάθι του πελάτη. Αν το ίδιο προϊόν υπάρχει πάνω από μία
     * φορές στο καλάθι, θα πρέπει στον επιστρεφόμενο πίνακα να εμφανίζεται μία
     * φορά μόνο.
     * <p>
     * This method returns a table with the names of the products that exist in the basket.
     * The returning table should not contain duplicate items and each product should appear only once.
     *
     * @return ο πίνακας με τα ονόματα των προϊόντων. The table with the names of the products purchased.
     */
    public String[] getProducts() {
        String[] products = new String[items.keySet().size()];
        Iterator<String> it = items.keySet().iterator();
        for (int i = 0; i < products.length; i++) {
            products[i] = it.next();
        }
        return products;

//        String[] products = new String[items.keySet().size()];
//        return items.keySet().toArray(products);
    }
}
