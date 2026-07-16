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
        if (l.getStatus() != -1) {
            System.out.println("เพิ่มข้อมูลเรียบร้อยแล้ว!");
        } else {
            System.out.println("เพิ่มข้อมูลไม่สำเร็จ!");
        }
        System.out.println("--------------------------");
    }

    public void menuRemove() {
        System.out.println("--------- ลบข้อมูล ---------");

        showAll();

        int index = inDex("กรอกลำดับที่ต้องการลบ (เช่น 1, 2...): ");

        l.remove(index);

        if (l.getStatus() > -1) {
            System.out.println("ลบข้อมูลเรียบร้อยแล้ว!");
        } else {
            System.out.println("ลบข้อมูลไม่สำเร็จ!");
        }
        System.out.println("--------------------------");
    }

    public void menuEdit() {
        System.out.println("--------แก้ไขรายชื่อ --------");

        showAll();

        int index = inDex("กรอกลำดับที่ต้องการแก้ไข (เช่น 1, 2...): ");

        if (index == -1) {
            System.out.println("แก้ไขข้อมูลไม่สำเร็จ!");
            return;
        }
        String name = letTer("กรอกชื่อ: ");
        String lastName = letTer("กรอกนามสกุล: ");
        String phon = phon("กรอกเบอร์โทร: ");

        l.edit(index, (new Record(name, lastName, phon)));

        if (l.getStatus() > -1) {
            System.out.println("แก้ไขข้อมูลเรียบร้อยแล้ว!");
        } else {
            System.out.println("แก้ไขข้อมูลไม่สำเร็จ!");
        }
        System.out.println("--------------------------");
    }

    public void menuInsert() {
        System.out.println("--------แทรกรายชื่อ--------");

        showAll();

        int index = inSert("กรอกลำดับที่ต้องการแทรก (เช่น 1, 2...): ");

        if (index == -1) {
            System.out.println("แทรกข้อมูลไม่สำเร็จ!");
            return;
        }

        String name = letTer("กรอกชื่อ: ");
        String lastName = letTer("กรอกนามสกุล: ");
        String phon = phon("กรอกเบอร์โทร: ");

        l.inSert(index, new Record(name, lastName, phon));

        if (l.getStatus() > -1) {
            System.out.println("แทรกข้อมูลเรียบร้อยแล้ว!");
        } else {
            System.out.println("แทรกข้อมูลไม่สำเร็จ! (สมุดโทรศัพท์เต็ม)");
        }
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

    public String letTer(String massage) {
        String input = "";
        boolean condition = true;
        while (condition) {
            System.out.print(massage);
            input = scanner.nextLine().trim();
            if (input.matches("^[a-zA-Zก-๏\\s]+$")) {
                condition = false;
            } else {
                System.out.println("กรอกได้เฉพาะตัวอักษรเท่านั้น (ห้ามใส่ตัวเลขหรือสัญลักษณ์พิเศษ)!");
            }
        }
        return input;
    }

    public String phon(String massage) {
        String input = "";
        boolean condition = true;
        while (condition) {
            System.out.print(massage);
            input = scanner.nextLine().trim();

            if (input.matches("^[0-9]{10,10}$")) {
                condition = false;
            } else {
                System.out.println("เบอร์โทรต้องเป็นตัวเลข 10 หลักเท่านั้น!");
            }

        }
        return input;
    }

    public void wellCome() {
        System.out.println("------------------WELLCOME TO PHONBOOK------------------");
        System.out.println("Add    = เพิ่มข้อมูล");
        System.out.println("Remove = ลบข้อมูล");
        System.out.println("Edit   = แก้ไขข้อมูล");
        System.out.println("Insert = แทรกข้อมูล");
        System.out.println("Sort   = เรียงข้อมูล");
        System.out.println("Show   = แสดงข้อมูลจดบันทึก");
        System.out.println("Help   = แสดงตำสั่ง");
        System.out.println("Exit   = ออกโปรแกรม");
        System.out.println("--------------------------------------------------------");
    }

    public void help() {
        System.out.println("-------------------------Help--------------------------");
        System.out.println("Add    = เพิ่มข้อมูล");
        System.out.println("Remove = ลบข้อมูล");
        System.out.println("Edit   = แก้ไขข้อมูล");
        System.out.println("Insert = แทรกข้อมูล");
        System.out.println("Sort   = เรียงข้อมูล");
        System.out.println("Show   = แสดงข้อมูลจดบันทึก");
        System.out.println("Help   = แสดงตำสั่ง");
        System.out.println("Exit   = ออกโปรแกรม");
        System.out.println("--------------------------------------------------------");
    }

    public int inDex(String massage) {
        if (l.getSize() == 0) {
            return -1;
        }

        int temp = 0;
        boolean condition = true;

        while (condition) {
            System.out.print(massage);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input > 0 && input <= l.getSize()) {
                    temp = input;
                    condition = false;
                } else {
                    System.out.printf("ข้อมูลไม่ถูกต้อง! ต้องอยู่ระหว่าง 1 - %d\n", l.getSize());
                }
            } else {
                System.out.println("กรุณากรอกเฉพาะตัวเลขจำนวนเต็มเท่านั้น!");
                scanner.nextLine();
            }
        }
        return temp - 1;
    }

    public int inSert(String massage) {
        if (l.getSize() == 0) {
            return -1;
        }

        int temp = 0;
        boolean condition = true;

        while (condition) {
            System.out.print(massage);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input > 0 && input <= l.getSizeconTact()) {
                    temp = input;
                    condition = false;
                } else {
                    System.out.printf("ข้อมูลไม่ถูกต้อง! ต้องอยู่ระหว่าง 1 - %d\n", l.getSizeconTact());
                }
            } else {
                System.out.println("กรุณากรอกเฉพาะตัวเลขจำนวนเต็มเท่านั้น!");
                scanner.nextLine();
            }
        }
        return temp - 1;
    }
}
