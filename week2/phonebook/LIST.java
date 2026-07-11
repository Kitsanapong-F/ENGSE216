package week2.phonebook;

public class LIST {
    RECORD conTact[] = new RECORD[10];
    int count = 0;

    void add(RECORD conTact){
        if(!isfull()){
            this.conTact[count] = conTact;
            count++;
        }
        else{
            System.out.println("Is Full");
        }
    }


    void inSert(){

    }

    void remove(){

    }

    void bubBlesort(){
        
    }

    boolean isfull(){
        return  count == this.conTact.length;
    }

    void showAll(){
        for(int inDex = 0 ; inDex < count ; inDex++){
            System.out.println(this.conTact[inDex].name);
        }
    }
}
