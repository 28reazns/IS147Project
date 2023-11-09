package testing;

import basic.Category;

public class Testing {
    public static void testCategories(){
        Category cat1 = new Category("Testing1");
        Category cat2 = new Category();

        cat2.setName("Testing2");
        cat1.setTotal(170);
        cat2.setTotal(189.3045);

        System.out.println(cat1.getTotal());
        System.out.println(cat1.getName());
        System.out.println("-".repeat(20));
        System.out.println(cat2.getTotal());
        System.out.println(cat2.getName());
        System.out.println("-".repeat(20));
        System.out.println(cat1);
        System.out.println(cat2);
    }

    public static void main(String[] args){
        testCategories();
    }
}
