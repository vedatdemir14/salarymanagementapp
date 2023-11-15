package Managements;
import Objects.Transaction;

public class TransactionManagement {
    private static int TOTAL_TRANSACTİON = 15;
    private Transaction[][] transactions;
    private int numShopAssistant;
    private int totalTransaction;

    public TransactionManagement(int numShopAssistantCapacity) {
        this.numShopAssistant  = numShopAssistantCapacity;
        this.totalTransaction = TOTAL_TRANSACTİON;
        this.transactions = new Transaction[numShopAssistant][totalTransaction];
    }
    public Transaction[][] getTransaction() {
        return transactions;
    }
    public int getNumShopAssistant() {
        return numShopAssistant;
    }
    public int getTotalTransaction() {
        return TOTAL_TRANSACTİON;
    }
    public int get


}

