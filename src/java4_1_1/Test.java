package java4_1_1;

import java.util.Stack;

public class Test {
    public boolean canThreePartsEqualSum(int[] A) {
        int num=0;
        for(int i=0;i<A.length;i++){
            num=num+A[i];
        }
        if(num%3!=0){
            return false;
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<A.length;i++){
            stack.push(A[i]);
        }
        int a=0,b=0,c=0;
        if(!stack.isEmpty()) {
            if(a!=num/3) {
                a += stack.pop();
            }
            if (a == num / 3) {
                if(b!=num/3) {
                    b += stack.pop();
                }
                c=num/3;
            }
        }
        return a==b&&b==c;
    }

    public static void main(String[] args) {
        int[] B={0,2,1,-6,6,-7,9,1,2,0,1};
        Test a=new Test();
        System.out.println(a.canThreePartsEqualSum(B));
    }
}
