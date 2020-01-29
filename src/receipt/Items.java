/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receipt;

import static connect.connectoDB.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author beauty
 */
public class Items {
    private String itemname;
    private int itemid;
    private double itemPrice;
    private boolean selected;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Items(String itemname, int itemid, double itemPrice, int quantity) {
        this.itemname = itemname;
        this.itemid = itemid;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }
    

    public Items(String itemname, int itemid, double itemPrice) {
        this.itemname = itemname;
        this.itemid = itemid;
        this.itemPrice = itemPrice;
    }

    public Items(String itemname, double itemPrice) {
        this.itemname = itemname;
        this.itemPrice = itemPrice;
    }
    

    public Items(String itemname, int itemid, double itemPrice, boolean selected) {
        this.itemname = itemname;
        this.itemid = itemid;
        this.itemPrice = itemPrice;
        this.selected = selected;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public static ArrayList<Items> getAllItems() throws ClassNotFoundException {
        try {
            String sql = "SELECT * FROM item" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Items> ItemList= new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("itemId");
                String name = resultSet.getString("itemName");
                double price = resultSet.getDouble("price");
                Items item = new Items(name,id,price);
                ItemList.add(item) ;
            }
            System.out.println(ItemList);
            return ItemList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }   
    public static boolean saveItem( Items item) {
        try {
            String sql = "INSERT INTO item(itemId,itemName,price) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, new Random().nextInt(10000));
            pstmt.setString(2, item.getItemname());
            pstmt.setDouble(3, item.getItemPrice());
            int i = pstmt.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    
}
