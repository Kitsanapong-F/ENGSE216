package week2.phonebook;

import java.util.Scanner;

public class PHONBOOK {
    private LIST l = new LIST();
    private Scanner scanner = new Scanner(System.in);
    
    public void menuAdd(){
        System.out.println("กรอกชื่อ");
        String name = scanner.nextLine();
        System.out.println("กรอกชื่อ");
        String lastName = scanner.nextLine();
        System.out.println("กรอกชื่อ");
        String phon= scanner.nextLine();
        l.add(new RECORD(name,lastName , phon));
    }

    public void showAll(){
        l.showAll();
    }
}
