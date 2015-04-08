import java.util.Scanner;
 
public class PrintBinary {
    private static int bCount;
     
    public static String makeBin(int num){
        StringBuffer sb = new StringBuffer();
        while ( num != 1){
            sb.append(num%2);
            if ( num%2 == 1){
                bCount++;
            }
            num /= 2;
            if ( num == 1){
                sb.append(num);
                bCount++;
            }
        }           
//        return sb.toString();
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        int ipt;
        Scanner scn = new Scanner(System.in);
         
        System.out.print("Input number greater than 0: ");
        ipt = scn.nextInt();
        
        System.out.println(ipt + " is changed binary number(Use toBinaryString) : " + Integer.toBinaryString(ipt));
        System.out.println(ipt + " is changed binary number : " + makeBin(ipt));
//        System.out.println("and it's '1' count : " + bCount);
         
        scn.close();
         
    }
}