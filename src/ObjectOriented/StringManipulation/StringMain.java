package ObjectOriented.StringManipulation;

import StringManipulation.StringManipulation;

public class StringMain{
    public static void main(String[] args) {
        StringManipulation obj = new StringManipulation();

        //string circular
        String str = "sandeep";
        String str1 = "deepsan";
        String str2 = "eepsan";
        boolean result = obj.checkCircular(str, str1);
        System.out.println(str +"/" + str1 +" : " +result);
        result = obj.checkCircular(str, str2);
        System.out.println(str +"/" + str2 +" : "  +result);
        System.out.println(":::::::::::::::::::::::::::::::");

        //string duplicate char
        obj.printDuplicate(str);
        System.out.println(":::::::::::::::::::::::::::::::");

        //string anagram
        obj.checkAnagram(str, str1);
        obj.checkAnagram1(str, str1);
        System.out.println(":::::::::::::::::::::::::::::::");

        //check string is number or not
        String var1 = "sandeep";
        String var2 = "1234";
        obj.checkStringForNumber(var1);
        obj.checkStringForNumber(var2);
        System.out.println(":::::::::::::::::::::::::::::::");

        //permutation of string
        String perStr = "abc";
        obj.permutation(perStr);
        System.out.println(":::::::::::::::::::::::::::::::");

        //print number of occurence of char in string

        String occStr = "aabbcccsa";
        obj.printOccur(occStr);


    }

}