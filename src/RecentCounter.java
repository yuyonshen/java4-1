import java.util.*;

//最近的请求次数
public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    public int ping(int t) {
        queue.add(t);
        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
    //法官小镇
    public int findJudge(int N, int[][] trust) {
        List<Integer> A=new LinkedList<>();
        List<Integer> B=new LinkedList<>();
        for(int i=0;i<N;i++){
            A.add(trust[i][0]);
            B.add(trust[i][1]);
        }
        for(int j=0;j<A.size();j++){
            for(int i=0;i<B.size();i++){
                if(A.get(j)==B.get(i)){
                    B.remove(i);
                }
            }
        }
        if(B.isEmpty()){
            return -1;
        }
        int i=0;
        for( i=1;i<B.size();i++) {
            if (B.get(0) != B.get(i)) {
                return -1;
            }
        }
        return B.get(i);
    }
    //将数组分为和相等的三部分
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
                a += stack.pop();
                if (a == num / 3) {
                    b+=stack.pop();
                    if(b==num/3){
                        c+=stack.pop();
                    }
                }
            }
        return a==b&&b==c;
    }
//    public boolean canThreePartsEqualSum(int[] A){
//        int sum=0;
//        for(int i=0;i<A.length;i++){
//            sum=sum+A[i];
//        }
//        if(sum%3!=0){
//            return false;
//        }
//        int left = 0;
//        int leftSum = A[left];
//        int right = A.length - 1;
//        int rightSum = A[right];
//
//        while(left + 1 < right){
//            if(leftSum == sum/3 && rightSum == sum/3){
//                // 左右两边都等于 sum/3 ，中间也一定等于
//                return true;
//            }
//            if(leftSum != sum/3){
//                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
//                leftSum += A[++left];
//            }
//            if(rightSum != sum/3){
//                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
//                rightSum += A[--right];
//            }
//        }
//        return false;
//    }
}



