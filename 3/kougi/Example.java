public class Example{
    public static void main(String[] args) {
        int x,y,z,k=0,i,ksum,not;
        int[] isum = new int[106];
        for(x=0; x<=4; x++){
            for(y=0; y<=6; y++){
                for(z=0; z<=2; z++){
                    ksum=10*x+100*y+500*z;
                    /* check if previous sum equals to ksum */
                    not=0;
                    for(i=1; i<=k; i++){
                        if(isum[i] == ksum) not=1;
                    }
                    if(not == 0){
                        k+=1; isum[k]=ksum;
                         System.out.println("k = " + k + ", ksum= " + ksum + ", x = " + x + ", y = " + y + ", z = " + z); 
                    }else{
                        System.out.println("not k= " + k + ", x = " + x + ", y = " + y + ", z = " + z);
                    }
                }
            }
        }
        System.out.println("k= " + k);
        for (int num : isum) {
            System.out.println(num);
        }
    }
}
