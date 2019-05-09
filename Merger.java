/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
      //create a new ArrayList to avoid the in place merge
      ArrayList<String> sortedData = new ArrayList<String>();
      //copy over the useless data
      for(int index = 0;
          index < start0;
          index++) {
          sortedData.add(usersData.get(index));
        }
      //System.out.println("debugging: "" + sortedData);
      //begin the merge sort
      int index0, index1;
      for(index0 = start0, index1 = start1;
          (start1 - index0) * (nItems - index1) != 0; //checks if either list is empty
          ) {
          if(usersData.get(index0).compareTo(usersData.get(index1)) < 0) {
            sortedData.add(usersData.get(index0++)); //deal()
            //System.out.println("debug: list0 deals");
          }else {
            sortedData.add(usersData.get(index1++)); //deal()
            //System.out.println("debug: list1 deals");
          }
      }
      //System.out.println("debugging: " + sortedData);
      //once one of the lists is empty, append the remaining portion of the other list
      if(start1 - index0 == 0) {
        //System.out.println("debug message: list0 remains");
        while(nItems - index1 > 0) {
          sortedData.add(usersData.get(index1++));
        }
      }else {
        //System.out.println("debug message: list1 remains");
        while(start1 - index0 > 0) {
          sortedData.add(usersData.get(index0++));
        }
      }
      //copy over any remaining useless data
      while(usersData.size() > nItems) {
        sortedData.add(usersData.get(nItems++));
      }
      //modify which object usersData refers to
      usersData = sortedData;
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}