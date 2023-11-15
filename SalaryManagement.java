package Managements;
import Objects.ShopAssistant;
import FileInputOutput.FileIO;

public class SalaryManagement {
    public ShopAssistant[] shArray;

    public SalaryManagement() {
        FileIO file = new FileIO();
        shArray = new ShopAssistant[100];
        for (int i = 0; i < 100; i++) {
            shArray[i] = new ShopAssistant(file.getShopAssistantById((i)));
        }
    }
    public int calculateSalariesForShopAssistants(){
        return ShopAssistant.finalSalary;
    }
    public ShopAssistant[] getShArray() {
        return shArray;
    }


}