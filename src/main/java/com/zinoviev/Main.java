package com.zinoviev;

import com.zinoviev.Entity.Computer;
import com.zinoviev.FuncInterface.FuncInterf_ComputerUpdater;
import com.zinoviev.FuncInterface.FuncInterf_MotherboardUpdater;
import com.zinoviev.FuncInterface.FuncInterf_ProcessorUpdater;
import com.zinoviev.Interface.Interface_ComputerUpdater;
import com.zinoviev.Interface.Interface_DefaultComputerUpdater;
import com.zinoviev.Interface.Interface_PartialComputerUpdater;
import com.zinoviev.Interface.Interface_UpdateOperations;
import com.zinoviev.StandartWayOOP.ComputerUpdaterStandart;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Наш изначальный компьютер
        Computer computer_1 = new Computer("AMD", "Intel", "AMD", 8, 1000);
        //System.out.println(computer_1);

        // Обычная схема по ООП
        ComputerUpdaterStandart computerUpdaterStandart = new ComputerUpdaterStandart();
        computerUpdaterStandart.updateComputer(computer_1);
        //System.out.println(computer_1);

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Сейчас будут всратые названия, но надо как-то придать отличия разным секторам
        // Создали интерфейс Interface_UpdateOperations, где описали все операции
        // Далее создали класс Interface_DefaultComputerUpdater, который реализует все замены
        // Далее создали класс Interface_PartialComputerUpdater, который реализует частичную замену
        // Далее создали класс Interface_ComputerUpdater, он здесь и будет вызываться
        // в нём вызываются все операции с деталями
        Computer computer_2 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        Interface_ComputerUpdater interface_ComputerUpdater_1 = new Interface_ComputerUpdater();
        Interface_DefaultComputerUpdater interface_DefaultComputerUpdater = new Interface_DefaultComputerUpdater();
        interface_ComputerUpdater_1.setUpdateOperation(interface_DefaultComputerUpdater);
        interface_ComputerUpdater_1.updateComputer(computer_2);
        //System.out.println(computer_2);
        // Заменятся все детали
        // Если присвоим Interface_PartialComputerUpdater в Interface_UpdateOperations, то детали заменятся частично
        computer_2 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        Interface_ComputerUpdater interface_ComputerUpdater_2 = new Interface_ComputerUpdater();
        Interface_PartialComputerUpdater interface_PartialComputerUpdater = new Interface_PartialComputerUpdater();
        interface_ComputerUpdater_2.setUpdateOperation(interface_PartialComputerUpdater);
        interface_ComputerUpdater_2.updateComputer(computer_2);
        //System.out.println(computer_2);
        // Тем самым код стал более гибким, мы можем создавать новую реализацию интерфейса Interface_UpdateOperations
        // Но код будет всегда будет выполняться по сценарию Interface_ComputerUpdater

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Теперь допустим, что нас попросили временно изменить логику (на лету)
        // Нужно менять только материнку
        // для этого поработаем с анонимными классами
        Computer computer_3 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        Interface_ComputerUpdater interface_ComputerUpdater_3 = new Interface_ComputerUpdater();

        // Анонимный класс
        Interface_UpdateOperations customUpdateOperations = new Interface_UpdateOperations() {

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
                return;
            }

            @Override
            public void updateSsd(Computer computer, int ssd) {
                return;
            }
        };

        interface_ComputerUpdater_3.setUpdateOperation(customUpdateOperations);
        interface_ComputerUpdater_3.updateComputer(computer_3);

        //System.out.println(computer_3);
        // Соответственно тут же переопределили функционал
        // и "местячково" выполнини нужный функционал

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Настало время более гибкой конфигурации
        // А именно функциональный интерфейс
        // Его основное отличие от обычного - содержит только
        // один абстрактный метод
        // хотя могут присутствовать static и default методы
        // Создали функциональные интерфейсы в папке FuncInterface
        // Переписали класс ComputerUpdater, теперь мы можем прямо здесь
        // переопределять поведение каждого метода:

        Computer computer_4 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        System.out.println(computer_4);

        FuncInterf_ComputerUpdater funcInterf_computerUpdater = new FuncInterf_ComputerUpdater();
        funcInterf_computerUpdater.setMotherboardUpdater(new FuncInterf_MotherboardUpdater() {
            @Override
            public void updateMotherboard(Computer computer, String motherboard) {
                System.out.println("Куплена материнская плата");
                computer.setMotherboard(motherboard);
            }
        });

        // Мы присвоили только один интерфейс, соответственно будет поменяна только материнка
        funcInterf_computerUpdater.update(computer_4);
        System.out.println(computer_4);

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////











    }
}