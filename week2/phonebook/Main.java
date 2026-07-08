package week2.phonebook;

public class Main {

   public static void main(String[] args) {
        Listphonebook l = new Listphonebook();
        l.add("kitsanapong0", "chaisu0", "0");
        l.add("kitsanapong1", "chaisu1", "1");
        l.add("kitsanapong2", "chaisu2", "2");
        l.add("kitsanapong3", "chaisu3", "3");
        l.inSert(2, "ff","ss","12");
        l.editData(1, "dddddd", null, null);
        l.editDataname(0, "ddd");
        l.showAll();
   }
}
