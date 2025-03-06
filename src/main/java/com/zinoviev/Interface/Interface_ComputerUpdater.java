package com.zinoviev.Interface;

import com.zinoviev.Entity.Computer;

public class Interface_ComputerUpdater {

    private Interface_UpdateOperations interfaceUpdateOperations;

    public void setUpdateOperation(Interface_UpdateOperations interfaceUpdateOperations) {
        this.interfaceUpdateOperations = interfaceUpdateOperations;
    }

    public void updateComputer(Computer computer) {
        interfaceUpdateOperations.updateMotherboard(computer, "AMD");
        interfaceUpdateOperations.updateProcessor(computer, "Ryzen");
        interfaceUpdateOperations.updateVideoCard(computer, "GTX 750");
        interfaceUpdateOperations.updateRam(computer, 5);
        interfaceUpdateOperations.updateSsd(computer, 300);
    }
}
