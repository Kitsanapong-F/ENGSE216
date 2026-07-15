package week2.phonebook;

import java.util.Scanner;

public class PhoneBook {
    private List l = new List();
    private Scanner scanner = new Scanner(System.in);

    public void menuAdd() {
        System.out.println("---------เพิ่มรายชื่อ ---------");
        String name = letTer("กรอกชื่อ: ");
        String lastName = letTer("กรอกนามสกุล: ");
        String phon = phon("กรอกเบอร์โทร: ");
        l.add(new Record(name, lastName, phon));
        System.out.println("เพิ่มข้อมูลเรียบร้อยแล้ว!");
        System.out.println("--------------------------");
    }

    public void menuRemove() {
        System.out.println("--------- ลบข้อมูล ---------");
        System.out.print("กรอกลำดับที่ต้องการลบ (เช่น 1, 2...): ");
        int index = scanner.nextInt();
        scanner.nextLine();
        index -= 1;
        l.remove(index);
        System.out.println("ลบข้อมูลเรียบร้อยแล้ว!");
        System.out.println("--------------------------");
    }

    public void menuEdit() {
        System.out.println("--------แก้ไขรายชื่อ --------");
        System.out.print("กรอกลำดับที่ต้องการแก้ไข (เช่น 1, 2...): ");
        int index = scanner.nextInt();
        scanner.nextLine();
        String name = letTer("กรอกชื่อ: ");
        String lastName = letTer("กรอกนามสกุล: ");
        String phon = phon("กรอกเบอร์โทร: ");
        index -= 1;
        l.edit(index, (new Record(name, lastName, phon)));
        System.out.println("แก้ไขข้อมูลเรียบร้อยแล้ว!");
        System.out.println("--------------------------");
    }

    public void menuInsert() {
        System.out.println("--------แทรกรายชื่อ--------");
        System.out.print("กรอกลำดับที่ต้องการแทรก (เช่น 1, 2...): ");
        int index = scanner.nextInt();
        String name = letTer("กรอกชื่อ: ");
        String lastName = letTer("กรอกนามสกุล: ");
        String phon = phon("กรอกเบอร์โทร: ");
        index -= 1;
        l.inSert(index, (new Record(name, lastName, phon)));
        System.out.println("แทรกข้อมูลเรียบร้อยแล้ว!");
        System.out.println("--------------------------");
    }

    public void sortData() {
        System.out.println("---- เรียงข้อมูล ----");
        l.bubBlesort();
        System.out.println("เรียงข้อมูลเรียบร้อยแล้ว!");
        System.out.println("------------------");
    }

    public void showAll() {
        l.showAll();
    }

    public String letTer(String letTer) {
        String input = "";
        boolean condition = true;
        while (condition) {
            System.out.print(letTer);
            input = scanner.nextLine().trim();
            if (input.matches("^[a-zA-Zก-๏\\s]+$")) {
                condition = false;
            } else {
                System.out.println("กรอกได้เฉพาะตัวอักษรเท่านั้น (ห้ามใส่ตัวเลขหรือสัญลักษณ์พิเศษ)!");
            }
        }
        return input;
    }

    public String phon(String phon) {
        String input = "";
        boolean condition = true;
        while (condition) {
            System.out.print(phon);
            input = scanner.nextLine().trim();

            if (input.matches("^[0-9]{10,10}$")) {
                condition = false;
            } else {
                System.out.println("เบอร์โทรต้องเป็นตัวเลข 10 หลักเท่านั้น!");
            }

        }
        return input;
    }
}
