package Program;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {

        UI ui = new UI(new Engine());
            boolean f = true;
            Scanner scanner = new Scanner(System.in);
            while (f) {
                System.out.println("*** Программа запущена ***");
                System.out.println("=======================");
                System.out.println("1. Добавить животное");
                System.out.println("2. Добавить команду");
                System.out.println("3. Показать команды");
                System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
                System.out.print("Пожалуйста, выберите пункт меню: ");
                try(Counter counter = new Counter()) {
                    if (scanner.hasNextInt()) {
                        int no = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            switch (no) {
                                case 0:
                                    System.out.println("Завершение работы приложения");
                                    f = false;
                                    break;
                                case 1:

                                    ui.addNewAnimal();
                                    System.out.println("Успешно добавлено.");
                                    counter.add();
                                    break;
                                case 2:
                                    ui.addNewCommand();
                                    System.out.println("Команда добавлена.");
                                    break;
                                case 3:
                                    ui.showCommands();
                                    break;

                                default:
                                    System.out.println("Укажите корректный пункт меню.");
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Введена не корректная дата");
                            f = false;
                        } catch (InputMismatchException e) {
                            System.out.println("Введены не корректные данные");
                            f = false;
                        } catch (NullPointerException e) {
                            System.out.println("Что-то пошло не так либо животное не добавлено");
                            f = false;
                        }
                    } else {
                        System.out.println("Укажите корректный пункт меню.....");
                        scanner.nextLine();
                    }
                }catch (Exception e){
                    throw new RuntimeException("Не закрытый поток");
                }
            }
    }
}






