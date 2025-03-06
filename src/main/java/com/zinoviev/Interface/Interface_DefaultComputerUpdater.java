package com.zinoviev.Interface;

import com.zinoviev.Entity.Computer;

public class Interface_DefaultComputerUpdater implements Interface_UpdateOperations {

    @Override
    public void updateMotherboard(Computer computer, String motherboard) {
        computer.setMotherboard(motherboard);
    }

    @Override
    public void updateProcessor(Computer computer, String processor) {
        computer.setProcessor(processor);
    }

    @Override
    public void updateVideoCard(Computer computer, String videoCard) {
        computer.setVideoCard(videoCard);
    }

    @Override
    public void updateRam(Computer computer, int ram) {
        computer.setRam(ram);
    }

    @Override
    public void updateSsd(Computer computer, int ssd) {
        computer.setSsd(ssd);
    }

}
