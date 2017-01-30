/**
 * Week 5 Team Project
 * Code written by Team B
 * PRG/420
 * Date: 3-5-15
 * Instructor Name: Don
 */

// This class file is used to create a custom salesperson object.
public class SalesPerson 
{
    private final double salary = 50000.00; // Salesperson's base pay constant.
    private final double salesTarget = 120000.00; // Desired sales goal.
    // Following used to determine if enough sales were made to earn commission.
    private final double standardCommissionTarget = .80; 
    private final double commissionRate = .05; // Commission rate constant.
    // Following additional commission on sales over targeted sales goal.
    private final double commissionAcceleratedRate = .0125; 
    private double totalSalesMade; // Used for salesperson's sales made.
    private double commissionPay; // Used to determine commission earned.
    private String salespersonName; // Salesperson's name.
        
    // Associate name data from main program file. 
    public void setName(String employeeName)
    {
        salespersonName = employeeName;
    }
    
    // Associate sales data from main program file.
    public void setSales(double sales)
    {
        totalSalesMade = sales;
    }
    
    /* This method will display both first and last names of a salesperson
     * separated by a space when called upon. 
     */
    public String getSalepersonName()
    {
        return salespersonName;
        
    }
    
    /* Used to retrieve total sales from within an instance of the 
     * SalesPerson class.
     */
    public double getSalesMade()
    {
        return totalSalesMade;
    }
    
    /* Calculate the total commission earned.  Conditional if statements
     * determine what commission level the sales person has reached based
     * on total sales.  Sales under 80% of sales goal does not qualify for
     * an added commission.  Sales between 80% and 100% of sales goal will
     * receive a commission of 5% of the total sales.  If a salesperson
     * obtains sales levels above 100% of the sales goal the commission rate
     * increases an additional 1.25% for a total of 6.25% of the total sales.
     */
    public double getCommissionEarned()
    {
        if (totalSalesMade <= (salesTarget * standardCommissionTarget))
        {
            commissionPay = totalSalesMade * 0;
        }
        else if (totalSalesMade <= salesTarget)
        {
            commissionPay = totalSalesMade * commissionRate;
        }
        else if(totalSalesMade > salesTarget)
        {
            commissionPay = totalSalesMade * 
                            (commissionRate + commissionAcceleratedRate);
        }
        return commissionPay;
    }
    
    // Calculate the total amount the salesperson made.
    public double getTotalEarnings()
    {
        return salary + getCommissionEarned(); 
    }
}