package week1.java;

public class Main {
    public static void main(String[] args) {
        collec c = new collec();
        c.add(15);
        c.add(7);
        c.add(12);
        c.add(16);
        c.add(10);
        c.remove(0);
       System.out.println(c.size());
       c.showall();
    }
}
