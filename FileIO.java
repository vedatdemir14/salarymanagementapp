package FileInputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

import Objects.Product;

import Objects.ShopAssistant;




public class FileIO {
    private static Product getProductByTokens(Object... tokens) {

        int id = (int) tokens[0];
        String productName = (String) tokens[1];
        double price = (double) tokens[2];

        return new Product(id, productName, price);
    }

    public static Product[] readProductFromCSV(String path) {
        StringTokenizer st = null;
        int arrayLength = 0;

        arrayLength += getCsvLengthByPath(path);

        Product[] tempArr = new Product[arrayLength];

        int counter = 0;
        File file = new File(path);
        try (BufferedReader br = new BufferedReader((new FileReader((file))))) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                st = new StringTokenizer(line, ";");

                while (st.hasMoreTokens()) {
                    tempArr[counter] = getProductByTokens(st.nextToken(), st.nextToken(), st.nextToken());
                    counter++;
                }
            }
            return tempArr;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static ShopAssistant getShopAssistantByTokens(Object... tokens) {

        int id = (int) tokens[0];
        String name = (String) tokens[1];
        String surname = (String) tokens[2];
        String phoneNumber = (String) tokens[3];


        return new ShopAssistant(id, name, surname, phoneNumber);
    }

    public static ShopAssistant[] readShopAssistantFromCSV(String path) {
        StringTokenizer st = null;
        int arrayLength = 0;

        arrayLength += getCsvLengthByPath(path);

        ShopAssistant[] tempArr = new ShopAssistant[arrayLength];

        int counter = 0;
        File file = new File(path);
        try (BufferedReader br = new BufferedReader((new FileReader((file))))) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                st = new StringTokenizer(line, ";");

                while (st.hasMoreTokens()) {
                    tempArr[counter] = getShopAssistantByTokens(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    counter++;
                }
            }
            return tempArr;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static int getCsvLengthByPath(String path) {
        int arrayLength = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            while (br.readLine() != null)
                arrayLength++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayLength;
    }

    private static Product getProductById(int id, Product[] products) {
        for (Product product : products) {
            if (Objects.equals(product.getProductId(), id)) {
                return new Product(product.getProductId(), product.getProductName(), product.getProductPrice());
            }
        }
        return null;
    }

    public static Product getProductById(int id) {
        for (Product product : readProductFromCSV("products.csv")) {
            if (Objects.equals(product.getProductId(), id)) {
                return new Product(product.getProductId(), product.getProductName(), product.getProductPrice());
            }
        }
        return null;
    }

    private static ShopAssistant getShopAssistantById(int id, ShopAssistant[] shopAssistants) {
        for (ShopAssistant shopAssistant : shopAssistants) {
            if (Objects.equals(shopAssistant.getShopAssistantID(), id)) {
                return new ShopAssistant(shopAssistant.getShopAssistantID(), shopAssistant.getShopAssistantName(), shopAssistant.getShopAssistantSurname(), shopAssistant.getShopAssistantPhoneNumber());
            }
        }
        return null;

    }

    public static ShopAssistant getShopAssistantById(int id) {
        for (ShopAssistant shopAssistant : readShopAssistantFromCSV("shopAssistants.csv")) {
            if (Objects.equals(shopAssistant.getShopAssistantID(), id)) {
                return new ShopAssistant(shopAssistant.getShopAssistantID(), shopAssistant.getShopAssistantName(), shopAssistant.getShopAssistantSurname(), shopAssistant.getShopAssistantPhoneNumber());
            }
        }
        return null;
    }


}



