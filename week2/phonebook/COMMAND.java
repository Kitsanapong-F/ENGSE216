package week2.phonebook;

import java.util.Scanner;

public class ComMand {
    private PhoneBook pb = new PhoneBook();
    private boolean loop1 = true;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        runCommand();
    }

    public void runCommand() {
        pb.wellCome();
        while (loop1) {
            System.out.print("Command :");
            String comMand = sc.nextLine().trim();
            switch (comMand) {
                case "Add" -> {
                    pb.menuAdd();
                }
                case "Remove" -> {
                    pb.menuRemove();
                }
                case "Edit" -> {
                    pb.menuEdit();
                }
                case "Insert" -> {
                    pb.menuInsert();
                }
                case "Sort" -> {
                    pb.sortData();
                }
                case "Show" -> {
                    pb.showAll();
                }
                case "Help" -> {
                    pb.help();
                }
                case "Exit" -> {
                    loop1 = false;
                }
                default -> {
                    System.out.print("Error:");
                    System.out.println("คำสั่งผิด!");
                }
            }
        }
    }
}
