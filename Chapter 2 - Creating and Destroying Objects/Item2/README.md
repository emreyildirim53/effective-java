
Çok Parametreli Constructor Yönetimi
====================================

Greetings 🙋🏻‍♂️ Any ideas on how to create classes with lots of features? For example, let's consider an object with 10-15 parameters 😱. What would you do? How do you build your class?

Let's think straight logic. I create a constructor to cover each parameter. Like a waterfall, I connect each of them in a layered way. E.g;
```
public class Computer  
{  
    private final String brand;  
    private final ComputerType computerType;  
    private final String OS;  
    private final String brandMotherboard;  
    private final String brandCPU;  
    private final String familyCPU;  
    private final float speedCPU;  
    private final DiskType diskTypes;  
    private final int capacityDisk;  
    private final int capacityRAM;  
    private final int capacityDisplayCard;  
    private final int capacityBattery;  
    private final float screenInch;  
    private final String resolution;  
    private final KeyboardType typeKeyboard;  
    private final boolean hasDiskDriver;  
    private final boolean hasWebcam;  
    private final boolean hasSpeaker;  
    private final boolean hasTrackpad;  
    private final boolean hasPrinter;  
...
```

I have a Computer class and it contains the necessary and unnecessary features. I should be able to create any Computer with these features. This can only be achieved with a constructor that can be created with any parameter. Namely:
```
public Computer(String brand)  
{  
    this(brand, null);  
}
public Computer(String brand, ComputerType computerType)  
{  
    this(brand, computerType, null);  
}
public Computer(String brand, ComputerType computerType, String OS)  
{  
    this(brand, computerType, OS, null);  
}
public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard)  
{  
    this(brand, computerType, OS, brandMotherboard, brand, null, 0);  
}
public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard, 
                String brandCPU, String familyCPU, float speedCPU)  
{  
    this(brand, computerType, OS, brandMotherboard, brandCPU, familyCPU, speedCPU, null, 0);  
}
...  
....  
.....  
......

public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard,  
                String brandCPU, String familyCPU, float speedCPU, DiskType diskTypes, int capacityDisk,  
                int capacityRAM, int capacityDisplayCard, int capacityBattery, float screenInch,  
                String resolution, KeyboardType typeKeyboard, boolean hasDiskDriver, boolean hasWebcam,  
                boolean hasSpeaker, boolean hasTrackpad, boolean hasPrinter)  
{  
    this.brand = brand;  
    this.computerType = computerType;  
    this.OS = OS;  
    this.brandMotherboard = brandMotherboard;  
    this.brandCPU = brandCPU;  
    this.familyCPU = familyCPU;  
    this.speedCPU = speedCPU;  
    this.diskTypes = diskTypes;  
    this.capacityDisk = capacityDisk;  
    this.capacityRAM = capacityRAM;  
    this.capacityDisplayCard = capacityDisplayCard;  
    this.capacityBattery = capacityBattery;  
    this.screenInch = screenInch;  
    this.resolution = resolution;  
    this.typeKeyboard = typeKeyboard;  
    this.hasDiskDriver = hasDiskDriver;  
    this.hasWebcam = hasWebcam;  
    this.hasSpeaker = hasSpeaker;  
    this.hasTrackpad = hasTrackpad;  
    this.hasPrinter = hasPrinter;  
}
```
Although I said _“the constructor that connects to each other in the form of a waterfall”_ above, they compared it to a telescope that can be opened and closed rather than a waterfall in the literature. 🤷🏻 For those who want to research in detail: **Telescoping Constructor**

Let's set ourselves a computer as a target and try to create it.
> **Requirements List**  
> \* Asus  
> \* Laptop  
> \* SSD  
> \* 4GB RAM  
> \* 15"
```
Computer computer = new Computer("ASUS", ComputerType._LAPTOP_, "", "", "", "", 0f, DiskType._SSD_, 0, 4);
```
Did anything bother your eyes? Mine is bleeding. 😁 Which parameter is the brand, which is the RAM capacity, what are the empty or zero values? How hard is it to read? At the same time, I have sent the features that I do not need. If I want to avoid this and insist on telescoping constructor. I need to create constructors that reference the parameters I want. You think of the combination of 20 features, I couldn't think of it. 🤦🏻

