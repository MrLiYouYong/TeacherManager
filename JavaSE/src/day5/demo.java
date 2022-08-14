package day5;

import org.junit.Test;


public class demo {

    @Test
    public void test1(){

        String str = "I Love Java!";

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if(str.charAt(i)>= 97 && str.charAt(i) <= 122){
            }
        }
    }
}
