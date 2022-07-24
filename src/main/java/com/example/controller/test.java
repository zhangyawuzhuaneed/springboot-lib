package com.example.controller;

import org.junit.Test;

import java.util.*;

public class test {

    @Test
    public void text() {
//        List<B> a = new ArrayList<A>();
        List<B> a = new ArrayList<B>();
        B b = new B();
        a.add(b);
        a.get(0).call();

//        A a1 = new A();
//        a1.call();
//        B b = new B();
//        b.call();
    }
}

class A {
    private String name;

    public void call() {
        System.out.println("A.call");
    }

}

class B extends A {
    private String name;

    public void call() {
        System.out.println("B.call");
    }
}


//    public static void main(String[] args) {
//        //动态规划
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n;
//        int cur_n;
//        int cur;
//        int loop=0;
//        int Result;
//        List<Integer> list = new ArrayList<Integer>();
//        List<Integer> result = new ArrayList<Integer>();
//        while(scanner.hasNext() && m > 0) {
//            n = scanner.nextInt();
//            cur_n = n;
//            while (scanner.hasNext() && cur_n > 0) {
//                cur = scanner.nextInt();
//                list.add(cur);
//                cur_n--;
//            }
//            Result = T(n, list, result);
//            System.out.println(Result);
//            m--;
//        }
//
//    }
//
//    private static int T(int n, List<Integer> list, List<Integer> result) {
//        if (list.size()==1){
//            return list.get(0);
//        }
//        for(int i = 0; i<n-1; i++){
//            if (list.get(i+1) == null){
//                result.add(list.get(i));
//                break;
//            }else{
//                result.add(list.get(i+1));
//            }
//            i++;
//        }
//        int o = result.get(result.size()/2);
//        return o;
//    }
//}
//
//


//
//    时间限制： 5000MS
//    内存限制： 589824KB
//    题目描述：
//
//    K语言的每个代码块由仅包含一个关键字xxx的一行开头，并以仅包含end xxx的一行结束。其中xxx是一个长度不超过100的仅由小写英文字母组成的字符串。与其他语言类似，K语言中的代码块仅允许互相包含，不允许仅有部分重叠。现在给出几段仅包含代码块开头行和结尾行的K语言程序，请你判断它们是否符合K语言的语法。
//
//
//
//    输入描述
//    第一行有一个正整数T(1<=T<=100)，代表有T段K语言程序需要你进行判断。
//
//    每段K语言程序前面均有一个正整数n(1<=n<=100)代表这段K语言程序包含多少行。所有n之和不超过500。
//
//    每段K语言程序均由小写英文字母和空格组成，且关键字不包含空格。每行的长度不超过100。
//
//    输出描述
//    对于每段K语言程序，若其符合语法则输出Yes，否则输出No。
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n;
//        String cur;
//        String order;
//        Queue<String> queue = new ArrayDeque<>();
//        Boolean[] result = new Boolean[m];
//        int loop=0;
//        while(scanner.hasNext()&& m > 0) {
//            n = scanner.nextInt();
//            while (scanner.hasNext() && n > 0) {
//                cur = scanner.next();
//                queue.add(cur);
//                if(cur == "end"){
//                    order = scanner.next();
//                    if(order == queue.peek()){
////                        continue;
//                    }else{
//                        result[loop] = false;
//                        break;
//                    }
//                }
//                n--;
//            }
//            loop++;
//            queue.clear();
//            m--;
//        }
//        String[] suc = new String[m];
//        for (int i=0;i<m;i++){
//            if (result[i]==true){
//                suc[i] = "Yes";
//            }else {
//                suc[i] = "No";
//            }
//        }
//        System.out.println(suc);
//
//    }
//
//}


//
//
//    }
//

//    //        Double m = scanner.nextDouble();
//    int m = scanner.nextInt();
//    int n = scanner.nextInt();
//        while (m < n) {
//        int h = (int) (m / 100);
//        int t = (int) ((m % 100 - h) * 10);
//        int s = (int) (((m % 100 - h) * 10 - t) * 10);
//
//
//        if (Math.pow(h, 3) + Math.pow(t, 3) + Math.pow(s, 3) == m) {
//        System.out.println(m);
//        }
//        m++;
//
//        }

//}
//        import java.util.*;
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        while(cin.hasNext()){
//            int m = cin.nextInt();
//            int n = cin.nextInt();
//            double res = getResult(m,n);
//            System.out.println(String.format("%.2f",res));
//        }
//    }
//
//    public static double getResult(int m,int n){
//
//        double res = m;
//        double pre = m;
//        for(int i=1;i<n;i++){
//            pre = Math.sqrt(pre);
//            res +=pre;
//        }
//        if(n==0) res=0;
//        return res;
//
//    }
//}
