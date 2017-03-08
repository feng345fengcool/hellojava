package indi.chen.hellojava.basic;

public class PinyinForNumber {

    // 303,580,009,102
    // three hundred and three billion five hundred and eighty million nine
    // thousand one hundred and two
    // 609,008,056,045
    // six hundred and nine billion eight million fifty-six thousand forty-five

    private static String[] words = {"one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};

    private static String[] wordsOfTen = {"twenty", "thirty", "fouty",
            "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static String[] wordsOfBig = {"billion", "million", "thousand"};

    private static void print(int number) {
        int[] temp = new int[3];
        int i = 0;
        while (number > 0) {
            temp[i++] = number % 10;
            number /= 10;
        }
        if (temp[2] != 0) {
            System.out.print(words[temp[2] - 1] + " hundred");
        }
        int remain = 0;
        remain = remain * 10 + temp[1];
        remain = remain * 10 + temp[1];

        if (temp[2] != 0 && remain != 0) {
            System.out.print(" and ");
        }
        if (remain > 0) {
            if (remain < 20) {
                System.out.print(words[remain - 1]);
            } else {
                System.out.print(wordsOfTen[temp[1] - 2] + "-"
                        + words[temp[0] - 1]);
            }
        }
    }

    public static void main(String[] args) {

        int number = 222200033;

        int[] data = new int[4];

        int i = 0;
        while (number > 0) {
            data[i++] = number % 1000;
            number /= 1000;
        }

        print(data[i - 1]);
        System.out.print(" " + wordsOfBig[4 - i]);
        for (int j = i - 2; j > 0; j--) {
            System.out.print(" ");
            print(data[j]);
            System.out.print(" " + wordsOfBig[3 - j]);
        }
        System.out.print(" ");
        print(data[0]);
        System.out.println();
    }
}
