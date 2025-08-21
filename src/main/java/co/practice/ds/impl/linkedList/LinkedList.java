package co.practice.ds.impl.linkedList;



public class LinkedList {

    String data;
    Node next;

    private Node head;




   class Node {
       String data;
       Node next;

       Node(String data){
           this.data=data;
           this.next = null;
       }
   }



   public void add(int data){


   }

   public void addFirst(String data){

       Node newNode= new Node(data);
       if(head ==null){
           head=newNode;
           return;
       }

       newNode.next=head;
       head= newNode;

   }

    public void addLast(String data){

        Node newNode= new Node(data);
        if(head ==null){
            head=newNode;
            return;
        }

        Node currentNode=head;

        while(currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next= newNode;

    }


    public void viewAll(){

        StringBuilder sb = new StringBuilder();
        Node currentNode=head;

        if (currentNode == null){
            System.out.println("List Is empty");
        }



        while(currentNode!=null){
            sb.append(currentNode.data).append(" ");
            currentNode=currentNode.next;
        }

       if(sb.length()>0){
           sb.setLength(sb.length()-1);
       }

        System.out.println(sb.toString());

    }


}