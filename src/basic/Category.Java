package basic;

public class Category {
    // Category Name
    private String name;

    // Category total
    private double total;

    /*
    * Category Method
    * Will create a category named the given string parameter.
    * If no parameter is given, then the category will not have a name.
    *
    * Example Use 1:
    * Category cat1 = new Category("Testing");
    * Example Use 2:
    * Category cat2 = new Category();
    * */
    public Category(String name){
        this.name = name;
        this.total = 0;
    }

    public Category(){
        this.total = 0;
    }

    /*
    * setName Method
    * Will set this category's name to the given string parameter.
    *
    * Example Use 1:
    * Category cat1 = new Category();
    * cat1.setName("Testing");
    * */
    public void setName(String name){
        this.name = name;
    }

    /*
    * setTotal Method
    * Will set this category's total to the given value.
    *
    * Example Use 1:
    * Category cat1 = new Category("Testing");
    * cat1.setTotal(100);
    *
    * Example Use 2:
    * Category cat2 = new Category("Testing");
    * cat2.setTotal(100.0);
    * */
    public void setTotal(double total){
        this.total = total;
    }

    public void setTotal(int total){
        this.total = (double) total;
    }

    /*
    * getTotal Method
    * Will get the category's total
    *
    * Example Use 1:
    * Category cat1 = new Category("Testing");
    * cat1.setTotal(100);
    * cat1.getTotal(); -- Returns 100.0
    * */
    public double getTotal(){
        return this.total;
    }

    /*
     * getName Method
     * Will get the category's  name
     *
     * Example Use 1:
     * Category cat1 = new Category("Testing");
     * cat1.getName(); -- Returns "Testing"
     * */
    public String getName(){
        return this.name;
    }

    /*
    * toString Method
    * Converts category to string
    *
    * Example Use 1:
    * Category cat1 = new Category("Testing");
    * cat1.setTotal(1600);
    * System.out.print(cat1);
    * --------------
    * Will Return:
    * Category: Testing
    * Total: 1600.0
    * */
    @Override public String toString(){
        return "Category: "+this.name+"\n"+"Total: "+this.total;
    }
}
