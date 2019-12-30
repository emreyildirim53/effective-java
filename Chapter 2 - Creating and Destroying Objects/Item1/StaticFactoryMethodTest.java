package Item1;
/*
* Item 1: Consider static factory methods instead of constructors
* */

public class StaticFactoryMethodTest
{
    public static void main(String[] args) {

        createdWithConstructor();

        createdWithStaticFactoryMethod();
        
        createdSingletonClassWithStaticFactoryMethod();

    }

    private static void createdWithConstructor()
    {
        Pizza pizza = new Pizza(true);
        System.out.println(pizza);
    }

    private static void createdWithStaticFactoryMethod()
    {
        System.out.println(PizzaFactory.slicedPizza());
        System.out.println(PizzaFactory.unSlicedPizza());
    }

    private static void createdSingletonClassWithStaticFactoryMethod()
    {
        PizzaFactory pizzaFactory = PizzaFactory.getInstance("XL", true, true);
        System.out.println(pizzaFactory);

        pizzaFactory = PizzaFactory.getInstance("M", false, true);
        System.out.println(pizzaFactory);
    }
}

