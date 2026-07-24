
public class LinkedList {
    int count;
    node head,tail,tarvel;
    void add (int item){
        node nn = new node();
        nn.info = item;
        if(count == 0){
            head = nn;
            tail = nn;
        }
        else{
            tail.link = nn;
            tail = nn;
        }
        count++;
    }

    void  addFirst(int item){
        if(count == 0){
            add(item);
        }
        else{
            node nn = new node(item);
            nn.link = head;
            head = nn;
            count++;
        }
    }

    void showAll(){
        tarvel = head;
        for(int i = 0 ; i<count ; i++){
            System.err.println(tarvel.info+" ");
            tarvel = tarvel.link;
        }
        System.out.println("------------------------------------");
    }
}
