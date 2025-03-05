package com.zinoviev.Interface;

import com.zinoviev.Entity.Computer;

public class PartialComputerUpdaterInterface implements UpdateOperationsInterface {

    @Override
    public void updateMotherboard(Computer computer, String motherboard) {
        computer.setMotherboard(motherboard);
    }

    @Override
    public void updateProcessor(Computer computer, String processor) {
        return;
    }

    @Override
    public void updateVideoCard(Computer computer, String videoCard) {
        return;
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
