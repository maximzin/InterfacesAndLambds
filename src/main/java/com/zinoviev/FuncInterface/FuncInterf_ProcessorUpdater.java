package com.zinoviev.FuncInterface;

import com.zinoviev.Entity.Computer;

@FunctionalInterface
public interface FuncInterf_ProcessorUpdater {
    void updateProcessor(Computer computer, String processor);
}
