package Item1;
/*
* Item 1: Consider static factory methods instead of constructors

* */

import java.util.logging.Logger;

public class StaticFactoryMethodTest
{
    private static final Logger logger = Logger.getLogger(StaticFactoryMethodTest.class.getName());

    public static void main(String[] args) {

        createdWithConstructor();

        createdWithStaticFactoryMethod();
        
        createdSingletonClassWithStaticFactoryMethod();

    }

    private static void createdWithConstructor()
    {
        Pizza pizza = new Pizza(true);
        logger.info(pizza.toString());
    }

    private static void createdWithStaticFactoryMethod()
    {
        logger.info(PizzaFactory.slicedPizza().toString());
        logger.info(PizzaFactory.unSlicedPizza().toString());
    }

    private static void createdSingletonClassWithStaticFactoryMethod()
    {
        PizzaFactory pizzaFactory = PizzaFactory.getInstance("XL", true, true);
        logger.info(pizzaFactory.toString());

        pizzaFactory = PizzaFactory.getInstance("M", false, true);
        logger.info(pizzaFactory.toString());
    }
}

