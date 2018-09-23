/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class CartItems
{

    private String productName, email;
    private int quantity,pid;
    private double price, subTotal, totalOrderCost;

    public CartItems()
    {
    }

    public CartItems(String email, String productName, int quantity, double price, double subTotal, double totalOrderCost,int pid)
    {

    }

    public int getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getSubTotal()
    {
        return subTotal;
    }

    public void setSubTotal(double subTotal)
    {
        this.subTotal = subTotal;
    }

    public double getTotalOrderCost()
    {
        return totalOrderCost;
    }

    public void setTotalOrderCost(double totalOrderCost)
    {
        this.totalOrderCost = totalOrderCost;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

}
