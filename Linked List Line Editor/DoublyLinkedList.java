public class DoublyLinkedList
{
   private DoublyLinkedNode head;
   
   public void insertAtHead(String data)
   {
       DoublyLinkedNode newNode = new DoublyLinkedNode(data);
       newNode.setNextNode(this.head);
      
       if(this.head != null)
       {
         this.head.setPreviousNode(newNode);
       }
       this.head = newNode;
   }

  public void insertAtTail(String info) {
   // Inserts a node at the tail with 'info' as the value.
   DoublyLinkedNode temp = new DoublyLinkedNode(info);
   //insert code here
   if (head == null)
   {
     head = temp;
   }
   else
   {
    DoublyLinkedNode iterator = head;
    while (iterator.getNextNode() != null)
    {
      iterator = iterator.getNextNode();
    }
     iterator.setNextNode(temp);
     temp.setPreviousNode(iterator);
   }
   
 }
    
  public int length()
  {
     int length = 0;
     DoublyLinkedNode current = this.head;
     
     while(current != null)
     {
       length++;
       current = current.getNextNode();
     }
     return length;
  }
   
  public String toString(int l)
  {
     StringBuilder sb = new StringBuilder();
     DoublyLinkedNode n = this.head;

     if(l > this.length() || l < 0)
     {
       return "Invalid Number";
     }

     for(int i = 0; i < l; i++)
     {
       sb.append(n.getData());
       sb.append("\n");
     
       n = n.getNextNode();
     }
     return sb.toString();
  }

  //return a single line of the text file as a string
  public String getLine(int index)
  {
     DoublyLinkedNode n = this.head;
    
    if (n != null){
    //find node at index i
     for (int i = 1; i < index; i++)
     {
       if (n.getNextNode() != null){
         n = n.getNextNode();
       }
     }

     //return string in the found node
     return n.getData();
    }
    else{
      return "no lines present";
    }
  }
  public boolean deleteNode(String data)
  {
      // returns true if successful, and returns false if node is not found
  DoublyLinkedNode iterator = head;

  //loop until iterator has the necessary data
  while (!iterator.getData().equals(data) && iterator.getNextNode() != null)
  {
    iterator = iterator.getNextNode();
  }

   //return false if node was not found
  if (iterator.getNextNode() == null && !iterator.getData().equals(data))
  {
    return false;
  }

   if (iterator.getPreviousNode() != null)
   {
    //set next node after one before deleted to the one that comes after deleted
    iterator.getPreviousNode().setNextNode(iterator.getNextNode());

      if (iterator.getNextNode() != null)
      {
        //set previous node for the one after deleted to the one that comes before deleted
        iterator.getNextNode().setPreviousNode(iterator.getPreviousNode());
     }
   }

   //delete head if that is the one found
   if (iterator == head){
    if (iterator.getNextNode() != null)
    {
        iterator.getNextNode().setPreviousNode(null);
        head = iterator.getNextNode();
     }
    else{
      head = null;  
    }
   }

   //return true if node was found and deleted
   return true;
   
 }

  public void insertNodeAfter(String data, int index)
  {
      // returns true if successful, and returns false if node is not found
  DoublyLinkedNode iterator = head;
  DoublyLinkedNode newNode = new DoublyLinkedNode(data);

  if (iterator != null)
  {
  
    //loop until iterator has the necessary index
    for (int i = 0; i < index; i++)
    {
      if (iterator.getNextNode() != null)
      {
        iterator = iterator.getNextNode();
      }
    }
  
    if (head == null)
    {
      head = newNode;
    }
  
    if (index == 1)
    {
      newNode.setNextNode(head);
      head.setPreviousNode(newNode);
        
      head = newNode;
    }
    else
    {
      if (iterator.getNextNode() != null)
      {
        newNode.setNextNode(iterator.getNextNode());
      }
      newNode.setPreviousNode(iterator);
      if (iterator.getNextNode() != null)
      {
        iterator.getNextNode().setPreviousNode(newNode);
      }
      iterator.setNextNode(newNode);
    }

  }
  else
  {
    head = newNode;  
  }
  
 }
  
}
