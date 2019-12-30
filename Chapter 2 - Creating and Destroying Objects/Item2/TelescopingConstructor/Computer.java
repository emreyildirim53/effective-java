package Item2.TelescopingConstructor;

/*
 * Example of Telescoping Constructor
 */

import Item2.ComputerType;
import Item2.DiskType;
import Item2.KeyboardType;

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
  
    public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard,
                    String brandCPU, String familyCPU, float speedCPU, DiskType diskTypes, int capacityDisk)
    {
        this(brand, computerType, OS, brandMotherboard, brandCPU, familyCPU, speedCPU, diskTypes, capacityDisk, 0,
                0, 0);
    }

    public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard,
                    String brandCPU, String familyCPU, float speedCPU, DiskType diskTypes, int capacityDisk,
                    int capacityRAM){
        this(brand, computerType, OS, brandMotherboard, brandCPU, familyCPU, speedCPU, diskTypes, capacityDisk, capacityRAM,
                0, 0);
    }

    public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard,
                    String brandCPU, String familyCPU, float speedCPU, DiskType diskTypes, int capacityDisk,
                    int capacityRAM, int capacityDisplayCard, int capacityBattery)

    {
        this(brand, computerType, OS, brandMotherboard, brandCPU, familyCPU, speedCPU, diskTypes, capacityDisk,
                capacityRAM, capacityDisplayCard, capacityBattery, 0, null, null);
    }

    public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard,
                    String brandCPU, String familyCPU, float speedCPU, DiskType diskTypes, int capacityDisk,
                    int capacityRAM, int capacityDisplayCard, int capacityBattery, int screenInch, String resolution,
                    KeyboardType keyboardTypes)
    {
        this(brand, computerType, OS, brandMotherboard, brandCPU, familyCPU, speedCPU, diskTypes, capacityDisk,
                capacityRAM, capacityDisplayCard, capacityBattery, screenInch, resolution, keyboardTypes, false,
                false, false, false
                , false);
    }


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

}
