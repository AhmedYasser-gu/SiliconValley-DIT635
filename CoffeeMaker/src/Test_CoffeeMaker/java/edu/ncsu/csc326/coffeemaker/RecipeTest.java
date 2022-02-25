package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    private Recipe r;
    private Recipe r2;
    private Assertions a;

    @BeforeEach
    void setUp() throws RecipeException {
        r = new Recipe();
        r.setAmtChocolate("5");
        r.setAmtCoffee("10");
        r.setAmtMilk("8");
        r.setAmtSugar("7");
        r.setName("name");
        r.setPrice("50");
    }

    /**
     * #1
     * Test to check if the correct chocolate amount was set
     */
    @Test
    public void checkCorrectChocolateAmt() {
        Assertions.assertEquals(5, r.getAmtChocolate());
    }

    /**
     * #2
     * Test to check if setting the chocolate amount works
     */
    @Test
    public void trySetChocolate() {
        try {
            r.setAmtChocolate("2");
            Assertions.assertEquals(2, r.getAmtChocolate());
        } catch (RecipeException e) {
            Assertions.fail("Threw RecipeException");
        }
    }

    /**
     * #3
     * Test that tries to set chocolate to a negative number
     */
    @Test
    public void testNegativeChocolate() {
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtChocolate("-2"));
    }

    /**
     * #4
     * Test that checks what happens when an empty string is provided when setting amount of chocolate
     */
    @Test
    public void testEmptyChocolate(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtChocolate(""));
    }

    /**
     * #5
     * Test for when letters are entered instead of numbers
     */
    @Test
    public void testLettersChocolate(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtChocolate("dasd"));
    }

    /**
     * #6
     * Test to check if the correct coffee amount was set
     */
    @Test
    public void checkCorrectCoffeeAmt() {
        Assertions.assertEquals(10, r.getAmtCoffee());
    }

    /**
     * #7
     * Test to check if setting the coffee amount works
     */
    @Test
    public void trySetCoffee() {
        try {
            r.setAmtCoffee("2");
            Assertions.assertEquals(2, r.getAmtCoffee());
        } catch (RecipeException e) {
            Assertions.fail("Threw RecipeException");
        }
    }

    /**
     * #8
     * Test that tries to set coffee to a negative number
     */
    @Test
    public void testNegativeCoffee() {
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtCoffee("-2"));
    }

    /**
     * #9
     * Test that checks what happens when an empty string is provided when setting amount of coffee
     */
    @Test
    public void testEmptyCoffee(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtCoffee(""));
    }

    /**
     * #10
     * Test for when letters are entered instead of numbers
     */
    @Test
    public void testLettersCoffee(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtCoffee("dasd"));
    }

    /**
     * #11
     * Test to check if the correct milk amount was set
     */
    @Test
    public void checkCorrectMilkAmt() {
        Assertions.assertEquals(8, r.getAmtMilk());
    }

    /**
     * #12
     * Test to check if setting the milk amount works
     */
    @Test
    public void trySetMilk() {
        try {
            r.setAmtMilk("2");
            Assertions.assertEquals(2, r.getAmtMilk());
        } catch (RecipeException e) {
            Assertions.fail("Threw RecipeException");
        }
    }

    /**
     * #13
     * Test that tries to set milk to a negative number
     */
    @Test
    public void testNegativeMilk() {
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtMilk("-2"));
    }

    /**
     * #14
     * Test that checks what happens when an empty string is provided when setting amount of milk
     */
    @Test
    public void testEmptyMilk(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtMilk(""));
    }

    /**
     * #15
     * Test for when letters are entered instead of numbers
     */
    @Test
    public void testLettersMilk(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtMilk("dasd"));
    }

    /**
     * #16
     * Test to check if the correct sugar amount was set
     */
    @Test
    public void checkCorrectSugarAmt() {
        Assertions.assertEquals(7, r.getAmtSugar());
    }

    /**
     * #17
     * Test to check if setting the sugar amount works
     */
    @Test
    public void trySetSugar() {
        try {
            r.setAmtSugar("2");
            Assertions.assertEquals(2, r.getAmtSugar());
        } catch (RecipeException e) {
            Assertions.fail("Threw RecipeException");
        }
    }

    /**
     * #18
     * Test that tries to set sugar to a negative number
     */
    @Test
    public void testNegativeSugar() {
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtSugar("-2"));
    }

    /**
     * #19
     * Test that checks what happens when an empty string is provided when setting amount of sugar
     */
    @Test
    public void testEmptySugar(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtSugar(""));
    }

    /**
     * #20
     * Test for when letters are entered instead of numbers
     */
    @Test
    public void testLettersSugar(){
        Assertions.assertThrows(RecipeException.class, () -> r.setAmtSugar("dasd"));
    }

    /**
     * #21
     * Test to check if the correct name was set
     */
    @Test
    public void checkCorrectName() {
        Assertions.assertEquals("name", r.getName());
    }

    /**
     * #22
     * Test to check if setting an empty name works
     */
    @Test
    public void testEmptyName() {
        r.setName("");
        Assertions.assertThrows(RecipeException.class, () -> r.setName(""));
    }

    /**
     * #23
     * Test to check if setting the name works
     */
    @Test
    public void trySetName() {
        r.setName("test");
        Assertions.assertEquals("test", r.getName());
    }

    /**
     * #24
     * Test that checks what happens when an empty string is provided when setting the name
     */
    @Test
    public void testNullName(){
        r.setName(null);
        Assertions.assertNotNull(r.getName());
    }

    /**
     * #25
     * Test to check if the correct price amount was set
     */
    @Test
    public void checkCorrectPriceAmt() {
        Assertions.assertEquals(50, r.getPrice());
    }

    /**
     * #26
     * Test to check if setting the price amount works
     */
    @Test
    public void trySetPrice() {
        try {
            r.setPrice("2");
            Assertions.assertEquals(2, r.getPrice());
        } catch (RecipeException e) {
            Assertions.fail("Threw RecipeException");
        }
    }

    /**
     * #27
     * Test that tries to set price to a negative number
     */
    @Test
    public void testNegativePrice() {
        Assertions.assertThrows(RecipeException.class, () -> r.setPrice("-2"));
    }

    /**
     * #28
     * Test that checks what happens when an empty string is provided when setting amount of price
     */
    @Test
    public void testEmptyPrice(){
        Assertions.assertThrows(RecipeException.class, () -> r.setPrice(""));
    }

    /**
     * #29
     * Test for when letters are entered instead of numbers
     */
    @Test
    public void testLettersPrice(){
        Assertions.assertThrows(RecipeException.class, () -> r.setPrice("dasd"));
    }

    /**
     * #30
     * Test for when setting price to null
     */
    @Test
    public void testNullPrice(){
        Assertions.assertThrows(RecipeException.class, () -> r.setPrice(null));
    }

}