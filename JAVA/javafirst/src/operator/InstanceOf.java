package operator;

import java.util.Arrays;

public class InstanceOf {

    static class Data implements Comparable{
        public int x;

        @Override
        public int compareTo(Object o) {
            return 0;
        }

        public Data(int x) {
            this.x = x;
        }
    }
    public static void main(String[] args) {
        int[] ar = {100, 300, 200, 150};
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
