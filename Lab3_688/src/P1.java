import java.util.ArrayList;

public class P1 {
    private final ArrayList<Integer> prices;
    private final ArrayList<Integer> dptable;
    private final int length;

    public P1(int rod_length) {
        if (rod_length <= 0) {
            throw new IllegalArgumentException("Rod length must be positive");
        }
        length = rod_length;
        prices = new ArrayList<>(length);
        dptable = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            dptable.add(0);
        }
    }

    public void addPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (prices.size() < length) {
            prices.add(price);
        }
    }

    public void run() {
        if (prices.size() != length) {
            throw new IllegalStateException("Not all prices have been added");
        }
        
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dptable.set(0, prices.getFirst());
                continue;
            }
            
            int maxValue = prices.get(i);  // Value when not cutting
            for (int j = 1; j <= i; j++) {
                // Try all possible cuts
                int currentValue = prices.get(j-1) + dptable.get(i-j);
                maxValue = Math.max(maxValue, currentValue);
            }
            dptable.set(i, maxValue);
        }
    }

    public int lookup(int l) {
        if (l <= 0 || l > length) {
            throw new IllegalArgumentException("Invalid length: " + l);
        }
        return dptable.get(l-1);
    }
}