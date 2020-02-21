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
    //Certain artist names will be ignored since the song name can contain 
    //commas and will be indexed before the comma seperating the song name and artist name
    //Quotation marks are also removed from most of the artist names with some exceptions
    public static String[] getArtist(String[] arr) {    
        String[] output = arr;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].charAt(0)=='"'){
                arr[i] = arr[i].substring(1,arr[i].length()-1);
            }
            arr[i] = arr[i].substring(arr[i].indexOf(",")+1);
            arr[i] = arr[i].substring(arr[i].indexOf(",")+1);
            output[i] = arr[i].substring(0, arr[i].indexOf(","));
        }
        return output;
    }
    
    //method to count the number of times an artists name appears
    //this method of finding occurences is not as effective as using ArrayList
    //which can be used to find duplicates easier
    public static int occurenceOfArtist(String[] arr) {
        int output = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(arr[i+1])){
                output++;
            }
            else
                return output;
        }
        return output;
    }
    
    //method to sort the array alphabetically
    public static void arraySort(String[] arr) {
        String[] artists = new String[arr.length];
        artists = getArtist(arr);        
        String temp;
        for(int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++) 
            { 
                if (arr[i].compareTo(arr[j]) > 0) 
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    //method to print out the list of artists in a String along with the amount of times they appear in the file
    public static void toString(String[] arr) {
        for(int i = 0;i < arr.length; i++){
            System.out.println(arr[i]+" - "+occurenceOfArtist(arr));
        }
    }
    
    
    
}
