package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InventoryTest {

    private Inventory i;
    private Assertions a;
    private int randNum = -1;
    private Recipe r;


    @BeforeEach
    void setUp() throws RecipeException {
        randNum = 1 + (int) Math.abs(Math.random() * 99); //generate positive integer
        i = new Inventory();

        r = new Recipe();
        r.setAmtChocolate("5");
        r.setAmtCoffee("5");
        r.setAmtMilk("5");
        r.setAmtSugar("5");

        i.setChocolate(10);
        i.setCoffee(10);
        i.setMilk(10);
        i.setSugar(10);

    }

    @AfterEach
    void tearDown() {

    }
    // #1 Check that chocolate is returned correctly
    @Test
    void checkCorrectChocoAmt() {
        Assertions.assertEquals(10, i.getChocolate());
    }

    // #2 Tries to set positive chocolate amount
    @Test
    void trySetPositiveChocoAmt(){
        i.setChocolate(5);
        Assertions.assertEquals(5, i.getChocolate());
    }

    // #3 Tries to add positive chocolate amount
    @Test
    void tryAddPositiveChocoAmt(){
        try{
            i.addChocolate("5");
            Assertions.assertEquals(15, i.getChocolate());
        } catch (InventoryException a){
            Assertions.fail("Threw InventoryException");
        }
    }

    // #4 Tries to set negative chocolate amount
    @Test
    void trySetNegativeChocoAmt(){
        i.setChocolate(-1);
        Assertions.assertEquals(10, i.getChocolate());
    }

    // #5 Tries to add negative chocolate amount
    @Test
    void tryAddNegativeChocoAmt(){
        Assertions.assertThrows(InventoryException.class, () -> i.addChocolate("-1"));
    }

    // #6 Tries to set zero chocolate amount
    @Test
    void trySetZeroChocoAmt(){
        i.setChocolate(0);
        Assertions.assertEquals(0, i.getChocolate());
    }

    // #7 Tries to add zero chocolate amount
    @Test
    void tryAddZeroChocoAmt(){
        try{
            i.addChocolate("0");
            Assertions.assertEquals(10, i.getChocolate());
        } catch (InventoryException a) {
            Assertions.fail("Threw InventoryException");
        }
    }
    //-----------------
    // #8 Check that coffee is returned correctly
    @Test
    void checkCorrectCoffeeAmt() {
        Assertions.assertEquals(10, i.getCoffee());
    }

    // #9 Tries to set positive coffee amount
    @Test
    void trySetPositiveCoffeeAmt(){
        i.setCoffee(5);
        Assertions.assertEquals(5, i.getCoffee());
    }

    // #10 Tries to add positive coffee amount
    @Test
    void tryAddPositiveCoffeeAmt(){
        try{
            i.addCoffee("5");
            Assertions.assertEquals(15, i.getCoffee());
        } catch (InventoryException a){
            Assertions.fail("Threw InventoryException");
        }
    }

    // #11 Tries to set negative coffee amount
    @Test
    void trySetNegativeCoffeeAmt(){
        i.setCoffee(-1);
        Assertions.assertEquals(10, i.getCoffee());
    }

    // #12 Tries to add negative coffee amount
    @Test
    void tryAddNegativeCoffeeAmt(){
        Assertions.assertThrows(InventoryException.class, () -> i.addCoffee("-1"));
    }

    // #13 Tries to set zero coffee amount
    @Test
    void trySetZeroCoffeeAmt(){
        i.setCoffee(0);
        Assertions.assertEquals(0, i.getCoffee());
    }

    // #14 Tries to add zero coffee amount
    @Test
    void tryAddZeroCoffeeAmt(){
        try{
            i.addCoffee("0");
            Assertions.assertEquals(10, i.getCoffee());
        } catch (InventoryException a) {
            Assertions.fail("Threw InventoryException");
        }
    }
    //--------

    // #15 Check that milk is returned correctly
    @Test
    void checkCorrectMilkAmt() {
        Assertions.assertEquals(10, i.getMilk());
    }

    // #16 Tries to set positive milk amount
    @Test
    void trySetPositiveMilkAmt(){
        i.setMilk(5);
        Assertions.assertEquals(5, i.getMilk());
    }

    // #17 Tries to add positive milk amount
    @Test
    void tryAddPositiveMilkAmt(){
        try{
            i.addMilk("5");
            Assertions.assertEquals(15, i.getMilk());
        } catch (InventoryException a){
            Assertions.fail("Threw InventoryException");
        }
    }

    // #18 Tries to set negative milk amount
    @Test
    void trySetNegativeMilkAmt(){
        i.setMilk(-1);
        Assertions.assertEquals(10, i.getMilk());
    }

    // #19 Tries to add negative milk amount
    @Test
    void tryAddNegativeMilkAmt(){
        Assertions.assertThrows(InventoryException.class, () -> i.addMilk("-1"));
    }

    // #20 Tries to set zero milk amount
    @Test
    void trySetZeroMilkAmt(){
        i.setMilk(0);
        Assertions.assertEquals(0, i.getMilk());
    }

    // #21 Tries to add zero milk amount
    @Test
    void tryAddZeroMilkAmt(){
        try{
            i.addMilk("0");
            Assertions.assertEquals(10, i.getMilk());
        } catch (InventoryException a) {
            Assertions.fail("Threw InventoryException");
        }
    }
    //-----------
    // #22 Check that sugar is returned correctly
    @Test
    void checkCorrectSugarAmt() {
        Assertions.assertEquals(10, i.getSugar());
    }

    // #23 Tries to set positive sugar amount
    @Test
    void trySetPositiveSugarAmt(){
        i.setSugar(5);
        Assertions.assertEquals(5, i.getSugar());
    }

    // #24 Tries to add positive sugar amount
    @Test
    void tryAddPositiveSugarAmt(){
        try{
            i.addSugar("5");
            Assertions.assertEquals(15, i.getSugar());
        } catch (InventoryException a){
            Assertions.fail("Threw InventoryException");
        }
    }

    // #25 Tries to set negative sugar amount
    @Test
    void trySetNegativeSugarAmt(){
        i.setSugar(-1);
        Assertions.assertEquals(10, i.getSugar());
    }

    // #26 Tries to add negative sugar amount
    @Test
    void tryAddNegativeSugarAmt(){
        Assertions.assertThrows(InventoryException.class, () -> i.addSugar("-1"));
    }

    // #27 Tries to set zero sugar amount
    @Test
    void trySetZeroSugarAmt(){
        i.setSugar(0);
        Assertions.assertEquals(0, i.getSugar());
    }

    // #28 Tries to add zero sugar amount
    @Test
    void tryAddZeroSugarAmt(){
        try{
            i.addSugar("0");
            Assertions.assertEquals(10, i.getSugar());
        } catch (InventoryException a) {
            Assertions.fail("Threw InventoryException");
        }
    }

    //--------

    // #29 Try to use ingredients with enough in inventory

    @Test
    void tryUseEnoughIngredients () {
        Assertions.assertEquals(true, i.useIngredients(r));

    }

    // #30 Try to use ingredient with not enough in inventory

    @Test
    void tryUseInsufficientIngerdients(){
        i.setChocolate(1);
        i.setMilk(1);
        i.setSugar(1);
        Assertions.assertEquals(false, i.useIngredients(r));
    }

    // #31 Test if there is enough ingredients when there is

    @Test
    void testEnoughIngredients(){
        Assertions.assertEquals(true, i.enoughIngredients(r));
    }

    // #32 Test if there is enough ingredients when there is not

    @Test
    void testInsufficientIngredients(){
        i.setChocolate(4);
        i.setCoffee(4);
        i.setMilk(4);
        i.setSugar(4);
        Assertions.assertEquals(false, i.enoughIngredients(r));
    }

    // #32 Tests toString
    @Test
    void testToString(){
        Assertions.assertEquals("Coffee: 10\n" +
                                        "Milk: 10\n" +
                                        "Sugar: 10\n" +
                                        "Chocolate: 10\n", i.toString());
    }
}