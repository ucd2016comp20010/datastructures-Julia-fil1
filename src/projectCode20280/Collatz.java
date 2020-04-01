package projectCode20280;

public class Collatz {

    public static int collatz(int n) throws IllegalArgumentException{
        if(n < 1){
            throw new IllegalArgumentException("The number has to be positive");
        }
        if(n == 1){
            return 1;
        }
        if(n % 2 == 0){
            return collatz(n/2);
        }
        else{
            return collatz(n * 3 + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(collatz(5));
        System.out.println(collatz(9));
        System.out.println(collatz(871));
    }
}
