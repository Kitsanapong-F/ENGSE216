package week2.phonebook;

import java.util.Scanner;

public class PHONBOOK {
    private LIST l = new LIST();
    private Scanner scanner = new Scanner(System.in);

    public void menuAdd() {
        System.out.println("Name");
        String name = scanner.nextLine();
        System.out.println("Lastname");
        String lastName = scanner.nextLine();
        System.out.println("Phon");
        String phon = scanner.nextLine();
        l.add(new RECORD(name, lastName, phon));
    }

    public void menuRemove() {
        System.out.println("index");
        int index = scanner.nextInt();
        l.remove(index);
    }

    public void menuEdit() {
        System.out.println("index");
        int index = scanner.nextInt();
        scanner.next();
        System.out.println("Name");
        String name = scanner.nextLine();
        System.out.println("Lastname");
        String lastName = scanner.nextLine();
        System.out.println("Phon");
        String phon = scanner.nextLine();
        l.edit(index, (new RECORD(name, lastName, phon)));
    }

    public void showAll() {
        l.showAll();
    }
}
