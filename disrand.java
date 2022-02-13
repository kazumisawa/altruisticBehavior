import java.lang.*; 
 
class disrand{ 
    public static int value(double xlist[]){
    //  this function will be called many times
    //  probability of distrand()==n is x[n]
        int num,i,len;
        double all,x,tmp;
        len = xlist.length;
        all=0;
        for(i=0;i<len;i++) all += xlist[i];
        x = Math.random() * all;
        num=0; tmp=0;
        for(i=0;i<len;i++){
            tmp+=xlist[i];
            if (x>tmp) num++;
        }
	 return( num );
    }
}
 
