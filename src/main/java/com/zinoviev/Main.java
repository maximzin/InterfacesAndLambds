package com.zinoviev;

import com.zinoviev.Entity.Computer;
import com.zinoviev.Interface.ComputerUpdaterInterface;
import com.zinoviev.Interface.DefaultComputerUpdaterInterface;
import com.zinoviev.Interface.PartialComputerUpdaterInterface;
import com.zinoviev.StandartWayOOP.ComputerUpdaterStandart;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Наш изначальный компьютер
        Computer computer_1 = new Computer("AMD", "Intel", "AMD", 8, 1000);
        System.out.println(computer_1);

        // Обычная схема по ООП
        ComputerUpdaterStandart computerUpdaterStandart = new ComputerUpdaterStandart();
        computerUpdaterStandart.updateComputer(computer_1);
        System.out.println(computer_1);
        
        // Создали интерфейс UpdateOperations, где описали все операции
        // Далее создали класс DefaultComputerUpdater, который реализует все замены
        // Далее создали класс PartialComputerUpdater, который реализует частичную замену
        // Далее создали класс ComputerUpdater, он здесь и будет вызываться
        // в нём вызываются все операции с деталями
        Computer computer_2 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        ComputerUpdaterInterface computerUpdaterInterface_1 = new ComputerUpdaterInterface();
        DefaultComputerUpdaterInterface defaultComputerUpdaterInterface = new DefaultComputerUpdaterInterface();
        computerUpdaterInterface_1.setUpdateOperation(defaultComputerUpdaterInterface);
        computerUpdaterInterface_1.updateComputer(computer_2);
        System.out.println(computer_2);
        // Заменятся все детали
        // Если присвоим PartialComputerUpdater в DefaultOperations, то детали заменятся частично
        computer_2 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        ComputerUpdaterInterface computerUpdaterInterface_2 = new ComputerUpdaterInterface();
        PartialComputerUpdaterInterface partialComputerUpdaterInterface = new PartialComputerUpdaterInterface();
        computerUpdaterInterface_2.setUpdateOperation(partialComputerUpdaterInterface);
        computerUpdaterInterface_2.updateComputer(computer_2);
        System.out.println(computer_2);





    }
}