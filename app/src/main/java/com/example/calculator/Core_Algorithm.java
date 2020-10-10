package com.example.calculator;

import android.util.Log;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Core_Algorithm {
    public static ArrayList<String> result1(String formula){            //传入算式，计算结果返回
        //中缀转后缀
        /*
        for (int i = 1; i < formula.length(); i++) {
            if (formula.charAt(i) == '-' && formula.charAt(i - 1) == '(') {
                formula.insert(i, '0');
            }
        }

         */
        ArrayDeque<String> ad = new ArrayDeque<>();         //存放操作符
        ArrayList<String>  list = new ArrayList<>();        //存放后缀表达式
        String temp = "";
        for(int i = 0; i < formula.length(); i++){
            char c = formula.charAt(i);
            if( (c=='-'&& i==0 ) || (c=='-'&& formula.charAt(i-1)=='(') ){
                //temp+='-';
                list.add("0");
                ad.push("-");
            }
            else if(Character.isDigit(c)||c=='.'){
                if(i==formula.length()-1) {                 //如果最后有"."，不做处理
                    if (c != '.')
                        temp += c;
                    list.add(temp);
                }
                else if(i==0 && c== '.'){                   //如果左前面有小数点，变为0.c
                    temp+="0"+c;
                }else
                    temp+=c;
            }
            else{
                if(temp!=""){
                    list.add(temp);
                    temp = "";
                }
                if(c=='(')
                    ad.push(c+"");             //遇到左括号直接入栈
                    //遇到右括号吧操作符栈中的运算符出栈并在存放表达式的栈中入栈，直到遇到"("
                else if(c==')'){
                    while(!ad.isEmpty()&&!ad.peek().equals("(")){

                        list.add(ad.pop());
                    }
                    if(ad.peek().equals("("))
                        ad.pop();
                }
                //如果是加减乘除
                else{

                    if(list.isEmpty()&&c!='-')
                        continue;
                    switch (c){
                        case '+':
                        case '-':
                            if(!ad.isEmpty() && priority(ad.peek())>=0){
                                //ad2.push(ad1.pop());
                                list.add(ad.pop());
                                ad.push(c+"");
                            }
                            else{
                                ad.push(c+"");
                            }
                            break;
                        case '*':
                        case '/':
                            ad.push(c+"");
                            break;
                    }

                }

            }
        }
        while(!ad.isEmpty()){
            //ad2.push(ad1.pop());
            list.add(ad.pop());
        }
        if(list.size()==1){
            list.add("0");
            list.add("+");
        }
        Log.d("Core Algo",list.toString());
        return list;
    }
    public static int priority(String p){
        if(p.equals("*") || p.equals("/")){
            return 1;
        }else if(p.equals("+") || p.equals("-")){
            return 0;
        }
        return -1;
    }
    //计算逆波兰表达式
    public static String result2(ArrayList<String> list){
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            int j = arr.size();
            switch (list.get(i)){
                case "+":
                    //这里注意：remove后arr.size少一个所以第二个j-2可理解为arr.size()-1-1
                    BigDecimal a = new BigDecimal(arr.remove(j-2)).add(new BigDecimal(arr.remove(j-2)));
                    arr.add(String.valueOf(a));
                    break;
                case "-":
                    BigDecimal b = new BigDecimal(arr.remove(j-2)).subtract(new BigDecimal(arr.remove(j-2)));
                    arr.add(String.valueOf(b));
                    break;
                case "*":
                    BigDecimal c = new BigDecimal(arr.remove(j-2)).multiply(new BigDecimal(arr.remove(j-2)));
                    arr.add(String.valueOf(c));
                    break;
                case "/":
                    BigDecimal d = new BigDecimal(arr.remove(j - 2)).divide
                            (new BigDecimal(arr.remove(j - 2)), 20, BigDecimal.ROUND_HALF_UP);
                    arr.add(String.valueOf(d));
                    break;
                default:arr.add(list.get(i));
                break;
            }
        }
        String rt = arr.get(0);
        if(rt.length()==1)
            return rt;
        if(rt.matches("^[\\\\+\\\\-]?([0-9]*[.][0-9]*)$")) {       //匹配是否是小数
            int i = rt.length() - 1;                                       //匹配成功的去除末尾的0
            while (rt.charAt(i) == '0')
                i--;
            if (rt.charAt(i) == '.')
                i--;
            rt = rt.substring(0, i + 1);
        }
        return rt;
    }


}
