package week2.phonebook;

public class RECORD {

    private String name;
    private String lastName;
    private String phon;

    RECORD(String name, String lastName,String phon){
        setName(name);
        setLastname(lastName);
        setPhon(phon);
    }

    public void setName(String name){
        if(name != null && !name.isEmpty()){
            this.name = name;
        }
        else{
            this.name = "Unknown";
        }
    }

    public void setLastname(String lastName){
        if(lastName != null && !lastName.isEmpty()){
            this.lastName = lastName;
        }
        else{
            this.lastName = "Unknown";
        }
    }

    public void setPhon(String phon){
        if(phon != null && !phon.isEmpty()){
            this.phon = phon;
        }
        else{
            this.phon = "Unknown";
        }
    }

    public String getName(){
        return this.name;
    }

    public String getLastname(){
        return this.lastName;
    }

    public String getPhon(){
        return this.phon;
    }
}