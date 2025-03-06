package com.zinoviev.FuncInterface;

import com.zinoviev.Entity.Computer;

@FunctionalInterface
public interface FuncInterf_MotherboardUpdater {
    void updateMotherboard(Computer computer, String motherboard);
}

