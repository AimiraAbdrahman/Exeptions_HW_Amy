package View;

import java.util.Scanner;

import Controller.DataController;
import Model.PersonalData;
import Service.MyFileWriter;

public class DataScreening {

    DataController dataController = new DataController();
    PersonalData user = new PersonalData();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - внести данные");
            System.out.println("2 - записать данные в файл");
            System.out.println("3 - выход");
            
            switch (scanner.nextInt()) {
                case 1 -> inputData();
                case 2 -> writeDataToFile();
                case 3 -> System.exit(0);
                default -> System.out.println("Операция не поддерживается");
            }
        }
    }

            private PersonalData inputData() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите данные: ");
                String input = scanner.nextLine();
                String[] userData = input.split(" ");
                if (userData.length != 6) {
                    System.out.println("Ошибка: Неверное количество данных. Введите данные в формате: 'Фамилия Имя Отчество датарождения номертелефона пол'");
                }
                user.setLastName(userData[0]);
                user.setFirstName(userData[1]);
                user.setMiddleName(userData[2]);
                user.setDateOfBirth(userData[3]);
                user.setPhoneNumber(Long.parseLong(userData[4]));
                user.setGender(userData[5].charAt(0));
                return user;
            }

            private void writeDataToFile() {
                try {
                    String fileData = "<" + user.getLastName()+ "><" + user.getFirstName() + "><" + user.getMiddleName() + "><" + user.getDateOfBirth() + "><" + user.getPhoneNumber() + "><" + user.getGender() + ">";
                    MyFileWriter fileGenerator = new MyFileWriter();
                    fileGenerator.generateFile(user.getLastName() + ".txt", fileData);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ошибка: Неверный формат данных.");
                }
                catch (IllegalArgumentException e){
                    System.out.println("Ошибка: Неверный пол. Должен быть обозначен как 'f' (female) или 'm' (male).");
                }
                catch (RuntimeException e) {
                    System.out.println("Ошибка: Неверный формат даты. Дата должна быть введена в формате 'dd.mm.yyyy'.");
                }
            }
        }
    

