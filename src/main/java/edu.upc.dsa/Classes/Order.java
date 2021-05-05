package edu.upc.dsa.Classes;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<String> productNames = new ArrayList<String>();
    private String userName;

    public Order() { }

    public Order(String user)
    {
        this.userName = user;
    }

    public void addProduct(String productName){

        productNames.add(productName);
    }


    public List<String> getProductNames() {
        return productNames;
    }
    public void setProductNames(List<String> names) {
        this.productNames = names;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {
        return "Order [comprador= "+ userName+ "lista de productos = " + productNames + "]";
    }

}
