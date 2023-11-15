package Objects;
import java.util.Random;

public class ShopAssistant{
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;

    private int weeklySalaryBasis;

    public static int finalSalary;

    private int seniority;


    public ShopAssistant(int id, String name, String surname, String phoneNumber, int weeklySalaryBasis, int finalSalary, int seniority){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.weeklySalaryBasis = weeklySalaryBasis;
        this.seniority = seniority;
    }
    public ShopAssistant(ShopAssistant shopAssistant) {
        this.id = shopAssistant.id;
        this.name = shopAssistant.name;
        this.surname = shopAssistant.surname;
        this.phoneNumber = shopAssistant.phoneNumber;
        this.weeklySalaryBasis = shopAssistant.weeklySalaryBasis;
        this.seniority = getSeniority();
    }
    public int getWeeklySalaryBasis() {
        return weeklySalaryBasis;
    }
    private void setWeeklySalaryBasis(int seniority) {
        if (seniority < 1) {
            this.weeklySalaryBasis = 1500;
        } else if (seniority >= 1 && seniority < 3) {
            this.weeklySalaryBasis = 2000;
        } else if (seniority >= 3 && seniority <= 5) {
            this.weeklySalaryBasis = 2500;
        } else {
            this.weeklySalaryBasis = 3000;
        }
    }
    public void calculateSalariesForShopAssistants() {
        for (ShopAssistant shopAssistant : shArray) {
            // Load the transactions for the shop assistant

            // Calculate commission based on total revenue
            double commission = Transaction.totalPrice > 7500 ? 0.03 : 0.01;

            // Calculate the weekly salary based on seniority
            double weeklySalary = calculateWeeklySalary(shopAssistant.getSeniority());

            // Calculate the total salary
            double totalSalary = weeklySalary + (commission * Transaction.totalPrice);

            // Update the shop assistant's total salary
            shopAssistant.setFinalSalary(totalSalary);
        }
    }
    public int getSeniority() {
        Random random = new Random();
        return random.nextInt(6);
    }
    public int calculateWeeklySalary(int seniority){
        int weeklySalary = 0;
        if (seniority < 1) {
            weeklySalary = 1500;
        } else if (seniority >= 1 && seniority < 3) {
            weeklySalary = 2000;
        } else if (seniority >= 3 && seniority <= 5) {
            weeklySalary = 2500;
        } else {
            weeklySalary = 3000;
        }
        return weeklySalary;

    }

    public int setFinalSalary(){
        int finalSalary_ = 0;
        finalSalary_ = weeklySalaryBasis + (commission * totalSalary);
        return finalSalary_;

    }


    public int getShopAssistantID() {
        return id;
    }

    public void setShopAssistantId(int id) {
        this.id = id;
    }

    public String getShopAssistantName() {
        return name;
    }

    public void setShopAssistantName(String name) {
        this.name = name;
    }

    public String getShopAssistantSurname() {
        return surname;
    }

    public void setShopAssistantSurname(String surname) {
        this.surname = surname;
    }

    public String getShopAssistantPhoneNumber() {
        return phoneNumber;
    }

    public void setShopAssistantPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }








}
