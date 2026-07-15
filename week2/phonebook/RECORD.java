package week2.phonebook;

public class Record {

    private String name;
    private String lastName;
    private String phon;

    Record(String name, String lastName, String phon) {
        setName(name);
        setLastname(lastName);
        setPhon(phon);
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            this.name = "Unknown";
        }
    }

    public void setLastname(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            this.lastName = "Unknown";
        }
    }

    public void setPhon(String phon) {
        if (phon != null && !phon.trim().isEmpty()) {
            this.phon = phon.trim();
        } else {
            this.phon = "Unknown";
        }
    }

    public String getName() {
        return this.name;
    }

    public String getLastname() {
        return this.lastName;
    }

    public String getPhon() {
        return this.phon;
    }
}
