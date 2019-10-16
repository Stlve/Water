package com.example.sss;


import java.util.Arrays;
//javac -encoding utf-8 Water.java
public class WaterMain {
    //执行出牌算法
    //十个等级的牌型
    int level1 = 0, level2 = 0;
    public static void main(String[] args) {
        WaterMain object = new WaterMain();
        //int level[];
        int card[];
        int color[];//花色的数组
        int number1[];//数字多少的数组
        // level = new int[11];
        color = new int[5];
        number1 = new int[15];
        //$代表黑桃--黑色1；&代表红桃2 ；*代表梅花--黑色3；#代表方块4；
        //String c = args;
         String c = "$K &2 *2 #2 $5 *6 #8 *9 *7 *10 $J #K #A";
        String cc = c.replace("$", "1");
        String ccc = cc.replace("&", "2");
        String cccc = ccc.replace("*", "3");
        String ccccc = cccc.replace("#", "4");
        //System.out.print(ccccc);
        card = object.Cutcards(ccccc);
        Arrays.sort(card);//按照花色来排序
        //System.out.print("\n");
        number1 = object.getnum(card);//各个数字的多少
//        for (int i=1;i<number1.length;i++)
//            System.out.print(number1[i]+" ");
//        System.out.print("\n");
        color = object.getcolor(card);//各个花色的多少
        //寻找最大牌型和最大牌型
        int First[];
        First = new int[13];
        int Second[];
        Second = new int[13];
        int one[];
        int l = 0;
        one = new int[10];
        int number[];
        number = number1.clone();
        if (object.JudgeSpecial(card, color, number) != 0) {
            //特殊牌型
            //System.out.print("我是特殊牌型" + object.JudgeSpecial(card, color, number));
            //System.out.print("\n");
            String s[];
            s = object.Resultout(card);
            for (String a : s) {
                System.out.print(a);
                System.out.print("\n");
            }
            //return s;
        } else {
            if (object.JudgeTonghuashun(card) != 0) {
                one[l] = 10;
                l++;
            }
            if (object.Judgezhadan(number) != 0) {
                one[l] = 9;
                l++;
            }
            if (object.JudgeHulu(number) != "") {
                one[l] = 8;
                l++;
            }
            if (object.JudgeTonghua(color, card) != "") {
                one[l] = 7;
                l++;
            }
            if (object.JudgeShunzi(number) != 0) {
                one[l] = 6;
                l++;
            }
            if (object.JudgeSantiao(number) != 0) {
                one[l] = 5;
                l++;
            }
            if (object.JudgeLink(number) != 0) {
                one[l] = 4;
                l++;
            }
            if (object.JudgeTwoCouple(number) != "") {
                one[l] = 3;
                l++;
            }
            if (object.JudgeCouple(number) != 0) {
                one[l] = 2;
                l++;
            }

            int onecard[],onecolor[],onenumber[] ;
            int twocard[], twocolor[], twonumber[];
            onecard = card.clone();
            onecolor = color.clone();
            onenumber = number1.clone();
//            System.out.print("现在的第一次number");
//            for (int i=1;i<number1.length;i++)
//                System.out.print(number1[i]+" ");
//            System.out.print("\n");
            String onecards[];
            String twocards[] = new String[3];
            onecards = object.GetResult(onenumber,onecolor,onecard,one[0],1);
            if (one[0]<=8)
            {
                twocards = object.GetResult(onenumber,onecolor,onecard,one[1],2);
                if (twocards[0]=="failed"){
                    object.level2 = 0;
                }
            }
            if (object.level1>=object.level2){
                for (String a:onecards){
                    System.out.print(a);
                    System.out.print("\n");
                }
               // return onecards;
            }
            else {
                for (String a:twocards){
                    System.out.print(a);
                    System.out.print("\n");
                }
               // return twocards;
            }

        }
    }

