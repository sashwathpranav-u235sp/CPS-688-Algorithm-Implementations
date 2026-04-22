import java.util.ArrayList;

public class BMStringSearch {

    //StringBuilder is used to store text and pattern
    StringBuilder text;
    StringBuilder pattern;
    ArrayList<Integer> match_indices;


    public BMStringSearch(String text) {
        this.text = new StringBuilder(text);
        match_indices = new ArrayList<>(); // initializes an empty arraylist to store the indices where matches are found
    }

    //Boyer Moore algorithm implemented using Bad character rule only
    //Search method implements the Boyer Moore algorithm
    public void Search(String pattern) {
        // pattern is initialized to the pattern string passed to the Search method
        this.pattern = new StringBuilder(pattern);
        int t = 0; // current index on the text string
        while (t <= (text.length() - pattern.length())) { // prevents IndexOutOfBoundsException due to large shifts in t and t+j
            int j = pattern.length() - 1; // current index on the pattern string which is the last index of the pattern
            while (j >= 0 && pattern.charAt(j) == text.charAt(t + j)) { // j is decremented until j is negative, which indicates a match.
                j--;                                                    // the while loop ends when j is negative or if there's a mismatch
            }
            if (j < 0) {
                match_indices.add(t); // when a match is found, the index where the match occurred is added to the match_indices arraylist
                t++; // t is incremented to the next character in the text
            } else {
                char badChar = text.charAt(t + j); // In a mismatch, the mismatched character is stored in badChar
                t += Math.max(1,j-findLastOccurrence(badChar)); // the largest possible shift in t is found using Math.max()
                                                                // j-findLastOccurrence(badChar) is used if the mismatched character is in the pattern
                                                                // else t is incremented by 1
            }
        }

    }

    // Finds the index of the last occurrence of a character in the pattern
    private int findLastOccurrence(char character) {
        return pattern.lastIndexOf(String.valueOf(character)); //lastIndexOf() method is used to find the last occurrence of a character in the pattern
    }

    // Prints all the indices where matches are found
    public void printMatchIndices() {
        for (int x: match_indices) {
            System.out.println("Match found at index: " + x);
        }
    }


    //Getter methods for text and pattern

    public String getText() {
        return text.toString();
    }

    public String getPattern() {
        return pattern.toString();
    }
}