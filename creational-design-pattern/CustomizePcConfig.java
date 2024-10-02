// Product Class - Represents the complex object being built
class Computer {
    private String CPU;
    private String GPU;
    private String RAM;
    private String storage;
    private String powerSupply;

    // Constructor with all fields
    public Computer(String CPU, String GPU, String RAM, String storage, String powerSupply) {
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.storage = storage;
        this.powerSupply = powerSupply;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                '}';
    }
}

// Builder Interface - Defines the steps to build the product
interface ComputerBuilder {
    ComputerBuilder setCPU(String cpu);
    ComputerBuilder setGPU(String gpu);
    ComputerBuilder setRAM(String ram);
    ComputerBuilder setStorage(String storage);
    ComputerBuilder setPowerSupply(String powerSupply);
    Computer build();
}

// Concrete Builder - Implements the builder interface
class StandardComputerBuilder implements ComputerBuilder {
    private String CPU;
    private String GPU;
    private String RAM;
    private String storage;
    private String powerSupply;

    @Override
    public ComputerBuilder setCPU(String cpu) {
        this.CPU = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setGPU(String gpu) {
        this.GPU = gpu;
        return this;
    }

    @Override
    public ComputerBuilder setRAM(String ram) {
        this.RAM = ram;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(CPU, GPU, RAM, storage, powerSupply);
    }
}

// Director - Constructs an object using the builder interface
class ComputerDirector {
    public Computer constructGamingPC(ComputerBuilder builder) {
        return builder.setCPU("Intel i9")
                      .setGPU("NVIDIA RTX 3080")
                      .setRAM("32GB DDR4")
                      .setStorage("1TB SSD")
                      .setPowerSupply("800W")
                      .build();
    }
}

// Main class to demonstrate the builder pattern
public class CustomizePcConfig {
    public static void main(String[] args) {
        ComputerBuilder builder = new StandardComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        Computer gamingPC = director.constructGamingPC(builder);
        System.out.println(gamingPC);
    }
}
