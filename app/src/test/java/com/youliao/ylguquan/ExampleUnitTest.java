package com.youliao.ylguquan;

import com.youliao.ylguquan.modle.MainModule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        MainModule mainModule1=new MainModule();
        MainModule mainModule2=new MainModule();
        float i=7>>1;
        System.out.println("mainModule1 hashcode:"+mainModule1.hashCode());
        System.out.println("mainModule2 hashcode:"+mainModule2.hashCode());
        print(""+i);
    }

    private void print(String  str){
        System.out.println(str);
    }
}