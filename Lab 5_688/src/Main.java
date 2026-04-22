import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String sample1 = "Hello World";
        String sample2 = "ATAACGGCTAATA";
        String pattern1 = "World";
        String pattern2 = "ATA";

        System.out.println("\nBoyer Moore String Search Algorithm: \n");

        BMStringSearch bms1 = new BMStringSearch(sample1);
        BMStringSearch bms2 = new BMStringSearch(sample2);

        System.out.println("Text 1: " + sample1);
        System.out.println("Pattern 1: " + pattern1);
        bms1.Search(pattern1);
        bms1.printMatchIndices();

        System.out.println();

        System.out.println("Text 2: " + sample2);
        System.out.println("Pattern 2: " + pattern2);
        bms2.Search(pattern2);
        bms2.printMatchIndices();

        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("Rabin-Karp String Search Algorithm: ");
        System.out.println();


        int a = 123456;
        int b = 234;
        System.out.println("Text: " + a);
        System.out.println("Pattern: " + b);

        RKSearch rk1 = new RKSearch(a);
        rk1.Search(b);



    }
}