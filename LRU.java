import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {
	DoublyLinkedList linkedListFirst;
	DoublyLinkedList linkedListLast;
	Map<Integer, DoublyLinkedList> cacheMap = new HashMap<Integer,DoublyLinkedList>();
	int cachCapacity;
	
	 public LRU(int capacity) {
	        this.cachCapacity = capacity;
	    }
	    
	    public int get(int key) {
	    	DoublyLinkedList output = cacheMap.get(key);
	    	if( output == null) return -1;
	    	removeFromList(output);
	    	addToList(output);
	        return output.value;
	    }
	    
	    private void addToList(DoublyLinkedList output) {
	    	if(linkedListFirst == null) {
	    		linkedListFirst = output;
	    		linkedListLast = output;
	    		
	    	} else {
			linkedListFirst.prev = output;
			output.next = linkedListFirst;
			linkedListFirst = output;
	    	}
		}

		private void removeFromList(DoublyLinkedList output) {
			
			if(output == null) {
				return;
			}
			
			if(output.next != null) {
				output.next.prev = output.prev;
			}
			
			if(output.prev != null) {
				output.prev.next = output.next;
			}
			
			if(output.equals(linkedListFirst)) {
				linkedListFirst = output.next;
			}
			
			if(output.equals(linkedListLast)) {
				linkedListLast = output.prev;
			}
			
		}

		public void put(int key, int value) {
            removeElement(key);
            if(isCacheFull() && linkedListLast!=null) {
	        	removeElement(linkedListLast.key);
	        }
			DoublyLinkedList list = new DoublyLinkedList(key,value);
			cacheMap.put(key,list );
	        addToList(list);
	    }

		private void removeElement(int key) {
			DoublyLinkedList element = cacheMap.get(key);
			removeFromList(element);
			cacheMap.remove(key);
		}

		private boolean isCacheFull() {
			return cacheMap.size() >= cachCapacity;
		}
		
		public static void main(String args[]) {
			LRU cache = new LRU( 2 /* capacity */ );

			cache.put(1, 1);
			cache.put(2, 2);
			cache.get(1);       // returns 1
			cache.put(3, 3);    // evicts key 2
			cache.get(2);       // returns -1 (not found)
			cache.put(4, 4);    // evicts key 1
			cache.get(1);       // returns -1 (not found)
			cache.get(3);       // returns 3
			cache.get(4);       // returns 4
		}
}

class DoublyLinkedList {
	DoublyLinkedList next;
	DoublyLinkedList prev;
	
	int key;
	int value;
	DoublyLinkedList(int key,int value) {
		this.value = value;
		this.key = key;
	}
}

