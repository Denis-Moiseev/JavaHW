package JavaHW;

public class Laptop {
    private String model;
    private int amountOfRAM;
    private int memory;
    private String OS;
    private String color;

    public Laptop(String model, int amountOfRAM, int memory, String OS, String color) {
        this.model = model;
        this.amountOfRAM = amountOfRAM;
        this.memory = memory;
        this.OS = OS;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getAmountOfRAM() {
        return amountOfRAM;
    }

    public int getMemory() {
        return memory;
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Модель: " + model +
                ", Объем ОЗУ: " + amountOfRAM +
                ", Объем встроенной памяти: " + memory +
                ", Операционная система: " + OS +
                ", Цвет: " + color;
    }
}