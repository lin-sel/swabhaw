package com.techlabs.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;  //import  
  
public class GetList {  
  
    public static void main(String... args) throws NoSuchMethodException {  
        
        System.out.println("Constructor List---------------------------------------");
        Class<Class1> cls = Class1.class;  
        Constructor<Class1> constr = cls.getConstructor();
        System.out.println(constr);  
        
        Method[] method = cls.getMethods();
  
        System.out.println("Constructor with int parameter List---------------------------------------");
        constr = cls.getConstructor(int.class);
        System.out.println(constr);  
  
        constr = cls.getConstructor(String.class, BigInteger[].class);
        System.out.println(constr); 
        
        System.out.println("Method List--------------------------------------------");
        for(Method i : method) {
        	System.out.println(i);
        }
    }  
  
    private static class Class1 {  
        public Class1() {  
//            System.out.println("the Default Constructor... "); 
        }  
  
        public Class1(int x) {  
//            System.out.println("this is Parameterized Constructor....(one parameter) ");  
        }  
  
        public Class1(String s, BigInteger[] integers) {
//            System.out.println("the Parameterized Constructor....(multiple parameter) ");  
        }  
        
        public void methodOne() {
//        	System.out.println("Method One......");
        }
        
        public void methodTwo() {
//        	System.out.println("Method Two......");
        }
        
        private void methodThree() {
//        	System.out.println("Method Three.............");
        }
    }  
}  