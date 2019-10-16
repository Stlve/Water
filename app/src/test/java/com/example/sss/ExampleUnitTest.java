package com.example.sss;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.example.sss.WaterMain;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void cutcards() {
        //用来处理得到的牌，将牌全部拆成十三个字符串
        //int[] Cutcards(String cards)
        WaterMain porker = new WaterMain();
        String card1 ="29 2J 3J 3Q 25 2A 43 15 14 2K 110 4K 47";
        String card2 = "32 33 34 35 36 37 38 39 310 3J 3Q 3K 3A";
        int result1[]=porker.Cutcards(card1);
        int result2[] =porker.Cutcards(card2);
        int w[]={209,211,311,312,205,214,403,105,104,213,110,413,407};
        int s[]={302,303,304,305,306,307,308,309,310,311,312,313,314};
        for (int i=0;i<13;i++){
            Assert.assertEquals(w[i],result1[i]);
        }

    }


    @Test
    public void judgeTonghuashun() {
        WaterMain card = new WaterMain();
        //int JudgeTonghuashun(int card[])
        int c[]={302,303,304,305,306,307,308,309,310,311,312,313,314};
        int d[]={302,303,304,305,306,407,408,409,110,211,312,313,314};
        int result = card.JudgeTonghuashun(c);
        int r = card.JudgeTonghuashun(d);
        Assert.assertEquals(314,result);
        Assert.assertEquals(306,r);
    }

    @Test
    public void judgezhadan() {
        WaterMain card = new WaterMain();
        int num1[]={1,1,1,1,0,1,1,1,1,1,0,4,0,1,0};
        int num2[]={1,4,1,1,0,1,1,1,1,1,0,0,0,1,1};
        int result = card.Judgezhadan(num1);
        int res = card.Judgezhadan(num2);
        Assert.assertEquals(11,result);
        Assert.assertEquals(1,res);
    }

    @Test
    public void judgeTonghua() {
        WaterMain card = new WaterMain();
        int color1[]={0,5,3,4,1};
        int color2[] ={0,3,5,4,1};
        int cardd[]={102,104,105,107,111,202,203,204,304,305,311,312,414};
        int cc[]={102,104,105,207,211,202,203,204,304,305,311,312,414};
        String s = card.JudgeTonghua(color1,cardd);
        String ss = "111 107 105 104 102";
        String a = "204 203 202 211 207";
        String aa = card.JudgeTonghua(color2,cc);
        Assert.assertEquals(ss,s);
        Assert.assertEquals(a,aa);
    }

    @Test
    public void judgeHulu() {
        WaterMain card = new WaterMain();
        int num1[]={1,1,1,1,0,1,1,1,1,2,0,3,0,1,0};
        int num2[]={1,1,3,2,0,1,1,1,1,1,0,0,0,1,1};
        String result = card.JudgeHulu(num1);
        String res = card.JudgeHulu(num2);
        Assert.assertEquals("11 9",result);
        Assert.assertEquals("2 3",res);
    }

    @Test
    public void judgeShunzi() {
        WaterMain card = new WaterMain();
        int num1[]={1,1,1,1,0,1,1,1,1,1,0,1,0,1,0};
        int num2[]={1,1,1,1,0,1,1,0,1,0,1,1,1,1,1};
        int result = card.JudgeShunzi(num1);
        int res = card.JudgeShunzi(num2);
        Assert.assertEquals(9,result);
        Assert.assertEquals(14,res);
    }

    @Test
    public void judgeSantiao() {
        WaterMain card = new WaterMain();
        int num1[]={1,1,1,1,0,1,1,1,1,3,0,1,0,1,0};
        int num2[]={1,1,1,1,0,1,1,0,1,0,1,1,1,1,3};
        int result = card.JudgeSantiao(num1);
        int res = card.JudgeSantiao(num2);
        Assert.assertEquals(9,result);
        Assert.assertEquals(14,res);
    }

    @Test
    public void judgeLink() {
        WaterMain card = new WaterMain();
        int num1[]={1,1,1,1,0,2,1,1,2,2,0,1,0,1,0};
        int num2[]={1,1,1,1,0,1,1,0,2,0,1,2,1,1,1};
        int result = card.JudgeLink(num1);
        int res = card.JudgeLink(num2);
        Assert.assertEquals(9,result);
        Assert.assertEquals(0,res);//没找到
    }

    @Test
    public void judgeTwoCouple() {
        WaterMain card = new WaterMain();
        int num1[]={1,1,1,1,0,2,1,1,1,2,0,1,0,1,0};
        int num2[]={1,1,1,1,0,1,1,0,0,0,1,2,1,1,1};
        String result = card.JudgeTwoCouple(num1);
        String res = card.JudgeTwoCouple(num2);
        Assert.assertEquals("9 5",result);
        Assert.assertEquals("",res);//没找到
    }

    @Test
    public void judgeCouple() {
        WaterMain water = new WaterMain();
        int number[] ={1,1,1,1,0,2,1,1,2,1,0,2,0,1,0};
        int number1[] ={1,1,1,1,2,1,1,1,1,2,0,0,0,1,0};
        int result1 = water.JudgeCouple(number);
        int result2 = water.JudgeCouple(number1);
        Assert.assertEquals(11,result1);
        Assert.assertEquals(9,result2);
    }

    @Test
    public void judgeSingle() {
        WaterMain water = new WaterMain();
        int num1[] ={0,1,1,1,0,2,1,1,2,1,0,2,0,1,0};
        int num2[] ={1,1,1,1,2,1,1,1,1,2,0,0,0,1,0};
        int card1[]={101,202,303,403,305,205,211,408,412,403,307,304,214};
        int card2[]={112,212,312,412,109,209,309,409,103,203,303,403,402};
        int result1 = water.JudgeSingle(num1,card1);
        int result2 = water.JudgeSingle(num2,card2);
        Assert.assertEquals(202,result1);
        Assert.assertEquals(402,result2);
    }

    @Test
    public void findcardmax() {
        WaterMain water = new WaterMain();
        int card1[]={313,406,211,309,409,206,111,412,102,103,104,105,312};
        int card2[]={414,306,302,309,307,203,211,213,202,110,111,105,106};
        int result1 = water.findcardmax(card1);
        int result2 = water.findcardmax(card2);
        Assert.assertEquals(313,result1);
        Assert.assertEquals(414,result2);
    }

    @Test
    public void judgeSpecial() {
        WaterMain water = new WaterMain();
        int card1[]={302,303,304,305,306,307,308,309,310,311,312,313,314};
        int number1[]={0,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int color1[]={0,0,0,13,0};

        int card2[]={102,203,304,405,106,207,308,409,110,211,312,413,214};
        int number2[]={0,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int color2[]={0,3,4,3,3};

        int card3[]={109,209,309,409,104,204,304,404,114,214,314,414,305};
        int number3[]={0,0,0,0,4,1,0,0,0,4,0,0,0,0,4};
        int color3[]={0,3,3,4,3};

        int card4[]={108,109,309,209,210,410,411,412,112,213,313,314,414};
        int number4[]={0,0,0,0,0,0,0,0,1,3,2,1,2,2,2};
        int color4[]={0,3,3,3,4};

        int card5[]={302,202,203,404,104,105,405,205,306,206,107,308,108};
        int number5[]={0,0,2,1,2,3,2,1,2,0,0,0,0,0,0};
        int color5[]={0,4,4,3,2};

        int card6[]={302,202,303,404,104,304,306,106,214,314,114,313,213};
        int number6[]={0,0,2,1,3,0,2,0,0,0,0,0,0,2,3};
        int color6[]={0,3,3,6,1};

        int card7[]={302,202,102,404,104,304,306,406,106,214,314,114,213};
        int number7[]={0,0,3,0,3,0,3,0,0,0,0,0,0,1,3};
        int color7[]={0,4,3,4,2};

        int card8[]={302,403,104,103,404,205,306,207,309,210,211,312,313};
        int number8[]={0,1,1,2,2,1,1,1,0,1,1,1,1,1,0};
        int color8[]={0,2,4,5,2};

        int card9[]={103,104,107,205,206,208,210,211,306,309,310,312,313};
        int number9[]={0,0,0,1,1,1,2,1,1,1,2,1,1,1,0};
        int color9[]={0,3,5,5,0};

        int card10[]={302,202,403,103,404,104,306,406,313,213,214,314,114};
        int number10[]={0,0,2,2,2,0,2,0,0,0,0,0,0,2,3};
        int color10[]={0,3,3,4,3};

        int result1 = water.JudgeSpecial(card1,color1,number1);
        int result2 = water.JudgeSpecial(card2,color2,number2);
        int result3 = water.JudgeSpecial(card3,color3,number3);
        int result4 = water.JudgeSpecial(card4,color4,number4);
        int result5 = water.JudgeSpecial(card5,color5,number5);
        int result6 = water.JudgeSpecial(card6,color6,number6);
        int result7 = water.JudgeSpecial(card7,color7,number7);
        int result8 = water.JudgeSpecial(card8,color8,number8);
        int result9 = water.JudgeSpecial(card9,color9,number9);
        int result10 = water.JudgeSpecial(card10,color10,number10);

        Assert.assertEquals(1,result1);
        Assert.assertEquals(2,result2);
        Assert.assertEquals(5,result3);
        Assert.assertEquals(6,result4);
        Assert.assertEquals(7,result5);
        Assert.assertEquals(8,result6);
        Assert.assertEquals(9,result7);
        Assert.assertEquals(12,result8);
        Assert.assertEquals(13,result9);
        Assert.assertEquals(10,result10);

    }

    @Test
    public void findmax() {
        WaterMain water = new WaterMain();
        int card1[]={403,405,311,411,112,210,407,211,406,111,307,404,314};
        int number1[]={0,0,0,1,1,1,1,2,0,0,1,4,1,0,1};
        int color1[]={0,2,2,3,6};

        int card2[]={413,213,307,207,202,312,304,114,106,313,102,406,409};
        int number2[]={0,1,1,0,1,0,2,2,0,1,0,0,1,3,1};
        int color2[]={0,3,3,4,3};

        int result1 = water.findmax(card1,number1,color1);
        int result2 = water.findmax(card2,number2,color2);

        Assert.assertEquals(9,result1);
        Assert.assertEquals(5,result2);
    }

    @Test
    public void resultout() {
        WaterMain water = new WaterMain();
        int d[]={302,303,304,305,306,407,408,409,110,211,312,313,314};
        int s[]={302,303,304,305,306,207,208,209,210,211,312,313,314};
         String[] result = water.Resultout(d);
         String[] tt = water.Resultout(s);
         //*2 *3 *4 *5 *6 *7 *8 *9 *10 *J *Q *K *A
         String[] rr = {"*2 *3 *4 *5 *6", "#7 #8 #9 $10 &J", "*Q *K *A"};
        String[] uu= {"*2 *3 *4 *5 *6", "&7 &8 &9 &10 &J", "*Q *K *A"};
         Assert.assertEquals(rr,result);
         Assert.assertEquals(uu,tt);


    }



}