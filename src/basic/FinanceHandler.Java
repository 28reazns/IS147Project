package basic;

public class FinanceHandler {
    // The day in which the most was spent
    private int highestDay;

    // The highest amount spent
    private double highestTotal;

    // Totals Spent (Per Day)
    public double[] totals = new double[7];

    // Categories
    public Category[] categories = {new Category("Gas"), new Category("Food")};

    /*
     * FinanceHandler Method
     * Will create a finance handler. It doesn't need any parameters, as it's only used
     * to handle and track total spending, and categories.
     *
     * Example Use 1:
     * FinanceHandler handler = new FinanceHandler();
     * handler.addCategory("Testing123");
     * */
    public FinanceHandler(){
        this.highestDay = 0;
        this.highestTotal = 0;
    }
    /*
     * addCategory Method
     * Creates a category with the given name and
     * adds said category to the handler's categories list with.
     *
     * Example Use 1:
     * FinanceHandler handler = new FinanceHandler();
     * handler.addCategory("Testing123");
     * */
    public void addCategory(String name){
        Category newCat = new Category(name);
        Category[] copy = new Category[this.categories.length+1];
        System.arraycopy(categories,0,copy,0,this.categories.length);
        copy[this.categories.length] = newCat;
        this.categories = copy;
    }
    /*
     * getHighestSpent Method
     * returns the highest value spent.
     *
     * Example Use 1:
     * FinanceHandler handler = new FinanceHandler();
     * handler.getHighestSpent(); -- Returns 0.0 because nothing was input!
     *
     * Example Use 2:
     * FinanceHandler handler = new FinanceHandler();
     * handler.set(3,1,50.0);
     * handler.getHighestSpent(); -- Returns 50.0
     * */
    public double getHighestSpent(){
        return highestTotal;
    }
    /*
     * getHighestDay Method
     * returns the day in which the user spent the most money.
     *
     * Example Use 1:
     * FinanceHandler handler = new FinanceHandler();
     * handler.getHighestSpent(); -- Returns 0 because nothing was input!
     *
     * Example Use 2:
     * FinanceHandler handler = new FinanceHandler();
     * handler.set(3,1,50.0);
     * handler.getHighestSpent(); -- Returns 3
     * */
    public int getHighestDay(){
        return highestDay;
    }
    /*
     * getHighestCategory Method
     * sets the category in which the most has been spent on.
     *
     * Example Use 1:
     * FinanceHandler handler = new FinanceHandler();
     * handler.set(3,1,50.0) - Sets the total spending on Gas for wednesday.
     * handler.getHighestCategory() - Returns Gas
     * */
    public Category getHighestCategory(){
        Category highest = new Category("None");
        double highestVal = 0;
        for (int i=0;i<this.categories.length;i++){
            if(categories[i].getTotal()>highestVal){
                highestVal = categories[i].getTotal();
                highest = categories[i];
            }
        }
        return highest;
    }
    /*
     * set Method
     * sets the total spent on a category, for a specific day.
     *
     * Example Use 1:
     * FinanceHandler handler = new FinanceHandler();
     * handler.set(3,1,50.0) - Sets the total spending on Gas for wednesday.
     * */
    public void set(int day, int catIndex, double spent){
        // Increment total by double spent.
        this.categories[catIndex].setTotal(day, spent);
        totals[day] += spent;

        double highest = 0;
        int index = 0;
        for(int i=0;i<totals.length;i++){
            if (totals[i]>highest){
                highest = totals[i];
                index = i;
            }
        }
        this.highestDay = index;
        this.highestTotal = highest;
    }
}