    //找牌的函数
    String[] GetResult(int onenumber[],int onecolor[],int onecard[],int ll,int count){
//        for (int i=1;i<onenumber.length;i++)
//            System.out.print(onenumber[i]+" ");
//        System.out.print("\n");
        int l=1;
        int level=0;
        int First[] = new int[13];
        int z=0;
        int x=0;
        String s[] = new String[3];
        for (int n =1;n<=2;n++){
            Arrays.sort(onecard);//按照花色来排序
//                for (int i=0;i<onecard.length;i++)
//                    System.out.print(onecard[i]+" ");
//                System.out.print("\n");
//                for (int i=1;i<onenumber.length;i++)
//                    System.out.print(onenumber[i]+" ");
//                System.out.print("\n");
            if (n==1)
            {
                x = ll;
                //System.out.print("最大等级："+x);
            }
            else{
                x = findmax(onecard,onenumber,onecolor);
                if (x>ll){
                    //倒水了，没有找到比上一墩小的；
                    s[0]="failed";
                    return s;
                }
                //System.out.print("现在的最大等级是："+x+" "+"现在的l："+l);
            }
            int b=0,g=0;
            switch (x){
                case 10:
                    //前墩是10
                    z= JudgeTonghuashun(onecard);
                    int v = z;
                    for(int i=4;i>=0;i--){
                        First[i]=v;
                        v--;
                    }
                    for (int i=0;i<onecard.length;i++)
                    {
                        if (onecard[i]==First[1]||onecard[i]==First[2]||onecard[i]==First[3]||onecard[i]==First[4]||onecard[i]==First[0]){
                            onecard[i]=0;
                            onenumber[onecard[i]%100]--;
                        }
                    }
                    onecolor[z/100]-=5;
                    int h = z%100;
                    onenumber[h]--;
                    onenumber[h-1]--;
                    onenumber[h-2]--;
                    onenumber[h-3]--;
                    onenumber[h-4]--;
                    l++;
                    level+=10;
                    if (l==2)
                        break;
                    break;
                case 9:
                    //前墩
                    level+=9;
                    z = Judgezhadan(onenumber);
                    if (l==1){
                        First[0]=100+z;
                        First[1]=200+z;
                        First[2]=300+z;
                        First[3]=400+z;
                        First[4]=JudgeSingle(onenumber,onecard);//散排
                        for (int i=0;i<onecard.length;i++)
                        {
                            if (onecard[i]==First[1]||onecard[i]==First[2]||onecard[i]==First[3]||onecard[i]==First[4]||onecard[i]==First[0]){
                                onecard[i]=0;
                                //
                                // onenumber[onecard[i]%100]--;
                            }
                        }
                    }
                    else if (l==2){
                        First[5]=100+z;
                        First[6]=200+z;
                        First[7]=300+z;
                        First[8]=400+z;
                        First[9]=JudgeSingle(onenumber,onecard);//散排
                        for (int i=0;i<onecard.length;i++)
                        {
                            if (onecard[i]==First[5]||onecard[i]==First[6]||onecard[i]==First[7]||onecard[i]==First[8]||onecard[i]==First[9]){
                                onecard[i]=0;
                                //onenumber[onecard[i]%100]--;
                            }
                        }
                    }
                    onenumber[z]=0;
                    onecolor[First[9]/100]--;
                    onecolor[1]--;
                    onecolor[2]--;
                    onecolor[3]--;
                    onecolor[4]--;
                    l++;
//                        for (int i=0;i<onecard.length;i++)
//                           System.out.print(onecard[i]+" ");
//                        System.out.print("\n");
//                        for (int i=1;i<onecolor.length;i++)
//                            System.out.print(onecolor[i]+" ");;
//                        System.out.print("\n");
//                        for (int i=1;i<onenumber.length;i++)
//                            System.out.print(onenumber[i]+" ");;
//                        System.out.print("\n");
                    if (l==2)
                        break;
                    break;
                case 8:
                    level+=8;
                    String ss ;
                    ss = JudgeHulu(onenumber);
                    int m[];
                    m = Cutother(ss,2);
                    //for (int i=0;i<m.length;i++)
                    ///System.out.print(m[i]+" ");
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b =g;
                    for (int i=onecard.length-1;i>=0;i--){
                        if ((onecard[i]%100)==m[0]){
                            //System.out.print("葫芦："+onecard[i]+" ");
                            First[b]=onecard[i];
                            b++;
                            onecolor[onecard[i]/100]--;
                            onenumber[onecard[i]%100]--;
                            onecard[i]=0;
                        }
                        if (b==g+3)
                            break;
                    }
                    for (int i=0;i<onecard.length;i++){
                        if (onecard[i]%100==m[1]){
                            //System.out.print("葫芦："+onecard[i]+" ");
                            First[b]=onecard[i];
                            b++;
                            onecolor[onecard[i]/100]--;
                            onenumber[onecard[i]%100]--;
                            onecard[i]=0;
                        }
                        if (b == g+5)
                            break;
                    }
                    l++;
                    if (l==2)
                        break;
                    break;
                case 7:
                    g =0;
                    level+=7;
                    ss = JudgeTonghua(onecolor,onecard);
                    m = Cutother(ss,5);
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b =g;
                    for(int i=0;i<5;i++){
                        First[b]=m[i];
                        b++;
                    }
                    int f=0;
                    for (int i=0;i<onecard.length;i++){
                        if (onecard[i]==m[0]||onecard[i]==m[1]||onecard[i]==m[2]||onecard[i]==m[3]||onecard[i]==m[4]){
                            onenumber[(onecard[i]%100)]--;
                            onecard[i]=0;

                            f++;
                        }
                        if (f==5)
                            break;

                    }
                    onecolor[m[0]/100]-=5;
                    l++;
                    if (l==2)
                        break;
                    break;
                case 6:
                    level+=6;
                    //顺子
                    // System.out.print("找到顺子了！"+"\n")
                    z =JudgeShunzi(onenumber);
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b = g+4;
                    for (int i=onecard.length-1;i>=0;i--){
                        if ((onecard[i]%100==z)){//5
                            //找到了顺子的值
                            First[b]=onecard[i];
                            //System.out.print("顺子"+First[b]);
                            b--;
                            onenumber[onecard[i]%100]--;
                            onecolor[onecard[i]/100]--;
                            onecard[i]=0;
                            for (int j=onecard.length-1;j>=0;j--){
                                if ((onecard[j]%100==z-1)){
                                    First[b]=onecard[j];
                                    //System.out.print("顺子"+First[b]);
                                    b--;
                                    onenumber[onecard[j]%100]--;
                                    onecolor[onecard[j]/100]--;
                                    onecard[j]=0;
                                    for (int k=onecard.length-1;k>=0;k--){
                                        if ((onecard[k]%100==z-2)){
                                            First[b]=onecard[k];
                                            //System.out.print("顺子"+First[b]);
                                            b--;
                                            onenumber[onecard[k]%100]--;
                                            onecolor[onecard[k]/100]--;
                                            onecard[k]=0;
                                            for (int u = onecard.length-1;u>=0;u--){
                                                if ((onecard[u]%100==z-3)){
                                                    First[b]=onecard[u];
                                                    //System.out.print("顺子"+First[b]);
                                                    b--;
                                                    onenumber[onecard[u]%100]--;
                                                    onecolor[onecard[u]/100]--;
                                                    onecard[u]=0;
                                                    for (int a =onecard.length-1;a>=0;a--){
                                                        if ((onecard[a]%100==z-4)){
                                                            First[b]=onecard[a];
                                                            //System.out.print("顺子"+First[b]);
                                                            b--;
                                                            onenumber[onecard[a]%100]--;
                                                            onecolor[onecard[a]/100]--;
                                                            onecard[a]=0;
                                                            break;
                                                        }

                                                    }
                                                    break;
                                                }

                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    l++;
                    if (l==2)
                        break;
                    break;
                case 5:
                    level+=5;
                    z = JudgeSantiao(onenumber);
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b=g;
                    for (int i=onecard.length-1;i>=0;i--){
                        if (onecard[i]%100==z){
                            First[b]=onecard[i];
                            b++;
                            onecolor[onecard[i]/100]--;
                            onenumber[onecard[i]%100]--;
                            onecard[i]=0;
                        }
                        if (b == g+3)
                            break;

                    }
                    First[b]=JudgeSingle(onenumber,onecard);
                    onecolor[First[b]/100]--;
                    onenumber[First[b]%100]--;
                    for (int i=0;i<onecard.length;i++){
                        if (onecard[i]==First[b])
                            onecard[i]=0;
                    }
                    b++;
                    First[b]=JudgeSingle(onenumber,onecard);
                    onecolor[First[b]/100]--;
                    onenumber[First[b]%100]--;
                    for (int i=0;i<onecard.length;i++){
                        if (onecard[i]==First[b])
                            onecard[i]=0;
                    }
                    l++;
                    if (l==2)
                        break;
                    break;
                case 4:
                    //连队
                    level+=4;
//                        for (int i=2;i<onenumber.length;i++)
//                            System.out.print(onenumber[i]+" ");
                    z=JudgeLink(onenumber);
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b=g;
                    onenumber[z]=0;
                    onenumber[z-1]=0;
                    for (int i=onecard.length-1;i>=0;i--){
                        if (onecard[i]%100==z||onecard[i]%100==z-1){
                            First[b]=onecard[i];
                            b++;
                            onecolor[onecard[i]/100]--;
                            onecard[i]=0;
                        }
                    }

                    First[b]=JudgeSingle(onenumber,onecard);
                    //System.out.print(First[b]+"\n");
                    onecolor[First[b]/100]--;
                    onenumber[First[b]%100]--;
                    for (int i=0;i<onecard.length;i++){
                        if (onecard[i]==First[b])
                            onecard[i]=0;
                    }
                    l++;
                    if (l==2)
                        break;
                    break;
                case 3:
                    //对子
                    level+=3;
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b=g;
                    ss = JudgeTwoCouple(onenumber);
                    m = Cutother(ss,2);
                    onenumber[m[0]]-=2;
                    onenumber[m[1]]-=2;
                    for (int i=onecard.length-1;i>=0;i--){
                        if (onecard[i]%100==m[0]||(onecard[i]%100)==m[1]){
                            First[b]=onecard[i];
                            b++;
                            onecolor[onecard[i]/100]--;
                            onecard[i]=0;
                        }
                    }
                    First[b]=JudgeSingle(onenumber,onecard);

                    onecolor[First[b]/100]--;
                    onenumber[First[b]%100]--;
                    for (int i=0;i<onecard.length-1;i++){
                        if (onecard[i]==First[b])
                            onecard[i]=0;
                    }
                    l++;
                    if (l==2)
                        break;
                    break;
                case 2:
                    level+=2;
                    //单对
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b=g;
                    z = JudgeCouple(onenumber);
                    for (int i=0;i<onecard.length;i++){
                        if (onecard[i]%100==z){
                            First[b]=onecard[i];
                            b++;
                            onecolor[onecard[i]/100]--;
                            onecard[i]=0;
                            onenumber[z]--;//@
                        }
                        if (b == 7)
                            break;
                    }
                    for (int j=0;j<3;j++){
                        First[b]=JudgeSingle(onenumber,onecard);
                        onecolor[First[b]/100]--;
                        onenumber[First[b]%100]--;
                        for (int i=0;i<onecard.length;i++){
                            if (onecard[i]==First[b])
                                onecard[i]=0;
                        }
                        b++;
                    }
                    l++;
                    if (l==2)
                        break;
                    break;
                case 1:
                    //全是散牌
                    level+=1;
                    if (l==1)
                        g=0;
                    else if (l==2)
                        g=5;
                    b=g;
                    int gg = b+4;
                    First[gg] = findcardmax(onecard);//最大的
                    onecolor[First[gg]/100]--;
                    onenumber[First[gg]%100]--;
                    //最大牌清零
                    for (int i=0;i<onecard.length;i++){
                        if (First[gg]==onecard[i])
                        {
                            onecard[i]=0;
                            break;
                        }
                    }
                    for (int j=0;j<4;j++){
                        First[g]=JudgeSingle(onenumber,onecard);//找到当前最小的
                        onecolor[First[g]/100]--;
                        onenumber[First[g]%100]--;
                        for (int i=0;i<onecard.length;i++){
                            if (First[g]==onecard[i])
                            {
                                onecard[i]=0;
                                break;
                            }
                        }
                        g++;
                    }
//                        for (int i=0;i<onecard.length;i++)
//                            System.out.print(onecard[i]+" ");
//                        System.out.print("\n");
//                        for (int i=1;i<onecolor.length;i++)
//                            System.out.print(onecolor[i]+" ");;
//                        System.out.print("\n");
//                        for (int i=1;i<onenumber.length;i++)
//                            System.out.print(onenumber[i]+" ");;
//                        System.out.print("\n");
                    ;
                    l++;
                    if (l==2)
                        break;
                    break;

            }
        }
        int f=10;
        for(int i=0;i<onecard.length;i++){
            if (onecard[i]!=0){
                First[f]=onecard[i];
                f++;
            }
            if (f==13)
                break;
        }


        s=Resultout(First);
        for (String a:s){
            System.out.print(a);
            System.out.print("\n");
        }
        if (count==1)
            level1 = level;
        else
            level2 = level;
        return s;
    }

    //用来处理得到的牌，将牌全部拆成十三个字符串
    public int[] Cutcards(String cards){
        String[] cardsplit = cards.split(" ");
        int cardd[];
        cardd = new int[13];
        int j=0;
        for(String a:cardsplit){
            String c ="";
            if (a.contains("J"))
                c = a.replace("J","11");
            else if (a.contains("Q"))
                c = a.replace("Q","12");
            else if (a.contains("K"))
                c = a.replace("K","13");
            else if (a.contains("A"))
                c = a.replace("A","14");
            else
                c = a;
            try {
                cardd[j] = Integer.parseInt(c);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            //cardd[j]= Integer.parseInt(c);
            if (cardd[j]<100){
                cardd[j]=(cardd[j]/10)*100+cardd[j]%10;
            }
            // System.out.print(cardd[j]+" ");
            j++;
            //System.out.print(c);
        }
        return cardd;
    }
    int[] Cutother(String cards,int i){
        int cardd[]=new int[i];
        if (!cards.equals("null")){
            String[] cardsplit = cards.split(" ");

            cardd = new int[i];
            int j=0;
            for(String a:cardsplit) {
                try {
                    cardd[j] = Integer.parseInt(a);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
//                    if (!a.equals("null"))
//                    cardd[j] = Integer.parseInt(a);
                // System.out.print("转换成了"+cardd[j]+" ");
                j++;
            }
        }
        return cardd;
    }
    int[] getcolor(int card[]){
        int color[];
        int s;
        color = new int[5];
        for (int i=0;i<card.length;i++){
            s=card[i]/100;
            color[s]++;
        }
        return color;
    }

    int[] getnum(int card[]){
        int num[];
        int s;
        num = new int[15];
        for (int i=0;i<card.length;i++){
            s=card[i]%100;
            num[s]++;
        }
        return num;
    }

    //同花顺判断
    int JudgeTonghuashun(int card[]){

        for (int i=card.length-1;i>=4;i--){
            // System.out.print(card[i]+" ");
            if ((card[i]==(card[i-1]+1))&&(card[i-1]==(card[i-2]+1))&&(card[i-2]==(card[i-3]+1))&&(card[i-3]==(card[i-4]+1))){
                return card[i];
            }
        }
        return 0;
    }

    //炸弹判断
    int Judgezhadan(int number[]){
        for (int i=number.length-1;i>=0;i--){
            if (number[i]==4){//有炸弹
                return i;
            }
            else continue;
        }
        return 0;
    }

    //同花判断
    String JudgeTonghua(int color[],int card[]){
        String s = "";
        for (int i=1;i<color.length;i++){
            if (color[i]>=5){
                int k=0;
                for (int j=i-1;j>=0;j--)
                    k=k+color[j];
                int l = 1;
                for (int u = color[i]+k-1;u>=k;u--){
                    s = s+card[u];
                    if (l!=5)
                        s = s+" ";
                    if (l==5)
                        break;
                    l++;
                }

            }
        }
        return s;
    }
    //葫芦判断
    String JudgeHulu(int number[]){
        int a = 0,b=0;
        String s ="";
        for (int i=number.length-1;i>=0;i--){
            if (number[i]==3){
                for (int j=1;j<number.length;j++){
                    if (number[j]==2&&number[j+1]!=2&&number[j-1]!=2){//防止把连对拆了
                        s = i+" "+j;
                        return s;
                    }
                }
            }
        }

        return s;
    }

    //顺子判断
    int JudgeShunzi(int number[]){
        for (int i=14;i>=5;i--){
            if (number[i]!=0&&number[i-1]!=0&&number[i-2]!=0&&number[i-3]!=0&&number[i-4]!=0){
                // System.out.print("现在的最大等级是："+i);
                return i;//返回的是顺子的最大值
            }
        }
        return 0;
    }


    //三条判断
    int JudgeSantiao(int number[]){
        for (int i=number.length-1;i>=0;i--){
            if (number[i]==3){
                return i;
            }
        }
        return 0;
    }
    //连对判断
    int JudgeLink(int number[]){
        for (int i=number.length-1;i>=2;i--){
            if (number[i]==2&&number[i-1]==2){
                return i;//返回的是最大的对子的值
            }
        }
        return 0;
    }

    //两对判断
    String  JudgeTwoCouple(int number[]){

        for (int i=number.length-1;i>=1;i--){
            if (number[i]==2){
                for (int j=i-1;j>=1;j--){
                    if (number[j]==2){
                        String s = "";
                        s = i+" "+j;
                        return s;//返回的是两个对子的值的字符串
                    }
                }

            }
        }
        return "";
    }

    //单对判断
    int JudgeCouple(int number[]) {
        for (int i = number.length - 1; i >= 2; i--) {
            if (number[i] == 2)
                return i;//返回现在找到的第一个对子就返回
        }
        return 0;
    }

    int JudgeSingle(int number[],int card[]){
        int num =0;
        for (int i=2;i<number.length;i++){
            if (number[i]==1){
                num = i;
                break;
            }

        }
        for (int j =0;j<card.length;j++){
            if (card[j]%100==num)
                return card[j];
        }
        return 0;
    }

    int findcardmax(int card[]){
        int temp = 0 ;
        int temp1 = 0;
        for (int i=card.length-1;i>=0;i--){
            if (card[i]%100 > temp)
                temp1=card[i];
        }
        return temp1;
    }
    //特殊牌型
    int JudgeSpecial(int cards[],int color[],int number[]){
        int s=0,b =0;//s来判断是不是有凑一色b来判断是不是有一条龙
        int k=0;
        for (int i=1;i<number.length;i++){
            if (number[i]!=0)
                k++;
        }
        if (k==13){
            b = 1;
        }

        if (color[1]==13||color[2]==13||color[3]==13||color[4]==13){
            s = 1;
            //return 8;
        }
        //至尊青龙--13张牌都是同一花色并且2-A
        if (s==1&&b==1)
            return 1;
            //凑一色 13张牌都是方块梅花或者黑桃红心
        else if (s==1&&b==0)
            return 8;
            //一条龙，2-A
        else if (s==0&&b==1)
            return 2;
        int num =0;
        num = number[10]+number[11]+number[12]+number[13]+number[14];
        if (num==13)//十二皇族 十三张牌里面有十二张都是大于10
            return 3;
        //三同花顺



        //三分天下，三炸弹加三杂牌 5
        int r=0;
        for (int i=1;i<number.length;i++){
            if (number[i]==4)
                r++;
        }
        if (r==3)
            return 5;

        //全大，13张牌数字都为8-A 6
        r=0;
        for (int i=2;i<8;i++){
            if (number[i]==0)
                r++;
        }
        if (r==6)
            return 6;

        //全小，13张牌数字都为2-8 7
        r=0;
        for (int i=8;i<number.length;i++){
            if (number[i]==0)
                r++;
        }
        if (r==6)
            return 7;

        //双怪冲三，2对葫芦加一个对子加任意一张杂牌
        r =0;
        int t=0;
        for (int i=0;i<number.length;i++){
            if (number[i]==3)
                r++;
            if (number[i]==2)
                t++;
        }
        if (r==2&&t==3)
            return 8;

        //四套三条，四套相同的三张牌加任意一张杂牌，也就是四个三条
        if (r==4)
            return 9;

        //五对三条，五个对子加三张相同的牌型
        if (t==5&&r==1)
            return 10;

        //六对半 六个对子加任意一张杂牌
        if (t==6)
            return 11;

        //三顺子，三墩水都是顺子
        int ss[]=number.clone();
        //ss = number;
        for (int i=ss.length-1;i>=5;i--){
            if (ss[i]!=0&&ss[i-1]!=0&&ss[i-2]!=0&&ss[i-3]!=0&&ss[i-4]!=0){
                ss[i]--;
                ss[i-1]--;
                ss[i-2]--;
                ss[i-3]--;
                ss[i-4]--;
                for (int j=ss.length-1;j>=5;j--){
                    if (ss[j]!=0&&ss[j-1]!=0&&ss[j-2]!=0&&ss[j-3]!=0&&ss[j-4]!=0){
                        ss[j]--;
                        ss[j-1]--;
                        ss[j-2]--;
                        ss[j-3]--;
                        ss[j-4]--;
                        for (int c =ss.length-1;c>=3;c--){
                            if (ss[c]!=0&&ss[c-1]!=0&&ss[c-2]!=0){
                                return 12;
                            }
                        }
                    }

                }
            }
        }



        //三同花 三墩水都是同一种花色牌，也可以是杂花
        // 5 5 3  10 3  8 5
        r =0;
        t = 0;
        b=0;
        int y=0;
        int u =0;
        for (int i=1;i<color.length;i++){
            if (color[i]==0)
                r++;
        }
        if (r==1){
            for (int i=1;i<color.length;i++){
                if (color[i]==5)
                    t++;
                else if (color[i]==3)
                    b++;
            }
            if (t==2&&b==1)
                return 13;
        }
        else if (r==2){
            for (int i=1;i<color.length;i++){
                if (color[i]==10)
                    t++;
                if (color[i]==3)
                    b++;
                if (color[i]==8)
                    y++;
                if (color[i]==5)
                    u++;
            }
            if (t==1&&b==1)
                return 13;
            if (y==1&&u==1)
                return 13;
        }
        return 0;
    }

    int findmax(int card[],int number[],int color[]){
        if (JudgeTonghuashun(card)!=0)
            return 10;
        else if (Judgezhadan(number)!=0)
            return 9;
        else if (JudgeHulu(number)!="")
            return 8;
        else if (JudgeTonghua(color,card)!="")
            return 7;
        else if (JudgeShunzi(number)!=0)
            return 6;
        else if (JudgeSantiao(number)!=0)
            return 5;
        else if (JudgeLink(number)!=0)
            return 4;
        else if (JudgeTwoCouple(number)!="")
            return 3;
        else if (JudgeCouple(number)!=0)
            return 2;
        return 1;//杂牌
    }
    //将数组变成适合输出的字符串
    String[] Resultout(int card[]){
        String s[];
        s = new String[3];
        s[0]="";s[1]="";s[2]="";
        for (int i=0;i<card.length;i++){
            String a;
            int t,m=0;
            t = card[i]/100;
            card[i]=card[i]%100;
            if (i<=4)
                m=0;
            else if (i>=5&&i<=9)
                m=1;
            else if (i>9)
                m=2;
            if (t==1)
                s[m]=s[m]+"$";
            else if (t==2)
                s[m]=s[m]+"&";
            else if (t==3)
                s[m]=s[m]+"*";
            else if (t==4)
                s[m]=s[m]+"#";
            if (card[i]==11)
                s[m]=s[m]+"J";
            else if (card[i]==12)
                s[m]=s[m]+"Q";
            else if (card[i]==13)
                s[m]=s[m]+"K";
            else if (card[i]==14)
                s[m]=s[m]+"A";
            else
                s[m] = s[m]+card[i];
            if (i==4||i==9||i==12)
                s[m]=s[m];
            else s[m]=s[m]+" ";
        }
        return s;
    }

}

