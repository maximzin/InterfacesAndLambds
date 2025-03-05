package com.zinoviev.StandartWayOOP;

import com.zinoviev.Entity.Computer;

public class ComputerUpdaterStandart {

    public ComputerUpdaterStandart() {
    }

    public void updateComputer(Computer computer) {
        //Изначально метод меняет только мат. плату и видеокарту
        String newMotherboard = "MSI";
        computer.setMotherboard(newMotherboard);

        String newVideoCard = "Nvidia";
        computer.setVideoCard(newVideoCard);

        //Но потом нужно будет добавить новый метод
        int newSsd = 2000;
        computer.setSsd(newSsd);
    }

}
