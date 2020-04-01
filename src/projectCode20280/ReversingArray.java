package projectCode20280;

public class ReversingArray {
    public static int[] reverseArray(int[] A, int i, int j){
        if(i < j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            reverseArray(A, i + 1, j -1);
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {12, 5, 19, 6, 11, 3, 9, 34, 2, 1, 15};
        int length = A.length;
        int[] reversedArray = reverseArray(A, 0, length-1);

        for(int i:reversedArray)
            System.out.print(i+" ");
    }
}
