/**
 * Programmer : Rishab Singh
 * Program    : Book.java
 * Date       : April 2021
 * @version 6.3 * @author risha
 */
package application;

public class Book 
{
   private String bookname,author;
   private int quantity;
   private double price;

   public Book() {
   }

   public Book(String bookname, String author, int quantity, double price) {
       this.bookname = bookname;
       this.author = author;
       this.quantity = quantity;
       this.price = price;
   }

   public String getBookname() {
       return bookname;
   }

   public String getAuthor() {
       return author;
   }

   public int getQuantity() {
       return quantity;
   }

   public double getPrice() {
       return price;
   }

   public void setBookname(String bookname) {
       this.bookname = bookname;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }

   public void setPrice(double price) {
       this.price = price;
   }   
}
