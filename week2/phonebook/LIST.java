package week2.phonebook;

public class List {
    private Record conTact[] = new Record[10];
    private int count = 0;
    private Record temp;
    private int status = 0;

    public void add(Record conTact) {
        status = 0;
        if (!isFull()) {
            this.conTact[count] = conTact;
            count++;
        } else {
            System.out.println("สมุดโทรศัพท์เต็มแล้ว!");
            status = -1;
        }
    }

    public void edit(int inDexedit, Record newconTact) {
        status = 0;
        if (inDexedit >= 0 && inDexedit < count) {
            this.conTact[inDexedit] = newconTact;
        } else {
            status = -1;
            System.out.println("ตำแหน่งที่เลือกอยู่นอกขอบเขตข้อมูล!");
        }
    }

    public void inSert(int inDexinSert, Record conTact) {
        status = 0;
        if (!isFull()) {
            for (int inDex = count - 1; inDex >= inDexinSert; inDex--) {
                this.conTact[inDex + 1] = this.conTact[inDex];
            }
            this.conTact[inDexinSert] = conTact;
            count++;
        } else {
            status = -1;
            System.out.println("สมุดโทรศัพท์เต็มแล้ว!");
        }
    }

    public void remove(int index) {
        status = 0;
        if (count <= 0 || index < 0 || index >= count) {
            status = -1;
            return;
        }

        for (int i = index; i < count - 1; i++) {
            conTact[i] = conTact[i + 1];
        }

        conTact[count - 1] = null;
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
                System.out.printf("| %-4d | %-13s | %-13s | %-10s |\n", (inDex + 1), r.getName(), r.getLastname(),
                        r.getPhon());
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    public boolean isFull() {
        return count == this.conTact.length;
    }

    public int getSize() {
        return count;
    }

    public int getStatus() {
        return status;
    }

    public int getSizeconTact() {
        return this.conTact.length;
    }
}
