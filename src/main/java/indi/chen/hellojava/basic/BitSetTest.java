package indi.chen.hellojava.basic;

import java.util.BitSet;

public class BitSetTest {

    public static void getMaxPrimer(int number) {
        BitSet bitSet = new BitSet(number);

        bitSet.set(0, number, true);

        int count = 0;

        int[] primer = new int[number];

        for (int i = 2; i <= Math.sqrt(number * 1.0); i++) {
            if (bitSet.get(i)) {
                for (int j = 2; i * j <= number; j++) {
                    bitSet.clear(i * j);
                }
            }
        }

        for (int i = 2; i < number; i++) {
            if (bitSet.get(i)) {
                primer[count++] = i;
            }
        }
    }
}
