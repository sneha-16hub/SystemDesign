package splitwiseDesignPattern;

import java.util.List;

public interface ExpenseSplit {
    public boolean validateSplit(List<Split> splitDetails,double totalAmount);
}
