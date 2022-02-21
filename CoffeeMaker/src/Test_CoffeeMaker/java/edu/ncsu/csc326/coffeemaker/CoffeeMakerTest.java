package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMakerTest {

    private RecipeBook rBook;
    private Recipe rTest1;
    private Recipe rTest2;
    private CoffeeMaker coffeeMaker;
    private Inventory inventory;
    // Initialization method
    @BeforeEach
    void setUp() throws RecipeException {
        inventory = new Inventory();
        coffeeMaker = new CoffeeMaker();
        rBook = new RecipeBook();
        rTest1 = new Recipe();

        rTest1.setName("Coffee");
        rTest1.setAmtChocolate("0");
        rTest1.setAmtCoffee("2");
        rTest1.setAmtMilk("1");
        rTest1.setAmtSugar("0");
        rTest1.setPrice("40");

        rTest2 = new Recipe();
        rTest2.setName("Mocha");
        rTest2.setAmtChocolate("2");
        rTest2.setAmtCoffee("2");
        rTest2.setAmtMilk("1");
        rTest2.setAmtSugar("2");
        rTest2.setPrice("60");
    }
    @Test
    void testGetRecipes(){
        coffeeMaker.addRecipe(rTest1);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = rTest1;
        Assertions.assertArrayEquals(recipes ,coffeeMaker.getRecipes());
    }
   
}
