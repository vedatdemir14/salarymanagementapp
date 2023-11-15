package Objects;

import Objects.Product;

import java.util.Random;

public class Transaction {
    private int transactionID;
    public Transaction[] TransactionProducts;
    private double totalPrice;
    private double transactionFee;

    public Transaction(int transactionID, Transaction[] transactions,double totalPrice, double transactionFee){
        this.transactionID = transactionID;
        this.transactionFee = transactionFee;
        this.totalPrice = calculateTotalPrice();


    }
    private double calculateTotalPrice(){
        totalPrice = 0.0;
        for (Transaction transactions: TransactionProducts){
        	Random rand = new Random();
        	int numOfProduct = rand.nextInt(10) + 1;
            totalPrice +=Objects.Product.product.getProductPrice() * numOfProduct;
        }
        return totalPrice;
    }
    private Transaction[] createProductsArray(Transaction[] args) {
        Transaction[] transactions = new Transaction[3];
        Random random = new Random();
        int index_1 = new random.nextInt(90);
        transactions[0] = new Product.getProductById(index_1);
        int index_2 = new random.nextInt(90);
        transactions [1] = new Product.getProductById(index_2);
        int index_3 = new random.nextInt(90);
        transactions [2] = new Product.getProductById(index_3);

        return transactions;

    }
    public double calculateTransactionFee(double totalPrice) {
        double transactionFee;
        if (totalPrice <= 499) {
            transactionFee = 0.01 * totalPrice; // 1% of the total price
        } else if (totalPrice <= 799) {
            transactionFee = 0.03 * totalPrice; // 3% of the total price
        } else if (totalPrice <= 999) {
            transactionFee = 0.05 * totalPrice; // 5% of the total price
        } else {
            transactionFee = 0.09 * totalPrice; // 9% of the total price
        }
        return transactionFee;
    }


    }













