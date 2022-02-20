package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RecipeTest {

    private Recipe recipe;
    private Recipe recipe2;
    private Assertions a;

    @BeforeEach
    void setUp() throws RecipeException {
        recipe = new Recipe();
        recipe.setAmtChocolate("5");
        recipe.setAmtCoffee("10");
        recipe.setAmtMilk("8");
        recipe.setAmtSugar("7");
        recipe.setName("name");
        recipe.setPrice("50");

        recipe2 = new Recipe();
        recipe2.setAmtChocolate("5");
        recipe2.setAmtCoffee("10");
        recipe2.setAmtMilk("8");
        recipe2.setAmtSugar("7");
        recipe2.setName("name");
        recipe2.setPrice("50");
    }




}