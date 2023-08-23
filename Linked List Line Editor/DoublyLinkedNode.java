public class DoublyLinkedNode
{
 private String data;
 private DoublyLinkedNode nextNode;
 private DoublyLinkedNode previousNode;
 
 public DoublyLinkedNode (String data)
 {
   this.data = data;
 }
 public String getData()
 {
   return data;
 }
 
 public DoublyLinkedNode getNextNode()
 {
   return nextNode;
 }
 
 public DoublyLinkedNode getPreviousNode()
 {
   return previousNode;
 }
 
 public void setData (String data)
 {
   this.data = data;
 }
 
 public void setNextNode (DoublyLinkedNode nextNode)
 {
   this.nextNode = nextNode;
 }
 
 public void setPreviousNode (DoublyLinkedNode previousNode)
 {
   this.previousNode = previousNode;
 }
}
