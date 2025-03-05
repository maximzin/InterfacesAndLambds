package com.zinoviev.Entity;

// Сущность компьютера, который будем чинить
public class Computer {

    private String motherboard;

    private String processor;

    private String videoCard;

    private int ram;

    private int ssd;

    public Computer(String motherboard, String processor, String videoCard, int ram, int ssd) {
        this.motherboard = motherboard;
        this.processor = processor;
        this.videoCard = videoCard;
        this.ram = ram;
        this.ssd = ssd;
    }

    @Override
    public String toString() {
        return "Мат. плата: " + motherboard + "\n" + "Процессор: " + processor + "\n" + "Видеокарта: " + videoCard + "\n" + "Опер. память: " + ram + " гб" + "\n" + "ССД: " + ssd + " гб" + "\n";
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }
}
