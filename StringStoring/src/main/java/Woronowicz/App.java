package Woronowicz;

import java.io.UnsupportedEncodingException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnsupportedEncodingException {


    }

    public void toBinaryTest() throws UnsupportedEncodingException {
        String exampleText = "Hi! I will be converted to binary! A little afraid but... \nwhatever xD      \n";
        System.out.println(exampleText.length());

        byte[] convertedString = exampleText.getBytes("UTF-8");


        for (byte b: convertedString) {
            System.out.print(b+" ");
        }
        System.out.println();

        String backAgain = new String(convertedString);
        System.out.println(backAgain);
        System.out.println(backAgain.length());
    }

    public String stripTrailingSpaces(String given){
        

        return new String();
    }

}
