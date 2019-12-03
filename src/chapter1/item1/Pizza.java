package chapter1.item1;

public class Pizza
{
    private boolean sliced;

    public Pizza(boolean sliced)
    {
        this.sliced = sliced;
    }

    @Override
    public String toString()
    {
        return "Pizza{sliced=" + sliced +'}';
    }
}
