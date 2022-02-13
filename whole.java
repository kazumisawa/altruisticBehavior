class whole{ 
    group[] current_generation;
    int size;
    static int gn=2001;
    static double tot;
    int k=0;
 
    public static void main(String[] args){ 
//number of groups
        whole P1 = new whole(100);
        for(int i=1;i<gn;i++){
            P1.selection();
            P1.mutation();
            P1.migration(0.0);
            P1.extinction();
            P1.output(i);
        }
    }
 
    public whole(int pop_size){ 
        size = pop_size;
        current_generation = new group[size];
//population size of a group
        for(int i=0;i<size;i++) current_generation[i] = new group(100);
    }
 
    public void extinction(){ 
        group[] last_generation = current_generation;
        double[] fitness = new double[size];
        for(int i=0;i<size;i++) fitness[i] = last_generation[i].fitness();
        group[] next_generation = new group[size];
        for(int i=0;i<size;i++){
            int parent_no = disrand.value(fitness);
            next_generation[i]  = new group( last_generation[parent_no] );
        }
        current_generation = next_generation;
    }

 
    public void mutation(){ 
        double p0=frequency();
        for(int i=0;i<size;i++) current_generation[i].mutation();
    }

 
    public void selection(){ 
        for(int i=0;i<size;i++) current_generation[i].selection();
    }

    public void migration(double mig_rate){ 
        double p0 = frequency();
        for(int i=0;i<size;i++) current_generation[i].immigration(mig_rate, p0);
    }
 
    public void output(int j){ 
//        if (j%10>0) return;
        System.out.print(j);
        double total = 0;
        double total2 = 0;
        double total1;
/*
        for(int i=0;i<size;i++){
            System.out.print(",");
            System.out.print(current_generation[i].frequency());
        }
*/
        for(int i=0;i<size;i++){
            double x;
           x = current_generation[i].frequency(); 
            total += x;
            total2 += x*x;
        }
        total /= size;
        total2 /= size;
        double sigma,v;
        v = (total2-total*total)*size/(size-1);
        sigma = Math.sqrt(v);
        total1=1.0-total;
         System.out.print(",");
         System.out.print(total1);
         System.out.print(",");
         System.out.print(sigma);
         System.out.print(",");
         System.out.print(v);
         System.out.println();
         k=k+1;
        if(k>999)tot=tot+total1;
        if(k==gn-1)System.out.println("av="+tot/(gn-1000));
    }
 
   public double frequency(){ 
        double total = 0;
        for(int i=0;i<size;i++) total += current_generation[i].frequency();
        return total/size;
    }

} 
 
