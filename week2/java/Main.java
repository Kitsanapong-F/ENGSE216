
package week2.java;
public class Main {
    public static void main(String[] args) {
        List l = new List();
        l.add(5);
        l.add(6);
        l.add(9);
        l.add(8);
        l.delete(0);
        l.insert(0, 7);
        l.showall();
    }

}
