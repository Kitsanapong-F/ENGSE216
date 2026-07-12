package week2.phonebook;

public class LIST {
    private RECORD conTact[] = new RECORD[5];
    private int count = 0;
    private RECORD temp;

    public void add(RECORD conTact){
        if(!isFull()){
            this.conTact[count] = conTact;
            count++;
        }
        else{
            System.out.println("Is Full");
        }
    }

    public void edit(int inDexedit, RECORD newconTact){
        
        if(inDexedit >= 0 && inDexedit < count){
            this.conTact[inDexedit] = newconTact;
        } else {
            System.out.println("Index Out of Bounds");
        }
    }

    public void inSert(int inDexinSert,RECORD conTact){
        if(!isFull()){
            for(int inDex = count ; inDex<inDexinSert ; inDex--){
                this.conTact[inDex+1] = this.conTact[inDex];
            }
            this.conTact[inDexinSert] = conTact;
            count++;
        }
    }

    public void remove(int inDexremove){
        for(int inDex = inDexremove ; inDex < count-1 ; inDex++){
            conTact[inDex] = conTact[inDex+1]; 
        }
        count--;
    }

    public void bubBlesort(){
        for (int inDex = 0 ; inDex < count-1 ; inDex++){
            for(int inDexall = 0 ; inDexall < count-1 ; inDexall++){
                if((this.conTact[inDexall].getName()+" "+this.conTact[inDexall].getLastname()).toUpperCase().compareTo((this.conTact[inDexall+1].getName()+" "+this.conTact[inDexall+1].getLastname()).toUpperCase())>0){
            
                    temp = this.conTact[inDexall];
                    this.conTact[inDexall] = this.conTact[inDexall+1];
                    this.conTact[inDexall+1] = temp;

                }
            }
        }
    }

    public boolean isFull(){
        return  count == this.conTact.length;
    }

    public void showAll(){
        for(int inDex = 0 ; inDex < count ; inDex++){
            System.out.println(this.conTact[inDex].getName()+" "+this.conTact[inDex].getLastname()+" "+this.conTact[inDex].getPhon());
        }
    }
}
