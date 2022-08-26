package StacksAndQueues;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        TwoInOne stk=new TwoInOne(6);
//        stk.push1(5);
//        stk.push1(7);
//        stk.push1(4);
//        stk.push2(3);
//        stk.push2(4);
//        stk.push2(6);
//        stk.push2(9);
//        stk.pop1();
//        stk.push1(4);
//        stk.pop1();
//        stk.pop1();
//        stk.pop1();
//        stk.pop2();
//        stk.pop2();
//        stk.pop2();
//        stk.pop2();
        ThreeInOneOptimized stk=new ThreeInOneOptimized(6);
        stk.push1(5);
        stk.push1(3);
        stk.push1(9);
        stk.push1(7);
        stk.push1(1);
        stk.push1(2);
        stk.pop1();
        stk.pop1();
        stk.pop3();
        stk.pop3();
        stk.pop3();
        stk.pop2();
        stk.pop2();
        stk.pop2();



    }

}

