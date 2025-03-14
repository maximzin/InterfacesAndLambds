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

import java.awt.datatransfer.StringSelection;
import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Обычная схема по ООП
        // Наш изначальный компьютер
        Computer computer_1 = new Computer("AMD", "Intel", "AMD", 8, 1000);
        //System.out.println(computer_1);

        ComputerUpdaterStandart computerUpdaterStandart = new ComputerUpdaterStandart();
        computerUpdaterStandart.updateComputer(computer_1);
        //System.out.println(computer_1);

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Сделаем код более гибким, реализовав методы через интерфейсы
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

        // Сделаем то же через анонимный класс
        // Допустим, что нас попросили временно изменить логику (на лету)
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
        // Их прикол в том, что они содержат ТОЛЬКО ОДИН абстрактный метод (хотя могут лежать default + static методы)
        // Соответственно они сразу указывают на то, что они могут переопределяться
        // пользователем через лямбда выражения (они будут далее)
        // Переписали класс ComputerUpdater, теперь мы можем прямо здесь
        // переопределять поведение каждого метода:

        Computer computer_4 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        //System.out.println(computer_4);

        FuncInterf_ComputerUpdater funcInterf_computerUpdater = new FuncInterf_ComputerUpdater();
        funcInterf_computerUpdater.setMotherboardUpdater(new FuncInterf_MotherboardUpdater() {
            @Override
            public void updateMotherboard(Computer computer, String motherboard) {
                //System.out.println("Куплена материнская плата");
                computer.setMotherboard(motherboard);
            }
        });

        // Мы присвоили только один интерфейс, соответственно будет поменяна только материнка
        funcInterf_computerUpdater.update(computer_4);
        //System.out.println(computer_4);

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Настало время ЛЯМБДА выражений
        Computer computer_5 = new Computer("INTEL", "Intel", "4060", 8, 1000);
        //System.out.println(computer_5.toString());

        FuncInterf_ComputerUpdater funcInterf_computerUpdaterLambda = new FuncInterf_ComputerUpdater();
        // Переопределим какой-нибудь метод в интерфейса
        // Например поменяем логику замены процессора
        funcInterf_computerUpdaterLambda.setProcessorUpdater((computer, processor) -> {
            //System.out.println("Наносим дополнительно термопасту");
            computer.setProcessor(processor);
        });

        funcInterf_computerUpdaterLambda.update(computer_5);
        //System.out.println(computer_5);

        // Важно помнить, что при таком переопределении методом
        // они не выполняются сразу, мы просто задаем их поведение
        // вызываться они будут В НАШЕМ СЛУЧАЕ только через метод update(computer)

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Важное уточнение по лямбдам
        // 1)
        // такой пример:
        String newMotherboard = "Intel";
        funcInterf_computerUpdaterLambda.setMotherboardUpdater((computer, motherboard1) -> {
            computer.setMotherboard(newMotherboard);
        });
        // Если после объявления лямбды мы изменяем переменную newMotherboard,
        // то получаем ошибку, так как такие переменные должны быть либо final,
        // либо effectively final (не изменяются после объявления)

        // 2)
        // У лямбд нет состояния
        // то есть хранить переменную типа count++ НЕЛЬЗЯ

        // 3)
        // Лямбды не могут бросать проверяемые исключения, нужно оборачивать
        // например
        funcInterf_computerUpdaterLambda.setProcessorUpdater((computer, processor) -> {
            try {
                System.out.println("Обрабатываем на ошибки");
                computer.setProcessor(processor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Системные функциональные интерфейсы
        // Function<T, R> - принимаем тип T, возвращаем тип R
        Function<String, String> subMyString = s -> s.substring(4);
        //System.out.println(subMyString.apply("Hello, my name is Max!"));

        // Predicate<T> - принимает аргумент типа Т и проверяет на true/false
        Predicate<String> checkMyString = s -> s.isEmpty();
        //System.out.println(checkMyString.test(""));

        // Consumer<T> - принимает аргумент Т и не отдает ничего
        Consumer<String> printMyString = s -> System.out.println(s);
        //printMyString.accept("hey!");

        // Supplier<T> - не принимает аргументов, но возвращает Т
        Supplier<Double> getRandomNumber = () -> Math.random();
        //System.out.println(getRandomNumber.get());

        // UnaryOperator<T> - Принимает и отдает один и тот же тип Т
        UnaryOperator<String> doUpperCase = s -> s.toUpperCase();
        //System.out.println(doUpperCase.apply("hey"));

        // BinaryOperator<T> - Принимает два аргумента одного типа Т, и отдает один
        BinaryOperator<Integer> sumMyNumbers = (a, b) -> a + b;
        //System.out.println(sumMyNumbers.apply(1, 5));

        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Ссылки на методы
        // Всё просто, нужно использовать ::
        Consumer<String> printPlease = System.out::println;
        //printPlease.accept("Hi!");

    }
}