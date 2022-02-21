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
        r.setAmtChocolate("10");
        r.setAmtCoffee("10");
        r.setAmtMilk("10");
        r.setAmtSugar("10");

    }

    @AfterEach
    void tearDown() {

    }



}