package week2.phonebook;

public class Listphonebook {
    String name[] = new String[5];
    String lastName[] = new String[5];
    String phoneNumber[] = new String[5];
    int count = 0;
    String nameAndlastName[] = new String[this.name.length];
    String temp;

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

    void remove(int inDexremove){
        if(inDexremove >= 0 && inDexremove < count){
            for(int i = inDexremove ; i < count-1 ; i++){
            this.name[i] = this.name[i+1];
            this.lastName[i] = this.lastName[i+1];
            this.phoneNumber[i] = this.phoneNumber[i+1];
        }
        count--;
        }
        else{
            System.out.println("Error: Index out of bounds");
        }
    }

    void inSert(int inDexinSert, String name,String lastName,String phoneNumber){
       if(!isfull()){
            if(inDexinSert >= 0 && inDexinSert <= count){
                for(int i = count-1 ; i >= inDexinSert ; i--){
                    this.name[i+1] = this.name[i]; 
                    this.lastName[i+1] = this.lastName[i];
                    this.phoneNumber[i+1] = this.phoneNumber[i];
                }
                this.name[inDexinSert] = name;
                this.lastName[inDexinSert] = lastName;
                this.phoneNumber[inDexinSert] = phoneNumber;
                count++;
            }
             else{
                System.out.println("Error: Index out of bounds");
            }
        }else{
            System.out.println("Is Full");
        }
    }
    
    void bubBlesort(){
        for(int index = 0 ; index < count ; index++){
            this.nameAndlastName[index] =  (this.name[index].toUpperCase() +" "+ this.lastName[index].toUpperCase());
        }
        for(int i = 0 ; i < count-1 ; i++){
            for(int j = 0 ; j < count-1 ; j++){
                if(this.nameAndlastName[j].compareTo(this.nameAndlastName[j+1]) > 0){

                    temp = this.nameAndlastName[j];
                    this.nameAndlastName[j] = this.nameAndlastName[j+1];
                    this.nameAndlastName[j+1] = temp;

                    temp = this.name[j];
                    this.name[j] = this.name[j+1];
                    this.name[j+1] = temp;
                    
                    temp = this.lastName[j];
                    this.lastName[j] = this.lastName[j+1];
                    this.lastName[j+1] = temp;

                    temp = this.phoneNumber[j];
                    this.phoneNumber[j] = this.phoneNumber[j+1];
                    this.phoneNumber[j+1] = temp;
                }
            }
        }
    }

    void editDataname(int inDexedit,String name){
        if(inDexedit >= 0 && inDexedit< count){
            if(name != null && !name.isEmpty()){
                this.name[inDexedit] = name;
            }
        }
    }
     void editDatalastName(int inDexedit,String lastName){
        if(inDexedit >= 0 && inDexedit < count){
            if(lastName != null && !lastName.isEmpty()){
                this.lastName[inDexedit] = lastName;
            }
        }
    }
     void editDataphonNumber(int inDexedit,String phone){
        if(inDexedit >= 0 && inDexedit < count){
            if(phone != null && !phone.isEmpty()){
                this.phoneNumber[inDexedit] = phone;
            }
        }
    }

    void editData(int inDexedit,String name ,String lastName,String phone){
        editDataname(inDexedit,name);
        editDatalastName(inDexedit, lastName);
        editDataphonNumber(inDexedit, phone);   
    }
    void showAll(){
        for(int index = 0 ; index < count; index++){
           System.out.println("No "+(1 + index)+":"+" Name "+this.name[index]+":"+" LastName  "+this.lastName[index]+":"+" PhoneNumber  "+this.phoneNumber[index]);
        }
    }

    void showAll1(){
        for(int index = 0 ; index < count; index++){
            System.out.println(this.nameAndlastName[index]);
        }
    }
}