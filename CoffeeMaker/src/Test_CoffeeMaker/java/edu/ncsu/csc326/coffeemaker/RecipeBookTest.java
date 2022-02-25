package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.*;

/*
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
*/

public class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe recipeTest1;
    private Recipe recipeTest2;
    private Recipe recipeTest3;
    private Recipe recipeTest4;
    private Recipe recipeTest5;

    private Recipe recipeTest1SameName;


    @BeforeEach
    void setUp() throws RecipeException {
        recipeBook = new RecipeBook();
        recipeTest1 = new Recipe();
        recipeTest1.setName("Coffee");
        recipeTest1.setAmtChocolate("0");
        recipeTest1.setAmtCoffee("2");
        recipeTest1.setAmtMilk("0");
        recipeTest1.setAmtSugar("0");
        recipeTest1.setPrice("50");

        recipeTest2 = new Recipe();
        recipeTest2.setName("Cafe Con Leche");
        recipeTest2.setAmtChocolate("0");
        recipeTest2.setAmtCoffee("3");
        recipeTest2.setAmtMilk("0");
        recipeTest2.setAmtSugar("0");
        recipeTest2.setPrice("50");

        recipeTest3 = new Recipe();
        recipeTest3.setName("Cappucino");
        recipeTest3.setAmtChocolate("0");
        recipeTest3.setAmtCoffee("2");
        recipeTest3.setAmtMilk("2");
        recipeTest3.setAmtSugar("0");
        recipeTest3.setPrice("100");

        recipeTest4 = new Recipe();
        recipeTest4.setName("Kaffekask");
        recipeTest4.setAmtChocolate("2");
        recipeTest4.setAmtCoffee("2");
        recipeTest4.setAmtMilk("2");
        recipeTest4.setAmtSugar("2");
        recipeTest4.setPrice("100");

        recipeTest5 = new Recipe();
        recipeTest5.setName("Hot Chocolate");
        recipeTest5.setAmtChocolate("4");
        recipeTest5.setAmtCoffee("0");
        recipeTest5.setAmtMilk("2");
        recipeTest5.setAmtSugar("0");
        recipeTest5.setPrice("80");

        /*Test with same recipe name as recipeTest1*/
        recipeTest1SameName = new Recipe();
        recipeTest1SameName.setName("Coffee");
        recipeTest1SameName.setAmtChocolate("0");
        recipeTest1SameName.setAmtCoffee("2");
        recipeTest1SameName.setAmtMilk("1");
        recipeTest1SameName.setAmtSugar("1");
        recipeTest1SameName.setPrice("40");


    }
    /**
    * #1
    * Test for checking that the recipe gets added to recipe book
    */
    @Test
     public void addRecipeTest(){
        Assertions.assertTrue(recipeBook.addRecipe(recipeTest1));
    }
    /**
     * #2
     * Test for checking that the same recipe does not gets added to recipe book twice
     */
    @Test
    public void addTheSameRecipeTwice(){
        recipeBook.addRecipe(recipeTest1);
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest1));
    }
    /**
     * #3
     * Test for checking that two recipes with the same name cant be added
     */
    @Test
    public void addDifferentRecipesWithTheSameName(){
        recipeBook.addRecipe(recipeTest1);
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest1SameName));
    }
    /**
     * #4
     * Test for checking that two recipes with the same variables but different names cant be added.
     */
    @Test
    public void addDifferentNamedRecipesWithSameValues() throws RecipeException{
        recipeBook.addRecipe(recipeTest1);
        recipeTest1SameName.setName("Different Coffee");
        recipeTest1SameName.setAmtChocolate("0");
        recipeTest1SameName.setAmtCoffee("2");
        recipeTest1SameName.setAmtMilk("0");
        recipeTest1SameName.setAmtSugar("0");
        recipeTest1SameName.setPrice("50");
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest1SameName));
    }
    /**
     * #5
     * Test for if more recipes than the array length of four can be added to the recipe book.
     */
    @Test
    public void addMoreRecipesThanArrayForRecipeBook() {
        recipeBook.addRecipe(recipeTest1);
        recipeBook.addRecipe(recipeTest2);
        recipeBook.addRecipe(recipeTest3);
        recipeBook.addRecipe(recipeTest4);
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest5));
    }
    /**
     * #6
     * Test for checking if a recipe gets denied from being added when all ingredient inputs are zero.
     */
    @Test
    public void addRecipeWithZeroForAllIngredients() throws RecipeException{
            Recipe[] recipes = recipeBook.getRecipes();
            recipeTest1.setAmtChocolate("0");
            recipeTest1.setAmtCoffee("0");
            recipeTest1.setAmtMilk("0");
            recipeTest1.setAmtSugar("0");
            recipeTest1.setPrice("50");
            recipeBook.addRecipe(recipeTest1);
            Assertions.assertNull(recipes[0]);

    }
    /**
     * #7
     * Delete an existing recipe and check that it gets removed from the recipe book.
     */
    @Test
    public void removeRecipe() {
        Recipe[] recipes = recipeBook.getRecipes();
        recipeBook.addRecipe(recipeTest1);
        recipeBook.deleteRecipe(0);
        Assertions.assertEquals(null,recipes[0]);
    }
    /**
     * #8
     * Test for checking if a recipe can be added with 0 dollars as price.
     */
    @Test
    public void zeroDollars() {
        try {
            recipeTest1.setPrice("0");
            Assertions.assertFalse(recipeBook.addRecipe(recipeTest1));
        } catch (RecipeException e) {
            Assertions.fail("Threw RecipeException");
        }
    }
    /**
     * #9
     * Test for retrieving the recipe book.
     */
    @Test
    public void recipeBookArrayRetreived() throws Exception{
        Recipe[] recipes = recipeBook.getRecipes();
        recipeBook.addRecipe(recipeTest1);
        Assertions.assertEquals(recipeTest1, recipes[0]);

    }
}