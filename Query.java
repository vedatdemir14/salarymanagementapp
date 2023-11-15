package Objects;
import Managements.TransactionManagement;
import Managements.SalaryManagement;

public class Query {

    private TransactionManagement transactionManagement;
    private SalaryManagement salaryManagement;

    public Query(TransactionManagement transactionManagement, SalaryManagement salaryManagement) {
        this.transactionManagement = transactionManagement;
        this.salaryManagement = salaryManagement;
    }

    public Transaction findHighestTotalPriceTransaction() {
        Transaction highestTransaction = null;
        double highestTotalPrice = 0.0;

        
        for (int i = 0; i < transactionManagement.getNumShopAssistant(); i++) {
            for (int j = 0; j < transactionManagement.getTotalTransaction(); j++) {
                Transaction currentTransaction = transactionManagement.getTransaction()[i][j];
                if (currentTransaction != null) {
                    if (currentTransaction.totalPrice > highestTotalPrice) {
                        highestTotalPrice = currentTransaction.totalPrice;
                        highestTransaction = currentTransaction;
                    }
                }
            }
        }

        return highestTransaction;
    }

    public Product findMostExpensiveProductInLowestPriceTransaction() {
        Product mostExpensiveProduct = null;
        double lowestTotalPrice = Double.MAX_VALUE;

        
        for (int i = 0; i < transactionManagement.getNumShopAssistant(); i++) {
            for (int j = 0; j < transactionManagement.getTotalTransaction(); j++) {
                Transaction currentTransaction = transactionManagement.getTransaction()[i][j];
                if (currentTransaction != null) {
                    if (currentTransaction.totalPrice < lowestTotalPrice) {
                        lowestTotalPrice = currentTransaction.totalPrice;
                        // Find the most expensive product in this transaction
                        for (Product product : currentTransaction.TransactionProducts) {
                            if (product != null && product.getProductPrice() > mostExpensiveProduct.getProductPrice()) {
                                mostExpensiveProduct = product;
                            }
                        }
                    }
                }
            }
        }

        return mostExpensiveProduct;
    }

    public Transaction findLowestTransactionFee() {
        Transaction lowestTransaction = null;
        double lowestTransactionFee = Double.MAX_VALUE;

        
        for (int i = 0; i < transactionManagement.getNumShopAssistant(); i++) {
            for (int j = 0; j < transactionManagement.getTotalTransaction(); j++) {
                Transaction currentTransaction = transactionManagement.getTransaction()[i][j];
                if (currentTransaction != null) {
                    double currentTransactionFee = currentTransaction.transactionFee;
                    if (currentTransactionFee < lowestTransactionFee) {
                        lowestTransactionFee = currentTransactionFee;
                        lowestTransaction = currentTransaction;
                    }
                }
            }
        }

        return lowestTransaction;
    }

    public ShopAssistant findHighestSalaryShopAssistant() {
        ShopAssistant highestSalaryAssistant = null;
        double highestSalary = 0.0;

        for (ShopAssistant shopAssistant : salaryManagement.getShArray()) {
            if (shopAssistant.finalSalary > highestSalary) {
                highestSalary = shopAssistant.finalSalary;
                highestSalaryAssistant = shopAssistant;
            }
        }

        return highestSalaryAssistant;
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;

        // Iterate through transactions
        for (int i = 0; i < transactionManagement.getNumShopAssistant(); i++) {
            for (int j = 0; j < transactionManagement.getTotalTransaction(); j++) {
                Transaction currentTransaction = transactionManagement.getTransaction()[i][j];
                if (currentTransaction != null) {
                    totalRevenue += currentTransaction.totalPrice;
                }
            }
        }

        return totalRevenue;
    }

    public double calculateTotalProfit() {
        double totalProfit = 0.0;

        // Iterate through transactions
        for (int i = 0; i < transactionManagement.getNumShopAssistant(); i++) {
            for (int j = 0; j < transactionManagement.getTotalTransaction(); j++) {
                Transaction currentTransaction = transactionManagement.getTransaction()[i][j];
                if (currentTransaction != null) {
                    double transactionFee = currentTransaction.transactionFee();
                    totalProfit += currentTransaction.totalPrice - transactionFee;
                }
            }
        }

        return totalProfit;
    }

    public void printQueries() {
        System.out.println("Highest Total Price Transaction: ");
        Transaction highestTotalPriceTransaction = findHighestTotalPriceTransaction();
        if (highestTotalPriceTransaction != null) {
            System.out.println(highestTotalPriceTransaction);
        } else {
            System.out.println("No transactions found.");
        }

        System.out.println("Most Expensive Product In Lowest Price Transaction: ");
        Product mostExpensiveProduct = findMostExpensiveProductInLowestPriceTransaction();
        if (mostExpensiveProduct != null) {
            System.out.println(mostExpensiveProduct);
        } else {
            System.out.println("No products found.");
        }

        System.out.println("Lowest Transaction Fee: ");
        Transaction lowestTransactionFee = findLowestTransactionFee();
        if (lowestTransactionFee != null) {
            System.out.println(lowestTransactionFee);
        } else {
            System.out.println("No transactions found.");
        }

        System.out.println("Highest Salary Shop Assistant: ");
        ShopAssistant highestSalaryAssistant = findHighestSalaryShopAssistant();
        if (highestSalaryAssistant != null) {
            System.out.println(highestSalaryAssistant);
        } else {
            System.out.println("No shop assistants found.");
        }

        System.out.println("Total Revenue: " + calculateTotalRevenue() + " TL");
        System.out.println("Total Profit: " + calculateTotalProfit() + " TL");
    }
}