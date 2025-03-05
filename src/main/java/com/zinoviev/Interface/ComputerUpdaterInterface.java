package com.zinoviev.Interface;

import com.zinoviev.Entity.Computer;

public class ComputerUpdaterInterface {

    private UpdateOperationsInterface updateOperationsInterface;

    public void setUpdateOperation(UpdateOperationsInterface updateOperationsInterface) {
        this.updateOperationsInterface = updateOperationsInterface;
    }

    public void updateComputer(Computer computer) {
        updateOperationsInterface.updateMotherboard(computer, "AMD");
        updateOperationsInterface.updateProcessor(computer, "Ryzen");
        updateOperationsInterface.updateVideoCard(computer, "GTX 750");
        updateOperationsInterface.updateRam(computer, 5);
        updateOperationsInterface.updateSsd(computer, 300);
    }

}
