package week2.phonebook;

public class COMMAND {
    PHONBOOK pb = new PHONBOOK();

    public void start() {
        pb.menuAdd();
        pb.menuAdd();
        pb.menuEdit();
        pb.showAll();
    }
}
