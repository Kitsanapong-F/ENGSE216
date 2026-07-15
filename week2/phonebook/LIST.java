package week2.phonebook;

public class List {
    private Record conTact[] = new Record[2];
    private int count = 0;
    private Record temp;

    public void add(Record conTact) {
        if (!isFull()) {
            this.conTact[count] = conTact;
            count++;
        } else {
            System.out.println("Is Full");
        }
    }

    public void edit(int inDexedit, Record newconTact) {

        if (inDexedit >= 0 && inDexedit < count) {
            this.conTact[inDexedit] = newconTact;
        } else {
            System.out.println("Index Out of Bounds");
        }
    }

    public void inSert(int inDexinSert, Record conTact) {
        if (!isFull()) {
            for (int inDex = count; inDex < inDexinSert; inDex--) {
                this.conTact[inDex + 1] = this.conTact[inDex];
            }
            this.conTact[inDexinSert] = conTact;
            count++;
        }
    }

    public void remove(int inDexremove) {
        for (int inDex = inDexremove; inDex < count - 1; inDex++) {
            conTact[inDex] = conTact[inDex + 1];
        }
        count--;
    }

    public void bubBlesort() {
        for (int inDex = 0; inDex < count - 1; inDex++) {
            for (int inDexall = 0; inDexall < count - 1; inDexall++) {

                Record r1 = this.conTact[inDexall];
                Record r2 = this.conTact[inDexall + 1];

                String fullName1 = (r1.getName() + " " + r1.getLastname()).toUpperCase();
                String fullName2 = (r2.getName() + " " + r2.getLastname()).toUpperCase();

                if (fullName1.compareTo(fullName2) > 0) {
                    temp = this.conTact[inDexall];
                    this.conTact[inDexall] = this.conTact[inDexall + 1];
                    this.conTact[inDexall + 1] = temp;
                }
            }
        }
    }

    public boolean isFull() {
        return count == this.conTact.length;
    }

    public void showAll() {
        if (count == 0) {
            System.out.println("ไม่มีข้อมูลในสมุดโทรศัพท์");
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-4s | %-13s | %-13s | %-10s |\n", "No.", "Name", "Lastname", "Phone");
        System.out.println("---------------------------------------------------------");

        for (int inDex = 0; inDex < count; inDex++) {
            Record r = this.conTact[inDex];
            if (r != null) {
                System.out.printf("| %-4d | %-13s | %-13s | %-10s |\n",
                        (inDex + 1),
                        r.getName(),
                        r.getLastname(),
                        r.getPhon());
            }
        }
        System.out.println("---------------------------------------------------------");
    }
}
