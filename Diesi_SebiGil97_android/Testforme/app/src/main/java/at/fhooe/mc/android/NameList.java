package at.fhooe.mc.android;

import java.io.Serializable;

public class NameList implements Serializable {
    Node head=null;
    Node tail=null;
    int elements=0;

    void append(Name unamie){
        Node p=new Node();
        p.data=unamie;
        if(head==null){
            head=p;
        }else{
            tail.next=p;
        }
        tail=p;
        elements++;
    }

    public int elements(){
        return 5;
    }

    public String toText(){
       Node p=new Node();
       p=head;
        StringBuffer text=new StringBuffer();
        text.append("Name: ");
        while(p!=null){
            text.append(p.data.getUnamie());
            text.append(" ");
            p=p.next;
        }

        return text.toString();



    }
}
