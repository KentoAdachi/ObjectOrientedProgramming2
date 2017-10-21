/*
オブジェクト指向プログラミングII
第3回課題
BP16001 足立賢人
2017/10/16

*/
public class Example2{


    static int[] isum = new int[106];
    static int k = 0;

    //組み合わせで生成された金額がすでに存在する金額かを調べるメソッド
    static boolean isContain(int money,int k){
        boolean ret = false;
        for (int i = 0; i < k; i++) {
            if (money == isum[i]) {
                ret = true;
            }
        }
        return ret;
    }

    static void calculate(){
        int x,y,z,i,ksum,not;

        for(x=0; x<=4; x++){
            for(y=0; y<=6; y++){
                for(z=0; z<=2; z++){
                    ksum=10*x+100*y+500*z;
                    /* check if previous sum equals to ksum */
                    if (isContain(ksum,k) == false) {
                        k+=1; isum[k]=ksum;
                        // System.out.println("k = " + k + ", ksum= " + ksum + ", x = " + x + ", y = " + y + ", z = " + z);
                    }else{
                        // System.out.println("not k= " + k + ", x = " + x + ", y = " + y + ", z = " + z);
                    }

                }
            }
        }



    }
    static void display(){
        for (int i = 1; i <= k; i++) {
            System.out.println(i+" : "+isum[i]);
        }
        System.out.println("金額の種類は"+k+"通り");
    }

    //以下は変更不可能
    public static void main(String[] args) {
        calculate();
        display();
    }
}
