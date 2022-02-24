package edu.ncsu.csc326.coffeemaker;
 // Main imports
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class coffeeMakerTest {

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

        // Dummy Samples
        rTest1.setName("Cappuccino");
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
    //  #1 Receive Recipes Functionality
    @Test
    void checkFetchingTheRecipes(){
        coffeeMaker.addRecipe(rTest1);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = rTest1;
        Assertions.assertArrayEquals(recipes ,coffeeMaker.getRecipes());
    }
    // #2 Check Inventory Outcome Functionality
    @Test
    void checkingInventoryResult(){
        // Testing Normal input
        inventory.setMilk(25);
        inventory.setCoffee(25);
        inventory.setChocolate(25);
        inventory.setSugar(25);
        Assertions.assertEquals("Coffee: 25\n" +
                "Milk: 25\n" +
                "Sugar: 25\n" +
                "Chocolate: 25\n" , coffeeMaker.checkInventory());
    }
    // #3 Testing delete with null item
    @Test
    void checkDeletingRecipeThatIsNull(){
        Assertions.assertNull(coffeeMaker.deleteRecipe(3));
    }
    // #4 Testing to check added Recipe
    @Test
    void checkAddedRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        Assertions.assertTrue(coffeeMaker.addRecipe(rTest1));
        Recipe recipeTest = recipes[0];
        Assertions.assertEquals(rTest1, recipeTest);
        Assertions.assertFalse(coffeeMaker.addRecipe(rTest1));
    }
    // #5 checking the default delete recipe
    @Test
    void checkDeletingRecipe(){
        coffeeMaker.addRecipe(rTest1);
        coffeeMaker.deleteRecipe(0);
        Assertions.assertNotSame(rTest1, coffeeMaker.getRecipes()[0]);
        Assertions.assertNull(coffeeMaker.getRecipes()[0]);
    }
    // #6 Test to check Edit of Recipe Content
    @Test
    void checkEditingRecipeContent() throws RecipeException {

        coffeeMaker.addRecipe(rTest1);
        Recipe rTest3 = new Recipe();
        rTest3.setName("HotChocolate");
        rTest3.setAmtChocolate("3");
        rTest3.setAmtCoffee("0");
        rTest3.setAmtMilk("2");
        rTest3.setAmtSugar("3");
        rTest3.setPrice("55");
        coffeeMaker.editRecipe(0, rTest2);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = rTest3;
        Assertions.assertArrayEquals(recipes, coffeeMaker.getRecipes());
        Assertions.assertSame(rTest3, coffeeMaker.getRecipes()[0]);
    }
    // #7 Testing edit with null address location
    @Test
    void checkEditingRecipeWithNull() {
        Assertions.assertNull(coffeeMaker.editRecipe(0, rTest2));
    }

    // #8 Test to check Inventory input not null ,since it has existing input.
    @Test
    void checkingInventoryInputNotNull(){
        Assertions.assertNotNull(coffeeMaker.checkInventory());
    }
    // #9 Test to check if Inventory is working with adding with input , problem with 2 variables :(
    @Test
    void checkAddingValidInputToInventory(){
        try {
            coffeeMaker.addInventory("15", "15", "15", "15");
            Assertions.assertEquals("Coffee: 30\n" +
                    "Milk: 30\n" +
                    "Sugar: 30\n" +
                    "Chocolate: 30\n", coffeeMaker.checkInventory());
        }
        catch (InventoryException e){
            e.getMessage();
            Assertions.fail("Inserting valid inventory inputs , yet made it throw an exception");
        }
    }
    // #10 Test to check how Inventory handle invalid input , fails does not throw exception
    @Test
    void checkAddingInvalidInputToInventory(){
        Assertions.assertThrows(InventoryException.class, () ->
                coffeeMaker.addInventory("-5","3",null,"4"));
        Assertions.assertThrows(InventoryException.class, () ->
                coffeeMaker.addInventory("-5","-6","9","2"));
        Assertions.assertThrows(InventoryException.class, () ->
                coffeeMaker.addInventory("5","8","-1","1"));
        Assertions.assertThrows(InventoryException.class, () ->
                coffeeMaker.addInventory( null,"5","9","-3"));
    }
    // #11 Test to check how Inventory handle 0s as input
    @Test
    void checkAddingZerosInventory() {
        try {
            coffeeMaker.addInventory("0", "0", "0", "0");
        }
        catch (InventoryException e){
            e.printStackTrace();
            Assertions.fail();
        }
        Assertions.assertEquals("Coffee: 15\n" +
                "Milk: 15\n" +
                "Sugar: 15\n" +
                "Chocolate: 15\n", coffeeMaker.checkInventory());
    }
    // #12 Test Making Coffee process
    @Test
    void checkMakingCoffee() throws RecipeException {
        rTest1.setPrice("40");
        coffeeMaker.addRecipe(rTest1);
        int change = coffeeMaker.makeCoffee(0,60);
        Assertions.assertEquals(20, change);
    }
    // #13 Test to check how Making Coffee handles no recipe while purchasing ( empty )
    @Test
    void checkMakingCoffeeWithNoRecipe(){
        rBook.getRecipes()[0] = null;
        int change = coffeeMaker.makeCoffee(0,50);
        Assertions.assertEquals(50, change);
    }
    // #14 Test how Making Coffee handles Invalid Price Input
    @Test
    void checkMakingCoffeeWithInvalidPrice() throws RecipeException {
        rTest1.setPrice("50");
        coffeeMaker.addRecipe(rTest1);
        int change = coffeeMaker.makeCoffee(0,-10);
        Assertions.assertEquals(0, change);
    }
    // #15 Test how Making Coffee handles Smaller Price Input
    @Test
    void checkMakingCoffeeWithLowerPrice() throws RecipeException{
        rTest1.setPrice("50");
        coffeeMaker.addRecipe(rTest1);
        int change = coffeeMaker.makeCoffee(0,20);
        Assertions.assertEquals(20, change);

    }
    // #16 Test how Making Coffee handles Empty Inventory
    @Test
    void checkMakingCoffeeWithNoInventory() throws RecipeException{
        rTest1.setPrice("60");
        coffeeMaker.addRecipe(rTest1);
        inventory.setSugar(0);
        inventory.setCoffee(0);
        inventory.setChocolate(0);
        inventory.setMilk(0);
        int change = coffeeMaker.makeCoffee(0,70);
        Assertions.assertEquals(70, change);

    }
}
