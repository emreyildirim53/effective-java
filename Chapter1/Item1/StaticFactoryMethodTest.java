package Item1;

public class StaticFactoryMethodTest
{
    public static void main(String[] args) {
        Pizza pizza = new Pizza(true);

        System.out.println(PizzaFactory.slicedPizza());
        System.out.println(PizzaFactory.unSlicedPizza());

        PizzaFactory pizzaFactory = PizzaFactory.getInstance("XL", true, true);
        System.out.println(pizzaFactory);

        pizzaFactory = PizzaFactory.getInstance("M", false, true);
        System.out.println(pizzaFactory);
    }
}

