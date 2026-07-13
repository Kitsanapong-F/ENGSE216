package week2.phonebook;

public class ComMand {
    PhoneBook pb = new PhoneBook();

    public void start() {
        pb.menuAdd();
        pb.menuAdd();
        pb.sortData();
        pb.showAll();
    }
}
