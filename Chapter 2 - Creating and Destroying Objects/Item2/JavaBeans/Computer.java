package Item2.JavaBeans;

/*
 * Example of Java Beans
 */

import Item2.ComputerType;
import Item2.DiskType;
import Item2.KeyboardType;

public class Computer
{
    private String brand                = "";                       
    private ComputerType computerType   = null;
    private String OS                   = "";                      
    private String brandMotherboard     = "";                        
    private String brandCPU             = "";                        
    private String familyCPU            = "";                       
    private float speedCPU              = 0f;                     
    private DiskType diskTypes          = null;                     
    private int capacityDisk            = 0;                       
    private int capacityRAM             = 0;                        
    private int capacityDisplayCard     = 0;                        
    private int capacityBattery         = 0;                        
    private float screenInch            = 0;                       
    private String resolution           = "";                      
    private KeyboardType typeKeyboard   = null;                      
    private boolean hasDiskDriver       = false;                      
    private boolean hasWebcam           = false;                      
    private boolean hasSpeaker          = false;                     
    private boolean hasTrackpad         = false;                        
    private boolean hasPrinter          = false;


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

    public void setBrandMotherboard(String brandMotherboard)
    {
        this.brandMotherboard = brandMotherboard;
    }

    public void setBrandCPU(String brandCPU)
    {
        this.brandCPU = brandCPU;
    }

    public void setFamilyCPU(String familyCPU)
    {
        this.familyCPU = familyCPU;
    }

    public void setSpeedCPU(float speedCPU)
    {
        this.speedCPU = speedCPU;
    }

    public void setDiskTypes(DiskType diskTypes)
    {
        this.diskTypes = diskTypes;
    }

    public void setCapacityDisk(int capacityDisk)
    {
        this.capacityDisk = capacityDisk;
    }

    public void setCapacityRAM(int capacityRAM)
    {
        this.capacityRAM = capacityRAM;
    }

    public void setCapacityDisplayCard(int capacityDisplayCard)
    {
        this.capacityDisplayCard = capacityDisplayCard;
    }

    public void setCapacityBattery(int capacityBattery)
    {
        this.capacityBattery = capacityBattery;
    }

    public void setScreenInch(float screenInch)
    {
        this.screenInch = screenInch;
    }

    public void setResolution(String resolution)
    {
        this.resolution = resolution;
    }

    public void setTypeKeyboard(KeyboardType typeKeyboard)
    {
        this.typeKeyboard = typeKeyboard;
    }

    public void setHasDiskDriver(boolean hasDiskDriver)
    {
        this.hasDiskDriver = hasDiskDriver;
    }

    public void setHasWebcam(boolean hasWebcam)
    {
        this.hasWebcam = hasWebcam;
    }

    public void setHasSpeaker(boolean hasSpeaker)
    {
        this.hasSpeaker = hasSpeaker;
    }

    public void setHasTrackpad(boolean hasTrackpad)
    {
        this.hasTrackpad = hasTrackpad;
    }

    public void setHasPrinter(boolean hasPrinter)
    {
        this.hasPrinter = hasPrinter;
    }
}
