package chapter1.item1;

class PizzaFactory
{
    private static PizzaFactory pizzaFactoryInstance;

    private String pizzaSize;
    private boolean hasPepperoni;
    private boolean hasCheese;
    
    // singleton object control over the instance with static factory model
    public static PizzaFactory getInstance(String pizzaSize, boolean hasPepperoni, boolean hasCheese)
    {
        PizzaFactory pizzaFactory = new PizzaFactory();

        if (pizzaFactoryInstance != null)
        {
            pizzaFactory = pizzaFactoryInstance;
        }
        else
        {
            pizzaFactory.pizzaSize = pizzaSize;
            pizzaFactory.hasPepperoni = hasPepperoni;
            pizzaFactory.hasCheese = hasCheese;
            pizzaFactoryInstance = pizzaFactory;
        }
        
        return pizzaFactory;
    }

    public static String slicedPizza()
    {
        return "Sliced pizza.";
    }

    public static String unSlicedPizza()
    {
       return "Unsliced pizza.";
    }

    @Override
    public String toString()
    {
        return "PizzaFactory{" +
                "pizzaSize='" + pizzaSize + '\'' +
                ", hasPepperoni=" + hasPepperoni +
                ", hasCheese=" + hasCheese +
                '}';
    }

}