This method was the first thing that came to my mind. When I thought a little more, the Java Beans method came to my mind. It's a good idea to try Java Beans. Let's have the same parameters of our computer class, let's create a computer with the feature in my requirements list with Java Beans.
```
public void setBrand(String brand)  
{  
    this.brand = brand;  
}
public void setComputerType(ComputerType computerType)  
{  
    this.computerType = computerType;  
}
public void setOS(String OS)  
{  
    this.OS = OS;  
}
...
```
I will not extend it, in summary, I have written the set method of all parameters. Then I created a class with the features I wanted, and it's here 👇🏼
```
Computer computer = new Computer();  
computer.setBrand("Asus");  
computer.setComputerType(ComputerType._LAPTOP_);  
computer.setDiskTypes(DiskType._SSD_);  
computer.setCapacityRAM(4);  
computer.setScreenInch(15);
```
It looks more organized, readable and clean. (Virgos liked this👍🏼)

So is it safe? What's the availability? I can say that if I compare with the previous one, with this number of parameters (20) I would choose this method. But since this method assigns values ​​in multiple rows, it has management difficulties. Objects created using the JavaBeans method are mutable, so they are not _immutable_. In a large codebase, the value of the object may be set in one of the streams and the object may be changed in another stream. The developer who reads later looks for it and is hard to find. The fact that it is not defined in a single line can cause serious and difficult to find-explain bugs in parallel programming. (ohh memories 🚬).

hmmm… If you say "what will the developers write if both are not good 🤬", calm. There is a cool method **Builder Pattern**, although the processing cost is a little higher than the others.


## The place owner: **Builder Pattern;**
Again, my parameters are the same, and I have an extra class called **Builder**. I define mandatory and optional parameters in this class. These parameters are the same as in my main class, so I have to keep the two sides equal, which is a bit of a hassle👌🏼. This is where the processing cost I'm talking about comes from.
```
public static class Builder {  
      
    private final String brand;                 #required  
    private final ComputerType computerType;    #required  
  
    private String OS                   = "";  
    private String brandMotherboard     = "";  
    private String brandCPU             = "";  
    private String familyCPU            = "";  
    private float speedCPU              = 0f;  
    ...  
      
    public Builder(String brand, ComputerType computerType) { 
        this.brand        = brand;  
        this.computerType = computerType;  
    }  
    public Builder brandMotherboard(String val)  
    {  
        brandMotherboard = val;  
        return this;   
    }  
    public Builder brandCPU(String val)  
    {  
        brandCPU = val;  
        return this;  
    }
    ...  
    ...  
    ... 
    public Computer build()  
    {  
        return new Computer(this);  
    }  
}
```
I am connecting this Builder Class that I have created to my Computer Class.
```
public class Computer   
{  
    private final String brand;  
    private final ComputerType computerType;  
    private final String OS;  
    ... 
    public Computer(Builder builder)  
    {  
        brand = builder.brand;  
        computerType = builder.computerType;  
        OS = builder.OS;  
        brandMotherboard = builder.brandMotherboard;  
        brandCPU = builder.brandCPU;  
        ...  
    }  
}
```
Now I can create my Computer class with builder.
```
Computer computer =new Computer.Builder("Asus", ComputerType._LAPTOP_)
    .diskTypes(DiskType._SSD_)
    .capacityRAM(4)
    .screenInch(15)
    .build();
```
I add the mandatory parameters with the builder constructor and the optional parameters with the setter methods, then build() and I get a readable, organized, clean, one-time generated object with the parameters I want. 🎉

I will tell before I forget. You can much more detail in my blog [mryldrm.com](https:/mryldrm.com/en/posts/how-to-create-a-multi-parameter-class)

Au revoi 🙋🏻‍♂️
