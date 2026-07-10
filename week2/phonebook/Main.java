package week2.phonebook;

public class Main {
   public static void main(String[] args) {
      Listphonebook l = new Listphonebook();
      l.add("e", "chaisu", "1");
      l.add("d", "chaisu", "2");
      l.add("c", "chaisu", "3");
      l.add("b", "chaisu", "3");
      l.add("a", "chaisu", "3s");
      l.bubBlesort();
      l.showAll();
      l.showAll1();
   }
}
