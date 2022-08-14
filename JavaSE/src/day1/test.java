package day1;

import org.junit.Test;

import javax.swing.plaf.synth.SynthColorChooserUI;
import java.util.Scanner;


public class test {
    @Test
    public void test(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        char ch = 'a';

        System.out.println(ch);
        System.out.println(ch+1);
        System.out.println((char)(ch+1));

        double d = 3.14;
        System.out.println(d);
        i = (int)d+1;
        System.out.println((double)d+1);
        System.out.println((int)d+1);
        System.out.println(i);

    }
}
