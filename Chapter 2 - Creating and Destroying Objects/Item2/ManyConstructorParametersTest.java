package Item2;
/*
 * Item 2: Consider a builder when faced with many constructor parameters
    
 - Requirements
    * Asus
    * Laptop
    * SSD
    * 4GB RAM
    * 15"

 */

public class ManyConstructorParametersTest
{
    public static void main(String[] args)
    {
        telescopingConstructorTest();

        javaBeansConstructorTest();

        builderPatternConstructorTest();
    }

    private static void telescopingConstructorTest()
    {
        Item2.TelescopingConstructor.Computer computer = new Item2.TelescopingConstructor.Computer("ASUS",
                ComputerType.LAPTOP, "", "", "", "", 0f, DiskType.SSD, 0, 4);
    }

    private static void javaBeansConstructorTest()
    {
        Item2.JavaBeans.Computer computer = new Item2.JavaBeans.Computer();
        computer.setBrand("Asus");
        computer.setComputerType(ComputerType.LAPTOP);
        computer.setDiskTypes(DiskType.SSD);
        computer.setCapacityRAM(4);
        computer.setScreenInch(15);
    }

    private static void builderPatternConstructorTest()
    {
        Item2.BuilderPattern.Computer computer =
                new Item2.BuilderPattern.Computer.Builder("Asus", ComputerType.LAPTOP).diskTypes(DiskType.SSD).capacityRAM(4).screenInch(15).build();
    }

}
