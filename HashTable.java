/**
 * This is a HashTable class.  Keys and values are of 
 * type String and they can't be null. The default constructor creates a table 
 * that initially has 30 locations. The table increases in size if it 
 * becomes more than 3/4 full.
 */
public class HashTable {

   /**
    List Node constructor with key value pairs 
    */
   private static class ListNode {
      String key;
      String value;
      ListNode next;  // Pointer to next node in the list;
                      
   }

   private ListNode[] table; 

   private int count;  // The number of (key,value) pairs in the hash table.

   
   /**
    * Create a hash table with an initial size of 30.
    */
   public HashTable() {
      table = new ListNode[30];
   }

   
   /**
    * Create a hash table with a specified initial size.
    */
   public HashTable(int initialSize) {
      if (initialSize <= 0)
         throw new IllegalArgumentException("Illegal table size");
      table = new ListNode[initialSize];
   }

   
   /**
    * This method is NOT part of the usual interface for a hash table.  
    * It is here only to be used for testing purposes, and should be 
    * removed before the class is released for general use.  This 
    * lists the (key,value) pairs in each location of the table.
    */
   void dump() {
      System.out.println();
      for (int i = 0; i < table.length; i++) {
             // Print out the location number and the list of
             // key/value pairs in this location.
         System.out.print(i + ":");
         ListNode list = table[i]; // For traversing linked list number i.
         while (list != null) {
            System.out.print("  (" + list.key + "," + list.value + ")");
            list = list.next;
         }
         System.out.println();
      }
   } 

   
   /**
    * Method to associate specific key with specific value
    */
   public void put(String key, String value) {
      
      assert key != null : "The key must be non-null";
      
      int bucket = hash(key); // location for key
      
      ListNode list = table[bucket]; // For traversing the linked list
                                    
      while (list != null) {
         if (list.key.equals(key))
            break;
         list = list.next;
      }
      
      // At this point, either list is null, or list.key.equals(key), thus change the value of key to its value.
      
      if (list != null) {
         list.value = value;
      }
      else {
         if (count >= 0.75*table.length) {
               // The table is becoming too full, increase the size
            resize();
            bucket = hash(key);  // recompute the code as it depends on size
         }
         ListNode newNode = new ListNode();
         newNode.key = key;
         newNode.value = value;
         newNode.next = table[bucket];
         table[bucket] = newNode;
         count++; 
      }
   }

   
   /**
    * Retrieve the value associated with the specified key in the table, 
    * if there is any.  If not, the value null will be returned.
    */
   public String get(String key) {
      
      int bucket = hash(key);  
      
      ListNode list = table[bucket];
      while (list != null) {
         if (list.key.equals(key))
            return list.value;
         list = list.next;  
      }
      
      // If we get to this point, then we have looked at every node in the list without finding the key.  
      
      return null;  
   }

   
   /**
    * Remove the key and its associated value from the table,if the key occurs in the table.  

    */
   public void remove(String key) {  
      
      int bucket = hash(key); 
      
      if (table[bucket] == null) {
            
         return; 
      }
      
      if (table[bucket].key.equals(key)) {
            // If the key is the first node on the list, then table[bucket] must be changed to eliminate the first node from the list.
         table[bucket] = table[bucket].next;
         count--; // Remove new number of items in the table.
         return;
      }
      
      //to remove a node from somewhere in the middle of the list, or at the end.  
      
      ListNode prev = table[bucket]; 
      ListNode curr = prev.next;  
      while (curr != null && ! curr.key.equals(key)) {
         curr = curr.next;
         prev = curr;
      }
      
      // if curr.key is equal to key remove curr from the list, if curr is null then do nothing
      // to do.
      
      if (curr != null) {
         prev.next = curr.next;
         count--; 
      }
   }

   
   /**
    * Test whether the specified key has an associated value in the table.
    
    */
   public boolean containsKey(String key) {
      
      int bucket = hash(key); 
      
      ListNode list = table[bucket]; 
      while (list != null) {
         if (list.key.equals(key))
            return true;
         list = list.next;
      }
      
      return false;
   }

   
   /**
    * Return the number of key/value pairs in the table.
    */
   public int size() {
      return count;
   }


   /**
    * Compute a hash code for the key
    */
   private int hash(Object key) {
      return (Math.abs(key.hashCode())) % table.length;
   }

   
   /**
    * method to resize the table
    */
   private void resize() {
      ListNode[] newtable = new ListNode[table.length*2];
      for (int i = 0; i < table.length; i++) {
         ListNode list = table[i]; 
         while (list != null) {
            ListNode next = list.next;  
               
            int hash = (Math.abs(list.key.hashCode())) % newtable.length;
               
            list.next = newtable[hash];
            newtable[hash] = list;
            list = next; 
         }
      }
      table = newtable;  // Replace the table with the new table.
   } 
   

} 
