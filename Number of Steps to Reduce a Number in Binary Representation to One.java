import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int count = 0;
        BigInteger target = BigInteger.ONE;
        return evenOdd(num, count, target);
    }

    public int evenOdd(BigInteger n, int steps, BigInteger target) {
        if (n.equals(target)) {
            return steps;
        }
        if (n.testBit(0)) {
            return evenOdd(n.add(BigInteger.ONE), ++steps, target);
        } else {
            return evenOdd(n.divide(BigInteger.TWO), ++steps, target);
        }
    }
}
