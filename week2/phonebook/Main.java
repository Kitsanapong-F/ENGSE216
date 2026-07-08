package week2.phonebook;

public class Main {

   public static void main(String[] args) {
        Listphonebook l = new Listphonebook();
        l.add("kitsanapong0", "chaisu0", "0");
        l.add("kitsanapong1", "chaisu1", "1");
        l.add("kitsanapong2", "chaisu2", "2");
        l.add("kitsanapong3", "chaisu3", "3");
        l.add("kitsanapong4", "chaisu4", "4");
        l.remove(3);
        l.showAll();
   }
}
