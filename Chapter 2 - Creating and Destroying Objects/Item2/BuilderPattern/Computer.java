package Item2.BuilderPattern;

/*
 * Example of Builder Pattern
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
    
    public static class Builder {
        
        private final String brand;
        private final ComputerType computerType;

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
        public Builder familyCPU(String val)
        {
            familyCPU = val;
            return this;
        }
        public Builder speedCPU(float val)
        {
            speedCPU = val;
            return this;
        }
        public Builder diskTypes(DiskType val)
        {
            diskTypes = val;
            return this;
        }
        public Builder capacityDisk(int val)
        {
            capacityDisk = val;
            return this;
        }
        public Builder capacityRAM(int val)
        {
            capacityRAM = val;
            return this;
        }
        public Builder capacityDisplayCard(int val)
        {
            capacityDisplayCard = val;
            return this;
        }
        public Builder capacityBattery(int val)
        {
            capacityBattery = val;
            return this;
        }
        public Builder screenInch(int val)
        {
            screenInch = val;
            return this;
        }
        public Builder resolution(String val)
        {
            resolution = val;
            return this;
        }
        public Builder typeKeyboard(KeyboardType val)
        {
            typeKeyboard = val;
            return this;
        }
        public Builder hasDiskDriver(boolean val)
        {
            hasDiskDriver = val;
            return this;
        }
        public Builder hasWebcam(boolean val)
        {
            hasWebcam = val;
            return this;
        }
        public Builder hasSpeaker(boolean val)
        {
            hasSpeaker = val;
            return this;
        }
        public Builder hasTrackpad(boolean val)
        {
            hasTrackpad = val;
            return this;
        }
        public Builder hasPrinter(boolean val)
        {
            hasPrinter = val;
            return this;
        }

        public Computer build()
        {
            return new Computer(this);
        }
    }
    public Computer(Builder builder)
    {
        brand = builder.brand;
        computerType = builder.computerType;
        OS = builder.OS;
        brandMotherboard = builder.brandMotherboard;
        brandCPU = builder.brandCPU;
        familyCPU = builder.familyCPU;
        speedCPU = builder.speedCPU;
        diskTypes = builder.diskTypes;
        capacityDisk = builder.capacityDisk;
        capacityRAM = builder.capacityRAM;
        capacityDisplayCard = builder.capacityDisplayCard;
        capacityBattery = builder.capacityBattery;
        screenInch = builder.screenInch;
        resolution = builder.resolution;
        typeKeyboard = builder.typeKeyboard;
        hasDiskDriver = builder.hasDiskDriver;
        hasWebcam = builder.hasWebcam;
        hasSpeaker = builder.hasSpeaker;
        hasTrackpad = builder.hasTrackpad;
        hasPrinter = builder.hasPrinter;
    }
}
