/*The purpose of this program is to compare salespersons sale information
 * to determine who the highest and lowest seller was, and how much difference
 * there was between the highest and lowest seller.
 */

/* The following import statements import necessary Java classes that are used
 * to convert a number to a currency format, set a pattern, look for that
 * pattern, and create data widows that display messages and request user
 * input. 
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

 
/**
 * Week 5 Team Project
 * Code written by: Team B 
 * PRG/420
 * Date: 3-5-15
 * instructor Name: Don
 */
public class SalaryCalculator 
{
 
    public static void main(String[] args) 
    {
        final int SALES_STAFF = 2; // Used to set the size of each of the arrays.
        double sales; // The amount of sales done by salesperson.
        String salesperson; // Used to set the name of each salesperson.
        String input; // Input for amount of sales.
        String topSeller; // Stores the top seller name.
        String lowestSeller; // Stores the lowest seller's name.
        double topSales; // Used to store the top sales total.
        double leastSales; // Used to store the lowest sales total.
        
        /* Initiates two arrays that are used to determine high and low sales 
         * totals and highest and lowest seller. 
         */
        double[] totalSales;
        String[] salespersonNames;
        
        // Used to format variables into currency format.
        DecimalFormat formatter = new DecimalFormat ("#0,000.00");
                

        /* The following declares an array of object created from
         * the SalesPerson class file.
         */                
        SalesPerson[] staff = new SalesPerson[SALES_STAFF];
        
        // Start of data entry for each sales person.
        for (int x = 0; x < SALES_STAFF; x++)
        {
            
           /* Initiates a new instance of the Sales person class and assigns
            * the index number for the staff array of each SalePerson
            * object created
            */
            staff[x] = new SalesPerson();
            
            // Open a data entry window for the salesperson name.
            salesperson = JOptionPane.showInputDialog ("Enter Salesperson" 
                    + (x + 1) + "'s name." , "Salesperson" + (x + 1));
            
            /* Loop for error checking that causes the program to end if the 
             * cancel button is pressed on the salesperson data entry window
             * preventing an error message.
             */
            if(salesperson == null)
            {
                System.exit(0);
            }
            
            /* Following sends the salesperson's first and last name to 
             * the each SalesPerson object created during the loop.
             */ 
            staff[x].setName(salesperson);
            
            // Open a data entry window for the total sales input.
            input = JOptionPane.showInputDialog("Enter " 
                    + staff[x].getSalepersonName() + "'s annual sales.");
            
            /* Loop for error checking that causes the program to end if the 
             * cancel button is pressed on the sales input data entry window
             * preventing an error message.
             */
            if(input == null)
            {
                System.exit(0);
            }
            
            /* The following loop will allow a user to enter invalid data three
             * tries for each salesperson before terminating the program.
             */
            for(int y = 1; y <= 4; y++)
            {
                try
                {
                    // Converts input string to a double variable type.
                    sales = Double.parseDouble(input);
                                                            
                    // Sets the sales total in the SalePerson object.
                    staff[x].setSales(sales);
                }
                catch(NumberFormatException nfe)
                {                                            
                    {
                        if (y == 4)
                        {
                            JOptionPane.showMessageDialog(null, "You have " 
                                    + "failed to enter a valid sales\n"
                                    + "number in the allowed entry attempts.\n"
                                    + "This program is now going to terminate.\n"
                                    + "To try again please restart the program");
                            System.exit(0);
                        }
                        input = JOptionPane.showInputDialog("Enter"
                                + staff[x].getSalepersonName() + "annual sales "
                                + "again.\n" + "Numbers only please.\n"
                                + "You have " + (4 - y) + " tries remaining\n"
                                + "before the program will terminate.");
                    
                        /* Loop for error checking that causes the program to end
                         * if the cancel button is pressed on the sales input data
                         * entry window preventing an error message.
                         */
                        if(input == null)
                        {
                            System.exit(0);
                        }
                        
                        
                    }
                }                                                      
            }
            
                        
            /* Displays salesperson earnings total with both base pay and 
             * commission.
             */            
            JOptionPane.showMessageDialog(null, "Hello " 
                    + staff[x].getSalepersonName() + "\n"
                    + "Your total annual pay is $ "
                    + formatter.format(staff[x].getTotalEarnings()));
        }
        
        /* Initiates the totalSales and salespersonNames arrays used to 
         * identify highst and lowest salespersons.
         */ 
        totalSales = new double[SALES_STAFF];
        salespersonNames = new String[SALES_STAFF];
        
        /* Assigns sales totals and salesperson names to the above array 
         * indexes.
         */
        for (int x = 0; x < SALES_STAFF; x++)
        {
            totalSales[x] = staff[x].getSalesMade();
            salespersonNames[x] = staff[x].getSalepersonName();
        }
        
        /* Creates a variable to store the top sales person's data
         * established in totalSales array.  The initial value assigns
         * the value of the totalSales array zero index.
         */
        topSales = totalSales[0];
        
        /* This line initially sets the topSeller name to the value
         * contained in the salesperson array (created above) index 
         * position zero.
         */
        topSeller = salespersonNames[0];
        
        /*The following loop scans each value of the totalSales array
         * and compares it to identify the highest sales total.  Once
         * the highest total is found, the topSeller variable will be
         * assigned the salesperson name of the salesperson that matches
         * the index value from the staff array initially created.
         */
        for (int x = 0; x < SALES_STAFF; x++)
        {
            if (totalSales[x] > topSales)
            {
                topSales = totalSales[x];
                topSeller = salespersonNames[x];
            }
        }
        
        /* The following loop scans each value of the totalSales array
         * and compares it to identify the lowest sales total.  Once
         * the lowest total is found, the lowestSeller variable will be
         * assigned the salesperson name of the salesperson that matches
         * the index value from the staff array initially created.
         */
        leastSales = totalSales[0];
        
        /* This line initially sets the lowestSeller name to the value
         * contained in the salesperson array (created above) index 
         * position zero.
         */
        lowestSeller = salespersonNames[0];
                
        for (int x = 0; x < SALES_STAFF; x++)
        {
            if (totalSales[x] < leastSales)
            {
                leastSales = totalSales[x];
                lowestSeller = salespersonNames[x];
            }
        }
        
        /*Sets conditions that determine the output message based on who had
         * the most sales, or if everyone sold the same amount. 
         */
        if (topSales != leastSales)
        {
            JOptionPane.showMessageDialog(null,lowestSeller + " needs to sell "
                    + "$ " + formatter.format(topSales - leastSales) 
                    + " more to match " + topSeller + "'s sales totals.");
        }
        else if (topSales == leastSales)
        {
            JOptionPane.showMessageDialog(null,"Everyone made the same amount "
                    + "of sales totals.");
        }
        // Terminates the program.
        System.exit(0);
    }
}