//[null,null,-1,null,-1,-1,-1,null,-1,null,null,null,null,null,null,280,null,null,-1,null,null,null,null,null,null,null,-1,null,null,null,null,null,null,261,null,null,-1,null,-1,null,-1,null,null,-1,null,null,null,-1,38,null,null,-1,null,-1,-1,148,-1,null,-1,null,null,null,-1,null,null,-1,-1,-1,null,null,null,null,-1,-1,136,-1,null,-1,null,-1,null,null,-1,-1,153,-1,-1,-1,null,null,-1,-1,null,-1,null,null,-1,-1,null,null,null,null,null,-1,null,-1,160,null,51,null,null,null,null,-1,null,null,null,null,218,-1,261,-1,null,null,-1,-1,null,null,null,null,null,null,null,193,null,null,-1,-1,null,null,null,null,null,null,null,null,null,null,null,220,null,-1,-1,-1,null,null,null,null,null,-1,null,null,306,null,null,219,null,-1,null,-1,null,266,193,90,-1,null,-1,147,-1,null,null,null,148,147,131,null,null,null,null,-1,291,291,null,-1,178,-1,136,null,-1,null,null,147,-1,null,null,287,-1,null,null,null,-1,null,-1,183,null,null,null,174,null,110,null,-1,null,-1,null,-1,null,null,12,null,null,-1,null,89,305,null,70,-1,94,null,-1,null,null,null,null,-1,241,null,176,null,220,null,-1,null,306,-1,183,-1,12,null,null,-1,null,95,null,null,-1,-1,null,311,111,null,190,null,null,84,null,null,-1,-1,null,null,177,157,null,-1,null,null,-1,null,null,null,174,null,null,51,183,-1,4,null,null,-1,-1,null,null,21,null,null,null,null,51,null,176,null,89,-1,null,-1,null,null,176,313,null,86,null,null,229,null,176,null,null,null,null,294,110,101,null,null,null,null,128,49,null,null,82,null,null,193,null,null,193,null,null,null,null,null,-1,85,null,null,null,101,null,126,66,null,null,-1,null,null,null,null,null,-1,null,-1,67,null,66,null,null,126,101,null,null,null,null,null,null,84,null,184,23,198,110,null,101,null,null,130,null,131,null,null,130,null,null,null,null,null,null,null,null,null,null,null,239,null,35,null,-1,null,null,null,287,null,-1,240,null,313,67,null,236,null,null,121,239,299,101,105,null,null,null,118,null,160,null,135,255,-1,null,11,null,null,null,101,258,-1,35,null,null,null,null,null,null,88,160,null,null,11,null,null,276,null,291,299,90,75,null,291,276,118,null,-1,121,null,null,252,null,null,null,null,145,null,null,191,null,null,null,null,null,-1,null,null,null,null,null,null,null,75,null,null,null,null,null,null,65,23,null,139,164,177,165,311,null,null,null,null,null,null,null,184,null,null,309,null,100,null,null,151,null,null,-1,null,null,167,90,136,299,null,null,null,173,173,null,-1,null,null,null,null,32,null,null,313,45,null,null,null,null,null,null,null,null,null,252,167,null,null,212,null,null,null,null,132,null,94,137,null,308,null,15,null,null,null,null,167,null,null,164,null,null,288,null,null,82,2,null,null,22,null,null,null,null,164,299,137,null,null,295,null,139,null,null,null,null,13,null,null,null,null,101,65,null,null,249,190,null,null,null,null,-1,null,null,null,136,-1,151,null,null,null,null,203,null,90,88,null,null,null,null,null,190,160,null,null,null,40,null,null,null,null,24,null,null,132,30,null,null,236,161,null,null,67,null,null,null,null,119,161,24,132,null,1,267,null,null,null,236,236,null,null,227,15,183,null,311,295,183,null,167,188,47,null,null,null,null,311,null,null,null,53,256,null,144,null,null,268,44,null,188,233,1,191,null,null,null,null,null,null,null,null,275,-1,null,null,null,53,null,138,118,146,null,null,279,null,null,null,null,null,null,175,null,null,null,null,53,null,null,235,null,305,null,44,null,250,null,132,null,null,null,88,null,111,301,102,79,237,null,null,null,301,null,null,null,104,13,null,null,null,null,162,null,null,null,null,null,null,215,-1,null,null,null,null,null,null,233,null,null,null,311,79,null,null,null,null,null,null,null,null,null,230,null,null,76,188,3,264,null,null,-1,null,127,41,69,null,null,null,null,null,null,null,24,212,null,null,null,null,null,47,104,null,null,287,null,24,null,null,null,93,null,52,null,295,69,null,143,86,48,null,null,null,null,260,null,290,null,null,null,null,null,null,41,null,null,283,null,null,287,null,null,null,null,123,null,null,299,203,null,null,null,null,296,null,13,null,null,null,null,null,null,null,null,null,276,null,null,null,null,1,123,98,null,240,250,null,null,null,null,133,null,79,305,209,null,175,-1,null,266,null,6,null,null,120,null,157,116,71,-1,null,null,-1,null,283,3,85,102,null,null,null,106,null,240,null,52,null,286,50,null,101,299,null,null,null,null,301,73,null,null,null,227,null,132,null,null,144,null,279,null,71,null,68,157,null,52,24,null,null,null,268,null,null,197,3,null,25,null,54,null,null,265,271]
//[null,null,-1,null,-1,-1,-1,null,-1,null,null,null,null,null,null,280,null,null,-1,null,null,null,null,null,null,null,-1,null,null,null,null,null,null,261,null,null,-1,null,-1,null,-1,null,null,-1,null,null,null,-1,38,null,null,-1,null,-1,-1,148,-1,null,-1,null,null,null,-1,null,null,-1,-1,-1,null,null,null,null,-1,-1,136,-1,null,-1,null,-1,null,null,-1,-1,153,-1,-1,-1,null,null,-1,-1,null,-1,null,null,-1,-1,null,null,null,null,null,-1,null,-1,160,null,51,null,null,null,null,-1,null,null,null,null,218,-1,261,-1,null,null,-1,-1,null,null,null,null,null,null,null,193,null,null,-1,-1,null,null,null,null,null,null,null,null,null,null,null,220,null,-1,-1,-1,null,null,null,null,null,-1,null,null,306,null,null,219,null,-1,null,-1,null,266,193,90,-1,null,-1,147,-1,null,null,null,148,147,131,null,null,null,null,-1,291,291,null,-1,178,-1,136,null,-1,null,null,147,-1,null,null,287,-1,null,null,null,-1,null,-1,183,null,null,null,174,null,110,null,-1,null,-1,null,-1,null,null,12,null,null,-1,null,89,305,null,70,-1,94,null,-1,null,null,null,null,-1,241,null,176,null,220,null,-1,null,306,-1,183,-1,12,null,null,-1,null,95,null,null,-1,-1,null,311,111,null,190,null,null,84,null,null,-1,-1,null,null,177,157,null,-1,null,null,-1,null,null,null,174,null,null,51,183,-1,4,null,null,-1,-1,null,null,21,null,null,null,null,51,null,176,null,89,-1,null,-1,null,null,176,313,null,86,null,null,229,null,176,null,null,null,null,294,110,101,null,null,null,null,128,49,null,null,82,null,null,193,null,null,193,null,null,null,null,null,-1,85,null,null,null,101,null,126,66,null,null,-1,null,null,null,null,null,-1,null,-1,67,null,66,null,null,126,101,null,null,null,null,null,null,84,null,184,23,198,110,null,101,null,null,130,null,131,null,null,130,null,null,null,null,null,null,null,null,null,null,null,239,null,35,null,-1,null,null,null,287,null,-1,240,null,313,67,null,-1,null,null,121,239,299,101,105,null,null,null,118,null,160,null,135,255,-1,null,11,null,null,null,101,258,-1,35,null,null,null,null,null,null,88,160,null,null,11,null,null,276,null,291,299,90,75,null,291,276,118,null,-1,121,null,null,252,null,null,null,null,145,null,null,191,null,null,null,null,null,-1,null,null,null,null,null,null,null,75,null,null,null,null,null,null,65,23,null,139,164,177,165,311,null,null,null,null,null,null,null,184,null,null,309,null,100,null,null,151,null,null,-1,null,null,167,90,-1,299,null,null,null,173,173,null,-1,null,null,null,null,-1,null,null,313,45,null,null,null,null,null,null,null,null,null,252,167,null,null,212,null,null,null,null,132,null,94,137,null,308,null,-1,null,null,null,null,167,null,null,164,null,null,288,null,null,82,2,null,null,-1,null,null,null,null,164,299,137,null,null,295,null,139,null,null,null,null,-1,null,null,null,null,101,65,null,null,249,190,null,null,null,null,-1,null,null,null,-1,-1,151,null,null,null,null,203,null,90,88,null,null,null,null,null,190,160,null,null,null,40,null,null,null,null,24,null,null,132,30,null,null,-1,161,null,null,67,null,null,null,null,119,161,24,132,null,-1,267,null,null,null,-1,-1,null,null,227,-1,183,null,311,295,-1,null,167,188,47,null,null,null,null,311,null,null,null,53,256,null,144,null,null,268,-1,null,188,233,-1,191,null,null,null,null,null,null,null,null,-1,-1,null,null,null,53,null,138,118,146,null,null,-1,null,null,null,null,null,null,175,null,null,null,null,53,null,null,-1,null,-1,null,-1,null,-1,null,132,null,null,null,88,null,-1,301,102,79,237,null,null,null,301,null,null,null,104,13,null,null,null,null,-1,null,null,null,null,null,null,215,-1,null,null,null,null,null,null,233,null,null,null,311,79,null,null,null,null,null,null,null,null,null,230,null,null,76,188,3,264,null,null,-1,null,127,41,69,null,null,null,null,null,null,null,24,-1,null,null,null,null,null,47,104,null,null,-1,null,24,null,null,null,93,null,-1,null,295,69,null,143,86,48,null,null,null,null,260,null,290,null,null,null,null,null,null,41,null,null,283,null,null,-1,null,null,null,null,123,null,null,299,-1,null,null,null,null,296,null,13,null,null,null,null,null,null,null,null,null,276,null,null,null,null,1,123,-1,null,240,-1,null,null,null,null,133,null,79,305,209,null,175,55,null,266,null,6,null,null,120,null,157,116,71,-1,null,null,-1,null,283,3,-1,102,null,null,null,106,null,240,null,-1,null,286,50,null,101,299,null,null,null,null,301,73,null,null,null,227,null,-1,null,null,144,null,-1,null,71,null,68,157,null,52,24,null,null,null,268,null,null,197,3,null,25,null,54,null,null,265,271]
// 2 3 4 5 1 