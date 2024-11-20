import java.util.Scanner;
import java.math.BigInteger;

class Ass1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        String x = sc.nextLine();

        BigInteger B = new BigInteger(x);

        System.out.println(calculateSquare(B));
    }

    public static BigInteger calculateSquare(BigInteger B){
        String number = B.toString();
        int length = number.length();

        if(length == 1){
            return B.multiply(B);
        }

        int mid = length/2;


        String l = number.substring(0, mid);
        String r = number.substring(mid);


        BigInteger L = new BigInteger(l);
        BigInteger R = new BigInteger(r);

        BigInteger L2 = calculateSquare(L);
        BigInteger R2 = calculateSquare(R);

        BigInteger LR = L.multiply(R).multiply(BigInteger.TWO);
        BigInteger LR = L.multiply(R).multiply(BigInteger.valueOf(2));

        BigInteger ans = L2.multiply(BigInteger.TEN.pow(2*(length-mid))).add(L.multiply(R).multiply(BigInteger.TEN.pow(length-mid)).multiply(BigInteger.valueOf(2))).add(R2);
        return ans;
    }
}