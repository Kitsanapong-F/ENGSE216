package week2.phonebook;

import java.util.Scanner;

public class ComMand {
    private PhoneBook pb = new PhoneBook();
    private boolean loop1 = true;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        wellCome();
        runCommand();
    }

    public void wellCome(){
        System.out.println("------------------WELLCOME TO PHONBOOK------------------");
        System.out.println("Add    = เพิ่มข้อมูล");
        System.out.println("Remove = ลบข้อมูล");
        System.out.println("Edit   = แก้ไขข้อมูล");
        System.out.println("Insert = แทรกข้อมูล");
        System.out.println("Sort   = เรียงข้อมูล");
        System.out.println("Help   = แสดงตำสั่ง");
        System.out.println("Exit   = ออกโปรแกรม");
        System.out.println("--------------------------------------------------------");
    }

    public void runCommand(){
        while (loop1) { 
            String comMand = sc.nextLine();
            switch (comMand) {
                case "Add":
                    pb.menuAdd();
                break;
                 case "Remove":
                    pb.menuRemove();
                break;
                case "Edit":
                    pb.menuEdit();
                break;
                 case "Insert":
                    pb.menuInsert();
                break;
                 case "Sort":
                    pb.sortData();
                break;
                case "Exit":
                    loop1 = false;
                break;
            default:
                System.out.println("คำสั่งผิด!");
            break;
        }   
        }
    } 
}
