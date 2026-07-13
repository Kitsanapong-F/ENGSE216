package week2.phonebook;

import java.util.Scanner;

public class PhoneBook {
    private List l = new List();
    private Scanner scanner = new Scanner(System.in);

    public void menuAdd() {
        System.out.println();
        System.out.println("--- เพิ่มรายชื่อ ---");
        System.out.print("กรอกชื่อ: ");
        String name = scanner.nextLine();
        System.out.print("กรอกนามสกุล: ");
        String lastName = scanner.nextLine();
        System.out.print("กรอกเบอร์โทร: ");
        String phon = scanner.nextLine();
        l.add(new Record(name, lastName, phon));
        System.out.println("เพิ่มข้อมูลเรียบร้อยแล้ว!");
    }

    public void menuRemove() {
        System.out.println();
        System.out.println("--- ลบข้อมูล ---");
        System.out.print("กรอกลำดับที่ต้องการลบ (เช่น 1, 2...): ");
        int index = scanner.nextInt();
        scanner.nextLine();
        index -= 1;
        l.remove(index);
        System.out.println("ลบข้อมูลเรียบร้อยแล้ว!");
    }

    public void menuEdit() {
        System.out.println();
        System.out.println("--- แก้ไขรายชื่อ ---");
        System.out.print("กรอกลำดับที่ต้องการแก้ไข (เช่น 1, 2...): ");
        int index = scanner.nextInt();
        System.out.print("กรอกชื่อ: ");
        String name = scanner.nextLine();
        System.out.print("กรอกนามสกุล: ");
        String lastName = scanner.nextLine();
        System.out.print("กรอกเบอร์โทร: ");
        String phon = scanner.nextLine();
        index -= 1;
        l.edit(index, (new Record(name, lastName, phon)));
        System.out.println("แก้ไขข้อมูลเรียบร้อยแล้ว!");
    }

    public void menuInsert() {
        System.out.println();
        System.out.println("---แทรกรายชื่อ ---");
        System.out.print("กรอกลำดับที่ต้องการแทรก (เช่น 1, 2...): ");
        int index = scanner.nextInt();
        System.out.print("กรอกชื่อ: ");
        String name = scanner.nextLine();
        System.out.print("กรอกนามสกุล: ");
        String lastName = scanner.nextLine();
        System.out.print("กรอกเบอร์โทร: ");
        String phon = scanner.nextLine();
        index -= 1;
        l.inSert(index, (new Record(name, lastName, phon)));
        System.out.println("แทรกข้อมูลเรียบร้อยแล้ว!");
    }

    public void sortData() {
        System.out.println();
        System.out.println("--- เรียงข้อมูล ---");
        l.bubBlesort();
        System.out.println("เรียงข้อมูลเรียบร้อยแล้ว!");
    }

    public void showAll() {
        l.showAll();
    }
}
