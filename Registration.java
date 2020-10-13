import java.util.*;

class employee   
	{
         String name;
         String job ;
         String company;
         
        public void setdata(String n, String j, String c)    //method to register data of registration
        	{
            	name = n;
            	job = j;
            	company = c;
        	}
        public void show()      // method to print list of registrants
        	{
        		System.out.print("\t\t"+name);
        		System.out.print("\t\t "+ job);
        		System.out.print("\t\t "+company); 
        	}
       
	}
 
public class Registration
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int i, q, z = 0;
        employee  emp[]=new employee[100];            // create array of 100 employees for registrations
        int menuChoice;
        int c;
        
        do
        {
            System.out.print("\n\t\t\tConference Registrarion System");// menu for choice
            System.out.print("\n\t\t1. Add a Registrant\n\t\t2. See all Registrants\n\t\t3. Delete a Registrant\n\t\t4. Exit");
            System.out.print("\n\nEnter a choice: ");
            menuChoice = in.nextInt();
            in.nextLine();
            String ans="y";
            if (menuChoice==1)            // enter registrant details
            {
               
               while(ans.equals("y") || ans.equals("Y") && z<100) 
               {
                emp[z] = new employee(); //object  creation from employee class 
                
                System.out.print("Enter Full name:");
                String nm = in.nextLine();
                System.out.print("Enter JOB:");
                String jb = in.nextLine();
                System.out.print("Enter Company:");
                String cm = in.nextLine();
                
                emp[z].setdata(nm,jb,cm); 
              
                System.out.println("Want to enter more y/n");
                ans=in.nextLine();
                z++;
               }
            }
                       else if (menuChoice==2) // print list of registrants
                       {
                System.out.println("Total Resgistrants =  " +z);           
                System.out.print("Sr. No.");
                System.out.print("\t\t Name");
                System.out.print("\t\t JOB");
                System.out.print("\t\t Company");
                System.out.print("\n===========================================================================");
                           for (i=0; i<z; i++)
                           {
                             System.out.print("\n"+(i));
                             emp[i].show();
                            }
                System.out.print("\n===========================================================================");
                       }
                       else if (menuChoice==3)  // to delete record
                       {
                           System.out.print("\nEnter Serial No of Registrants to be Deleted = ");
                           q = in.nextInt();

                //from current location (to be deleted) upto end, Shift next record to current location, and so on              
                           for (i=q-1; i<z-1; i++)
                           {
                               emp[i].name =emp[i+1].name;
                               emp[i].job=emp[i+1].job;
                               emp[i].company=emp[i+1].company;
                            }
                            z--;            //delete last location, record will be deleted in array
                            System.out.print("\nRecord Deleted Successfully...");
                          
                       }

        } while (menuChoice<4);
    }
}
