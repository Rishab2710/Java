/**
 * Programmer : Rishab Singh
 * Program    : BookGUI.java
 * Date       : April 2021
 * @version 6.2 * @author risha
 */

	package application;


	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.ResourceBundle;
	import java.util.Scanner;
	import javafx.collections.ObservableList;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.Initializable;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import javafx.scene.control.Alert.AlertType;
	import java.lang.Math;
	
	/**
	 * FXML Controller class
	 *
	 * @author rishab
	 */
	public class BookGUI implements Initializable {
	    
		
	    static int i=0;
	    PrintWriter output;
	    Scanner input;
	    File myfile;
	    
	    /**
	     * Intialized buttons, text fields and text area
	     */
	    
	    @FXML private Button add;
	    @FXML private Button next;
	    @FXML private Button save;
	    @FXML private Button exit;
	    @FXML private Button previous;
	    @FXML private Button edit;
	    @FXML private Button display;
	    @FXML private Button search;
	    @FXML private Button write;
	    @FXML private TextField bname;
	    @FXML private TextField authname;
	    @FXML private TextField price;
	    @FXML private TextField noOfBooks;
	    @FXML private TextField searchfield;
	    @FXML private TextArea textArea;
	    
	    
	    //create array list name Book
	    ArrayList<Book> list=new ArrayList<Book>();
	    ArrayList options = new ArrayList();
	    
	    ObservableList<String> items;	      
  
	    //Creating the exit button function
	    @FXML
	    private void exit1(ActionEvent event)
	    {
	    	System.exit(0);
	    }
	    
	  //Creating the edit button function
		  @FXML
		    private void edit1(ActionEvent event)
		    {
			  int a = i;
			  
				Book bl = list.get(a);

				bname.setText(bl.getBookname());
				authname.setText(bl.getAuthor());
				price.setText(Double.toString(bl.getPrice()));
				noOfBooks.setText(Integer.toString(bl.getQuantity()));

		    }
		  
		//Creating the previous button function
		    @FXML
		    private void previous1(ActionEvent event)
		    {
		        try
		        {
		        i--;
		        bname.setText(list.get(i).getBookname());
		        authname.setText(list.get(i).getAuthor());
		        price.setText(String.valueOf(list.get(i).getPrice()));
		        noOfBooks.setText(String.valueOf(list.get(i).getQuantity()));
		        if(i==0)
		            previous.setDisable(true);
		        else
		            previous.setDisable(false);
		        
		        if(i==list.size()-1)
		                next.setDisable(true);
		        else
		                next.setDisable(false);
		        }
		        catch(IndexOutOfBoundsException e)
		        {
		            System.out.println("previous"+e.getMessage());
		        }
		    }
		    
		  //Creating the next button function
		    @FXML
		    private void next1(ActionEvent event)
		    {
		        try
		        {
		        
		        i++;
		        bname.setText(list.get(i).getBookname());
		        authname.setText(list.get(i).getAuthor());
		        price.setText(String.valueOf(list.get(i).getPrice()));
		        noOfBooks.setText(String.valueOf(list.get(i).getQuantity()));
		        
		        if(i==0)
		            previous.setDisable(true);
		        else
		            previous.setDisable(false);
		        
		        if(i==list.size()-1)
		                next.setDisable(true);
		        else
		                next.setDisable(false);
		        }
		        catch(IndexOutOfBoundsException e)
		        {
		            System.out.println("next"+e.getMessage());
		        }
		    }
		    
		  //Creating the add button function
		    @FXML
		    private void add1(ActionEvent event)
		    {
		    	Book bk =new Book();
				
				bk.setBookname(bname.getText());	//set the value from textfield to function Bookname
				bk.setAuthor(authname.getText());	//set the value from textfield  to function author
				bk.setPrice(Double.parseDouble(price.getText()));	//Set the price and converts in double
				bk.setQuantity(Integer.parseInt(noOfBooks.getText()));	//Set the quantity and converts in integer
  
				list.add(bk);
  
				String w = "";
				
				for(int y=0; y < list.size(); y++){	//For Loop

					Book bl = list.get(y); 
					w += "Data " + (y+1);
					w += "\nName: "+bl.getBookname();	//Gets the name of book
					w += "\nAuthor: "+bl.getAuthor();	//Gets the name of author
					w += "\nUnit Price: $"+bl.getPrice();//Gets the price
					w += "\nQty: "+bl.getQuantity();//Gets the quantity
					w += "\nTotal: $"+Math.round(bl.getPrice()*bl.getQuantity()*100.0)/100.0+"\n\n";//rounds the total to 2 decimal places and stores in total
					textArea.setText(w);
					  
				}
  
				///Alert Box 
				Alert al = new Alert(AlertType.INFORMATION);
				al.setTitle("Information");
				al.setHeaderText("Data Adding");
				al.setContentText(bname.getText()+"\n"+ authname.getText()+"\n"+ price.getText()+"\n"+ noOfBooks.getText()+"\n"+"\n\nData Added succesfully");
				al.show();       
		    }
		    
		  //Creating the save button function
		    @FXML
		    private void save1(ActionEvent event)
		    {
		    	list.get(i).setBookname(bname.getText());	//Sets the name of book
				list.get(i).setAuthor(authname.getText());	//Sets the name of author
				list.get(i).setPrice(Double.parseDouble(price.getText()));	//Sets the price
				list.get(i).setQuantity(Integer.parseInt(noOfBooks.getText()));	//Sets the quantity
  
				 //message box alert 
				Alert al = new Alert(AlertType.INFORMATION);
				al.setTitle("Information");
				al.setHeaderText("Data Savinging");
				al.setContentText(bname.getText()+"\n"+authname.getText()+"\n"+price.getText()+"\n"+noOfBooks.getText()+"\n"+"\n\nData Saved succesfully");
				al.show();
   
				String s = "";
				for(int y =0 ; y < list.size(); y++){	//loop start from 0 to the size of booklst
					Book bl = list.get(y); 
					s += "Data "+ (y+1);
					s += "\nName: "+ bl.getBookname();
					s += "\nAuthor: "+ bl.getAuthor();
					s += "\nUnit Price: $"+ bl.getPrice();
					s += "\nQty: "+bl.getQuantity();
					s += "\nTotal: $"+Math.round(bl.getPrice()*bl.getQuantity()*100.0)/100.0+"\n\n"; //rounds the total to 2 decimal places and stores in total
					textArea.setText(s);	//set all the values in textarea
				}
		    }
		    
		    @FXML
		    public void search1(ActionEvent event) {
		    	String bn=searchfield.getText();
		    	String s="";
		    	for(int a=0;a<list.size();a++){
		    		Book b=list.get(a);
		    		String s2=b.getBookname();

		    		
		    		//getting book data 
		    		if(s2.contains(bn)){
		    			s+="Data "+(a+1);
		    			s+="\nName: "+b.getBookname();
		    			s+="\nAuthor: "+b.getAuthor();
		    			s+="\nUnit Price: $"+b.getPrice();
		    			s+="\nQty: "+b.getQuantity();
		    			s+="\nTotal: $"+ Math.round(b.getPrice()*b.getQuantity()*100.0)/100.0 +"\n\n";//rounds the total to 2 decimal places and stores in total
		    			textArea.setText(s);
		    		}
		    		else{
		    			System.out.println("not");
		    		}
		    	}
		    }
		   
		   
		  //Creating the write button function
		    @FXML
		    private void write1(ActionEvent event)
		    {
		        
		    	try
		        {
		            PrintWriter pr=new PrintWriter(myfile);
		            System.out.println("printwiter pr empty file");
		            pr.print("");
		            pr.close();
		            
		            FileWriter fw=new FileWriter(myfile,true); //append mode
		            output=new PrintWriter(fw);
		            System.out.println("printwriter output append mode");
		            for(int y=0;y<list.size();y++)
		            {
		                output.println(list.get(y).getBookname()+","+list.get(y).getAuthor()+","+list.get(y).getPrice()+","+list.get(y).getQuantity());
		                
		            }
		            output.close();
		        }
		        catch(Exception e)
		        {
		            System.out.println("error in write1");
		        }
		    }
		    
		    //Displays the information from text file which is already stored seperately
		    @FXML
		    private void display1(ActionEvent event)
		    {
		    	File fr = new File("C:\\MyJavaFolder\\Rishab\\Assignment 6\\src\\application\\books.txt");
		    	try {

		    		BufferedReader br = new BufferedReader(new FileReader(fr));
		    		String line="";

		    		while ((line = br.readLine()) != null) {
		    			String [] splt=line.split(",");
		    			Book book=new Book();
		    			book.setBookname(splt[0]);
		    			book.setAuthor(splt[1]);
		    			book.setPrice(Double.parseDouble(splt[2]));
		    			book.setQuantity(Integer.parseInt(splt[3]));

		    			list.add(book);
		    		}

		    		String s="";
		    		for(int a=0;a<list.size();a++){
		    			Book b=list.get(a);
		    	
		    			//getting book data  
		    			s+="Data "+(a+1);
		    			s+="\nName: "+b.getBookname();
		    			s+="\nAuthor: "+b.getAuthor();
		    			s+="\nUnit Price: $"+b.getPrice();
		    			s+="\nQty: "+b.getQuantity();
		    			s+="\nTotal: $"+Math.round(b.getPrice()*b.getQuantity()*100.0)/100.0+"\n\n";//rounds the total to 2 decimal places and stores in total
		    		}

		    		textArea.setText(s);
		    	}
		    	
		    	catch (IOException ex) {
		    		ex.printStackTrace();
		    	}
		    	
		    }
		  
		    @Override
		    public void initialize(URL url, ResourceBundle rb) {
		            
		        myfile=new File("C:\\Users\\risha\\Downloads\\books1.txt"); //relative path
		                 
		      try
		      {
		          if(myfile.exists())
		          {
		              input=new Scanner(myfile);
		              while(input.hasNext())
		              {
		                  String s=input.next();
		                  Scanner r=new Scanner(s);
		                  r.useDelimiter(",");
		                  Book st=new Book();
		                  st.setBookname(r.next());
		                  st.setAuthor(r.next());
		                  st.setPrice(r.nextInt());
		                  st.setQuantity(r.nextInt());
		                  list.add(st);
		                  bname.setText(list.get(i).getBookname());
		                  authname.setText(list.get(i).getAuthor());
		                  price.setText(String.valueOf(list.get(i).getPrice()));
		                  noOfBooks.setText(String.valueOf(list.get(i).getQuantity()));
		              }
		          }
		          else
		          {
		              System.err.println("file not exists add record first");
		          }
		          input.close();
		      }
		      catch(Exception e)
		      {
		          System.out.println("error in initialize");
		      }
		    }    
		    
		}
