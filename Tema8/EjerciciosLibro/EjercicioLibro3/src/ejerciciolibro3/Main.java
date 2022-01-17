/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Main.java
 *
 * Created on Jan 17, 2022 At 11:45:47 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciolibro3;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 17, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        
        String s[] = {"hello","goodbye"};
        String r[] = {"hello","goodbye","hola"};
        s = r;
        s = addElement(s, "adios");
        for(String i: s){
            System.out.println(i);
        }
        
    }
    
    private static String[] addElement(String[] array, String element){
        String newArray[] = new String[array.length+1];
        
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length-1]=element;
        
        return newArray;
    }
    
    private static void removeElement(String[] array, String element){
        String newArray[] = new String[array.length-1];
        
        for(int i=0; i<array.length; i++){
            if(array[i].equalsIgnoreCase(element)){
                System.arraycopy(array, 0, newArray, 0, i);
                System.arraycopy(array, i+1, newArray, i, array.length-postion);
                break;
            }
        }
        
    }
    
    private static void orderElements(String[] array){
        
    }

}
