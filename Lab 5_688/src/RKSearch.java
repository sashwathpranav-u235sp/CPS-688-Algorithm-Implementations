import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RKSearch {
    // Txt and pattern are stored as integers
    int Txt;
    int Pattern;
    int Q;
    int result_number = 0; //Stores the number that gives the same hash value as the pattern
    ArrayList<Integer> txt_digits; //stores the digits in the text


    public RKSearch(int txt) {
        this.Txt = txt;
        Pattern = 0;
        txt_digits = new ArrayList<>();

        //All the digits in txt are stored in txt_digits
        while (txt > 0) {
            txt_digits.add(0, txt % 10);
            txt /= 10;
        }

        // A large prime number is generated and stored in Q
        Q = getLargePrime();
    }

    // Las Vegas implementation of the Rabin-Karp algorithm
    public void Search(int pattern) {
        Pattern = pattern;
        int hash1 = Pattern%Q; // hash value of the pattern
        int l = lengthOfNumber(Pattern)+ 1; // length of the pattern
        int i = 0; // index of the text
        try {
            while (i <= lengthOfNumber(Txt)+ 1) { // i is less than or equal to the length of the text
                int a = reconstruct_number(txt_digits.subList(i, i+l)); // A number of the same length as the pattern is constructed
                if (a%Q==hash1) { // if hash values are the same
                    result_number = a; // hash values of the reconstructed number and the pattern match
                                        // the reconstructed number is stored in result_number and the loop ends
                    break;
                }

                // If hash values mismatch, i moves to the next digit in the text
                i++;
            }

            // result number and pattern are compared to see if they match as required by the Las Vegas implementation of Rabin-Karp
            if (result_number==Pattern) {

                // If the match is found, the index of the match is printed
                System.out.println("Match found at index: " + i);
            }
        // if i goes out of bounds, no match is found
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No match found");

        }





    }

    // Generates a large prime number
    private int getLargePrime() {
        Random random = new Random();
        Random r = new Random();
        int bitlength = r.nextInt(4,31);
        BigInteger prime;
        do {
        prime = BigInteger.probablePrime(bitlength, random);
        } while (prime.intValue() < 1000); // Ensures it's reasonably large
    
        return prime.intValue();
    }

    //finds the length of the number minus 1
    private int lengthOfNumber(int inp) {
        int e = 0;
        while (inp/Math.pow(10.0,e)>=1) {
            e++;
        }
        return e-1;
    }

    //reconstructs a number from a list or sublist of digits
    private int reconstruct_number(List<Integer> digits) {
        int result = 0;
        int power = digits.size() - 1;
        for (int digit : digits) {
            result += (int) (digit * Math.pow(10, power));
            power--;
        }
        return result;
    }



}