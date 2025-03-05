package com.zinoviev.Interface;

import com.zinoviev.Entity.Computer;

public interface UpdateOperationsInterface {

    void updateMotherboard(Computer computer, String motherboard);

    void updateProcessor(Computer computer, String processor);

    void updateVideoCard(Computer computer, String videoCard);

    void updateRam(Computer computer, int ram);

    void updateSsd(Computer computer, int ssd);

}
