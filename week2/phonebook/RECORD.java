package week2.phonebook;

public class RECORD {

    String name;
    String lastName;
    String phon;

    RECORD(String name, String lastName,String phon){
        setName(name);
        setLastname(lastName);
        setPhon(phon);
    }

    void setName(String name){
        if(name != null && !name.isEmpty()){
            this.name = name;
        }
    }

    void setLastname(String lastName){
        if(lastName != null && !lastName.isEmpty()){
            this.lastName = lastName;
        }
    }

    void setPhon(String phon){
        if(phon != null && !phon.isEmpty()){
            this.phon = phon;
        }
    }
}