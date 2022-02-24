package Item12;

public class ToString
{
    public static void main(String[] args)
    {
        System.out.println(new DummyObject().toString());
        System.out.println(new PhoneNumber(707, 867, 5309).toString());
        System.out.println(new PhoneNumber(707, 867, 5309));
    }
}
