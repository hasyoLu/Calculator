package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int flag1 = 0;
    private int flag2 = 0;
    private int flag3 = 0;
    private int length1 = 0;
    private int length2 = 0;
    private  int IShaveleftparenthesis = 0;            //标记是否出现左括号
    private boolean ISnegative_sign = false;           //是否是负号
    private boolean ISpiece =  false;                  //是否要加（
    private boolean ISmanyzero = true;
    private String str;
    private TextView textView_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button button_0 = findViewById(R.id.button_0);
        Button button_1 = findViewById(R.id.button_1);
        Button button_2 = findViewById(R.id.button_2);
        Button button_3 = findViewById(R.id.button_3);
        Button button_4 = findViewById(R.id.button_4);
        Button button_5 = findViewById(R.id.button_5);
        Button button_6 = findViewById(R.id.button_6);
        Button button_7 = findViewById(R.id.button_7);
        Button button_8 = findViewById(R.id.button_8);
        Button button_9 = findViewById(R.id.button_9);
        //"."
        Button button_point = findViewById(R.id.button_point);
        Button button_add = findViewById(R.id.button_add);
        Button button_reduce = findViewById(R.id.button_reduce);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divede = findViewById(R.id.button_divede);
        //"清除"
        Button button_c = findViewById(R.id.button_c);
        //"删除"
        Button button_del = findViewById(R.id.button_del);
        Button button_equals = findViewById(R.id.button_equals);
        //"("
        Button button_leftparenthesis = findViewById(R.id.button_leftparenthesis);
        //")"
        Button button_rightparenthesis = findViewById(R.id.button_rightparenthesis);
        textView_1 = findViewById(R.id.TextView_1);
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_reduce.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divede.setOnClickListener(this);
        button_equals.setOnClickListener(this);
        button_c.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_leftparenthesis.setOnClickListener(this);
        button_rightparenthesis.setOnClickListener(this);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        str = textView_1.getText().toString();

        textView_1.post(new Runnable() {
            @Override
            public void run() {
                int line = textView_1.getLineCount();
                if(line==1 && flag3==0){
                    textView_1.setTextSize(80);
                    flag3 = 1;
                }
                if(line==2 && flag1==0){
                    length1 = str.length()-1;
                    Log.d("mainActivity","length1"+      +length1);
                    textView_1.setTextSize(60);
                    flag1 = 1;
                }
                if(line==3 &&  flag2==0){
                    length2 = str.length()-1;
                    Log.d("mainActivity","length2"+      +length2);
                    textView_1.setTextSize(40);
                    flag2 = 1;

                }
            }
        });
        if(str.length()==0 || str.charAt(str.length()-1)!= '0') {
            ISmanyzero = true;
        }

        switch (view.getId()){
            case R.id.button_0:
                if(str.length()==0||str.charAt(str.length()-1)!='/'){
                    if(str.length()==0|| ( !Character.isDigit(str.charAt(str.length()-1)) && str.charAt(str.length()-1)!='.')) {
                        str += "0";
                        ISmanyzero = false;
                    }
                    if(ISmanyzero) {
                        if(str.length()==1&&str.charAt(0)=='0'){
                            ISmanyzero = false;
                            break;
                        }
                        str += "0";
                    }
                    textView_1.setText(str);
                }else{
                    Toast.makeText(MainActivity.this,"不能除以0",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_1:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*1";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="1";
                }

                textView_1.setText(str);
                break;
            case R.id.button_2:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*2";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="2";
                }

                textView_1.setText(str);
                break;
            case R.id.button_3:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*3";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="3";
                }

                textView_1.setText(str);
                break;
            case R.id.button_4:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*4";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="4";
                }

                textView_1.setText(str);
                break;
            case R.id.button_5:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*5";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="5";
                }

                textView_1.setText(str);
                break;
            case R.id.button_6:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*6";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="6";
                }

                textView_1.setText(str);
                break;
            case R.id.button_7:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*7";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="7";
                }

                textView_1.setText(str);
                break;
            case R.id.button_8:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*8";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="8";
                }

                textView_1.setText(str);
                break;
            case R.id.button_9:
                if(str.length()!=0&&str.charAt(str.length()-1)==')')
                    str+="*9";
                else{
                    if(!ISmanyzero)
                        str = str.substring(0,str.length()-1);
                    str+="9";
                }

                textView_1.setText(str);
                break;
            case R.id.button_point:
                if(str.length()>0 && !Character.isDigit(str.charAt(str.length()-1)) )
                    break;
                if(str.length()==0){
                    str += "0.";
                }
                else{
                    int len  = str.length()-1;
                    while(len>=0&&Character.isDigit(str.charAt(len)) ){
                        len--;
                    }
                    if(len>=0&&str.charAt(len)=='.')
                        break;
                    else {
                        str += ".";
                    }
                }
                textView_1.setText(str);
                break;
            case R.id.button_add:
                if(str.length()!=0 && ( str.charAt(str.length()-1)==')' || Character.isDigit(str.charAt(str.length()-1))) ) {
                    if (ISpiece) {
                        str += ")+";
                        ISpiece = false;
                    } else
                        str += "+";

                }
                textView_1.setText(str);
                break;
            case R.id.button_reduce:

                if(str.length()==0 || str.charAt(str.length()-1)=='('){
                    ISnegative_sign = true;
                    str+="-";

                }
                else if(str.charAt(str.length()-1)==')'||Character.isDigit(str.charAt(str.length()-1))){
                    if(ISpiece){
                        str+=")-";
                        IShaveleftparenthesis--;
                        ISpiece = false;

                    }else{
                        str+="-";

                        ISnegative_sign = false;
                    }
                }else if( str.length()-2>=0 &&
                        ( Character.isDigit(str.charAt(str.length()-2)) || str.charAt(str.length()-2)==')')) {
                    str += "(-";
                    IShaveleftparenthesis++;
                    ISpiece = true;

                    ISnegative_sign = true;
                }
                textView_1.setText(str);
                break;
            case R.id.button_multiply:
                if(str.length()!=0 && ( str.charAt(str.length()-1)==')' || Character.isDigit(str.charAt(str.length()-1))) ) {
                    if (ISpiece) {
                        str += ")*";

                        IShaveleftparenthesis--;
                        ISpiece = false;
                    } else{
                        str += "*";
                    }

                }
                    textView_1.setText(str);
                break;
            case R.id.button_divede:
                if(str.length()!=0 && ( str.charAt(str.length()-1)==')' || Character.isDigit(str.charAt(str.length()-1)))  ){
                    if(ISpiece){
                        str+=")/";
                        IShaveleftparenthesis--;
                        ISpiece = false;
                    }else
                        str+="/";

                }
                textView_1.setText(str);
                break;
            case R.id.button_equals:
                if(IShaveleftparenthesis!=0){
                    Toast.makeText(MainActivity.this,"请补充右括号",Toast.LENGTH_SHORT).show();
                    break;
                }
                if(str.length()==0)
                    break;
                if(ISpiece){
                    str+=")";
                    IShaveleftparenthesis--;
                    ISpiece = false;
                }
                try {
                    String s = Core_Algorithm.result2(Core_Algorithm.result1(str));
                    textView_1.setText(s);
                    str = s;
                }catch (Exception p){
                    Toast.makeText(MainActivity.this,"输入错误",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_leftparenthesis:
                if(str.length()==0) {
                    str+="(";
                    IShaveleftparenthesis ++;
                }
                else if( str.charAt(str.length()-1)!=')')  {
                    if( !Character.isDigit(str.charAt(str.length()-1)) )
                        str+="(";
                    else{
                        if(ISpiece){
                            str+=")*(";
                            ISpiece = false;
                        }
                        else {
                            str += "*(";
                            ISpiece = true;
                        }
                    }
                    IShaveleftparenthesis ++;
                }
                textView_1.setText(str);
                break;
            case R.id.button_rightparenthesis:
                 if(str.length()!=0 && IShaveleftparenthesis >0 && ( str.charAt(str.length()-1)==')'
                       || Character.isDigit(str.charAt(str.length()-1)) ) ) {
                     if(ISpiece){
                         ISpiece = false;
                     }
                    str += ")";
                    IShaveleftparenthesis --;
                }
                textView_1.setText(str);
                break;
            case R.id.button_c:
                flag1 = flag2 = flag3 = 0;
                str = "";
                IShaveleftparenthesis = 0;            //标记是否出现左括号
                ISpiece =  false;                      //是否要加（
                textView_1.setText(str);
                break;
            case R.id.button_del:

                if(str.length()==0||str.length()==1){
                    str = "";
                    IShaveleftparenthesis = 0;
                }
                else{
                    if(str.charAt(str.length()-1)=='('){
                        if(ISpiece)
                            ISpiece = false;
                        IShaveleftparenthesis--;
                    }
                    else if(str.charAt(str.length()-1)==')')
                        IShaveleftparenthesis++;

                    str = str.substring(0,str.length()-1);
                    if(str.charAt(str.length()-1)=='-'&& ISnegative_sign)
                        str = str.substring(0,str.length()-1);
                }
                if(str.length()<=length1) {
                    flag3 = 0;
                    flag1 = 0;
                }
                else if(str.length()<=length2) {
                    flag1 = 0;
                    flag2 = 0;

                }
                textView_1.setText(str);
                break;

        }

    }
}