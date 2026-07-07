package week2.phonebook;

public class Listphonebook {
    String name[] = new String[5];
    String lastName[] = new String[5];
    String phoneNumber[] = new String[5];
    int count = 0;
    boolean found = false;

    boolean isfull(){
        return  count == this.name.length;
    }

    void add(String name,String lastName, String phoneNumber){
        if(!isfull()){
            this.name[count] = name;
            this.lastName[count] =  lastName;
            this.phoneNumber[count] = phoneNumber;
            count++;
        }
        else{
            System.out.println("Is Full");
        }
    }

    void delete(){

    }

    boolean Insert(){
        return found;
    }

    void sortData(){

    }

    void showAll(){
        for(int index = 0 ; index < count; index++){
            System.out.println("No : "+(1 + index)+" Name : "+this.name[index]+" LastName : "+this.lastName[index]+" PhoneNumber : "+this.phoneNumber[index]);
        }
    }
}