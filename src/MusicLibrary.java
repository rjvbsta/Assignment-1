/**
 *
 * @author Rajeev Basanta
 */
import java.util.*;
import java.io.*;


public class MusicLibrary {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("spotifycharts.csv"));  //Declaring a scanner and file on the same line to read the data on spotifycharts.csv
       
        input.nextLine();   //ignoring the first two lines to begin reading the artists name
        input.nextLine();
        
        String[] artists = new String[200]; //declaring the max size of the array
        
        for(int i = 0; i < artists.length; i++){
            String currLine = input.nextLine(); //reading the next line containing artists and song name           
            artists[i] = currLine;                      
        }
        
        arraySort(artists); //sorting the artist names alphabetically
        
        toString(artists);  //printing the artists names
        
        
        
        
    }
    
    //method to get artist names from array
    public static String[] getArtist(String[] arr) {    
        String[] output = arr;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substring(arr[i].indexOf(",")+1);
            arr[i] = arr[i].substring(arr[i].indexOf(",")+1);
            output[i] = arr[i].substring(0, arr[i].indexOf(","));
        }
        return output;
    }
    
    //method to count the number of times an artists name appears
    public int occurenceOfArtist(String[] arr, String name) {
        String[] artists = getArtist(arr);
        int output = 0;
        for (int i = 0; i < artists.length; i++) {
            if (artists[i].equals(name))
                output++;
        }
        return output;
    }
    
    //method to sort the array alphabetically & removes the quotation marks from the beginning of the name
    public static void arraySort(String[] arr) {
        String[] artists = new String[arr.length];
        artists = getArtist(arr);
        for(int i = 1; i < arr.length; i++){
            if(artists[i].charAt(0)=='"'){
                artists[i] = artists[i].substring(1,artists[i].length()-1);
            }
            String temp = arr[i];
            int j = i;
            while(j > 0 && arr[j].compareTo(arr[j-1]) > 0) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    
    //method to print out the list of artists in a String
    public static void toString(String[] arr) {
        for(int i = 0;i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    
    
    
}
