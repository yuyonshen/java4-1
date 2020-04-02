package java4_1_1;

import java.util.*;

public class Soution {
        //员工的重要性
        class Employee {//创建一个员工的类
            //员工的id
            public int id;
            //员工的重要性
            public int importance;
            //创建一个下属的集合
            public List<Integer> subordinates;
        }
    //创建一个map集合
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
    //创建map的对象
     map=new HashMap<>();
    //将员工的属性增加到hashMap的键值对中
     for(Employee e:employees){
        map.put(e.id,e);
    }
    return def(id);
    }

    public int def(int id){
        Employee employee=map.get(id);
        int ans=employee.importance;
        for(Integer sub:employee.subordinates){
            ans+=def(sub);
        }
        return ans;
    }
    //猫狗收养问题
    public ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> result=new ArrayList<>();//存放收养的顺序
        ArrayList<Integer> cat_dog=new ArrayList<>();//收容的猫狗
        //遍历ope这个二维数组
        for(int i=0;i<ope.length;i++){
            switch (ope[i][0]){
                case 1://当第一个元素为1时,将元素增加到cat_dog
                    cat_dog.add(ope[i][1]);
                    break;
                case 2://当第二个元素为2时,将元素增加到result
                    //判断第二个元素是否为0如果为零获取cat_dog的首元素.增加到result
                    if(!cat_dog.isEmpty()&&ope[i][1]==0){
                        result.add(cat_dog.get(0));
                        cat_dog.remove(0);

                    }
                    else if (ope[i][1]==1){//当第二个元素为1时,表示收养狗
                        for(int j=0;j<cat_dog.size();j++){
                            if(cat_dog.get(j)>0){
                                result.add(cat_dog.get(j));
                                cat_dog.remove(j);
                                break;
                            }
                        }
                    }
                    else if(ope[i][1]==-1){//当第二个元素为-1时,表示收养猫
                        for(int z=0;z<cat_dog.size();z++){
                            if(cat_dog.get(z)<0){
                                result.add(cat_dog.get(z));
                                cat_dog.remove(z);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return result;
    }
    //约瑟夫问题
    public int getResult(int n) {
    //首先创建一个数组集合,将所有的元素增加到集合中
        LinkedList<Integer> result=new LinkedList<>();
        int round=2;
        int curr=0;
        //将元素增加到集合中
        for(int i=1;i<=n;i++){
            result.add(i);
        }
        //循环遍历当result的长多大于1
        while(result.size()>1){
            int i=0;
            while(result.size()>1&&i<result.size()){
                curr=(curr+1)%round;
                if(curr!=1){
                    result.remove(i);
                }
                else{
                    i++;
                }
            }
            round++;
            curr=0;
            //将尾部元素移除,之后增加到集合首部;
            if(result.size()>1){
                int last=result.removeLast();
                result.addFirst(last);
            }
        }
        return result.pop();
    }


}
