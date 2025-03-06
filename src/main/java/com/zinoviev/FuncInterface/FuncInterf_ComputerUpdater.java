package com.zinoviev.FuncInterface;

import com.zinoviev.Entity.Computer;

public class FuncInterf_ComputerUpdater {

    private FuncInterf_MotherboardUpdater funcInterfMotherboardUpdater;

    private FuncInterf_ProcessorUpdater funcInterfProcessorUpdater;

    public void setMotherboardUpdater(FuncInterf_MotherboardUpdater funcInterfMotherboardUpdater) {
        this.funcInterfMotherboardUpdater = funcInterfMotherboardUpdater;
    }

    public void setProcessorUpdater(FuncInterf_ProcessorUpdater funcInterfProcessorUpdater) {
        this.funcInterfProcessorUpdater = funcInterfProcessorUpdater;
    }

    public void update(Computer computer) {
        if (funcInterfMotherboardUpdater != null) {
            funcInterfMotherboardUpdater.updateMotherboard(computer, "MSI");
        }

        if (funcInterfProcessorUpdater != null) {
            funcInterfProcessorUpdater.updateProcessor(computer, "Baikal");
        }
    }
}
