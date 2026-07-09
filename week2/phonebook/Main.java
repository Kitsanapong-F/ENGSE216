package week2.phonebook;

public class Main {
   public static void main(String[] args) {
      Listphonebook l = new Listphonebook();
      l.add("c", "chaisu", "0");
      l.add("a", "chaisu", "1");
      l.add("z", "chaisu", "2");
      l.add("d", "chaisu", "3");
      System.out.println(l.count-1);
      l.bubBlesort();
      l.showAll();
   }
}
