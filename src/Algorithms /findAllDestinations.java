import java.io.*;
import java.util.*;


/*
 * 

 interface Airport {
    bool visited;
    String getCode(); //gives San Francisco -> SFO 
    List<Airport> getDirectConnections();
  }

  //print all destinations from a airport given a departure destination with the number of stops it takes to get there 

//   SOURCE - EWR
//   EWR -> LA -> SD
//   EWR -> SFO  
  
//   LA - 0
//   SD - 1
 */


public class Solution {
  public static void main(String[] args){
    public void printDestinations(Airport source){
      //if source is null or count is 0 
      if(source == null || source.getDirectedConnections().count() == 0){
        throw new IllegalArgumentException("invalid source");
      }
       int destinationCount = 0;
       Queue<String>list = new LinkedList<String>();

       list.add(source);

       while(!list.isEmpty){
          int list_size = list.size();
          while(list_size != 0){
            Airport location = list.remove();
            location.visited = true; //say its part of class
          
            System.out.printf("The number of stops to reach %s is %s", airport.getCode, destinationCount);
            destinationCount += 1;

            for(Airport airport:airport.getDirectedConnections){
              if(airport.visited){ continue;}
              list.add(airport);
            }
            size--; //since you removed one from the list
          }
        }
      }
    }
  }

