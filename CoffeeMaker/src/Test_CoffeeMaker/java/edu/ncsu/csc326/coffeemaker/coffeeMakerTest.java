package edu.ncsu.csc326.coffeemaker;

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
    @Test
    void testDeleteRecipe(){
        coffeeMaker.addRecipe(rTest1);
        coffeeMaker.deleteRecipe(0);
        Assertions.assertNotSame(rTest1, coffeeMaker.getRecipes()[0]);
        Assertions.assertNull(coffeeMaker.getRecipes()[0]);
    }
    @Test
    void testDeleteRecipeThatIsNull(){
        Assertions.assertNull(coffeeMaker.deleteRecipe(3));
    }
    @Test
    void testAddRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        Assertions.assertTrue(coffeeMaker.addRecipe(rTest1));
        Recipe recipeTest = recipes[0];
        Assertions.assertEquals(rTest1, recipeTest);
        Assertions.assertFalse(coffeeMaker.addRecipe(rTest1));
    }
    @Test
    void testAddRecipeAddingTheSameRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        coffeeMaker.addRecipe(rTest1);
        Assertions.assertFalse(coffeeMaker.addRecipe(rTest1));
    }
    @Test
    void testEditRecipe() throws RecipeException {

        coffeeMaker.addRecipe(rTest1);
        Recipe testRecipe = new Recipe();
        testRecipe.setName("Tea");
        testRecipe.setAmtChocolate("0");
        testRecipe.setAmtCoffee("3");
        testRecipe.setAmtMilk("1");
        testRecipe.setAmtSugar("1");
        testRecipe.setPrice("50");
        coffeeMaker.editRecipe(0, rTest2);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = testRecipe;
        Assertions.assertArrayEquals(recipes, coffeeMaker.getRecipes());
        Assertions.assertSame(testRecipe, coffeeMaker.getRecipes()[0]);
    }
    @Test
    void testEditRecipeAtNullPosition() {
        Assertions.assertNull(coffeeMaker.editRecipe(0, rTest2));
    }
    @Test
    void testCheckInventory(){
        inventory.setMilk(10);
        inventory.setChocolate(10);
        inventory.setCoffee(10);
        inventory.setSugar(10);
        Assertions.assertEquals("Coffee: 10\n" +
                "Milk: 10\n" +
                "Sugar: 10\n" +
                "Chocolate: 10\n" , coffeeMaker.checkInventory());
    }
    @Test
    void testCheckInventoryNotNull(){
        Assertions.assertNotNull(coffeeMaker.checkInventory());
    }
    @Test
    void testAddInventory(){
        try {
            coffeeMaker.addInventory("20", "20", "20", "20");
            Assertions.assertEquals("Coffee: 35\n" +
                    "Milk: 35\n" +
                    "Sugar: 35\n" +
                    "Chocolate: 35\n", coffeeMaker.checkInventory());
        }
        catch (InventoryException e){
            e.getMessage();
            Assertions.fail("Adding valid inventory resulted in an exception being thrown.");
        }
    }
    @Test
    void testAddInventoryWithInvalidData(){
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("a","","test",null));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("","a",null,"test"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("test",null,"a",""));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( null,"test","","a"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-3","-6","-4","-4"));

        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-2","10","10","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("10","-2","10","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("10","10","-2","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( "10","10","10","-2"));
    }
    @Test
    void testAddInventoryWithZero() {
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
    @Test
    void testMakeCoffee() throws RecipeException {
        rTest1.setPrice("4");
        coffeeMaker.addRecipe(rTest1);
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(50, testChange);
    }

    @Test
    void testMakeCoffeeNoRecipe(){
        rBook.getRecipes()[0] = null;
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(100, testChange);
        rBook.getRecipes()[0] = new Recipe();
        testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(100, testChange);
    }
    @Test
    void testMakeCoffeeInvalidRecipeInput(){
        int testChange = coffeeMaker.makeCoffee(coffeeMaker.getRecipes().length +1,100);
        Assertions.assertEquals(100, testChange);
    }

    @Test
    void testMakeCoffeeInvalidPriceInput() throws RecipeException {
        rTest1.setPrice("40);
                coffeeMaker.addRecipe(rTest1);
        int testChange = coffeeMaker.makeCoffee(0,-3);
        Assertions.assertEquals(0, testChange);
    }
    @Test
    void testMakeCoffeeInvalidSmallerPriceInput() throws RecipeException{
        rTest1.setPrice("40);
                coffeeMaker.addRecipe(rTest1);
        int testChange = coffeeMaker.makeCoffee(0,10);
        Assertions.assertEquals(10, testChange);

    }

    @Test
    void testMakeCoffeeNoInventory() throws RecipeException{
        rTest1.setPrice("4");
        coffeeMaker.addRecipe(rTest1);
        inventory.setSugar(0);
        inventory.setCoffee(0);
        inventory.setChocolate(0);
        inventory.setMilk(0);
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(100, testChange);

    }
}