class group{ 
    gene[] current_generation;
    public int size;
 
    public static void main(String[] args){ 
        group G1 = new group(100);
        for(int i=1;i<1000;i++){
            G1.selection();
            G1.mutation();
            System.out.print(i);
            System.out.print(",");
            System.out.print(G1.frequency());
            System.out.println();
        }
    }
 
    public group(int pop_size){ 
        size = pop_size;
        current_generation = new gene[size];
        for(int i=0;i<size;i++) current_generation[i] = new gene_A();
    }
 
    public group(group old){ 
        size = old.size;
        current_generation = new gene[size];
        int S=old.num();
        for(int i=0;i<S;i++) current_generation[i] = new gene_S();
        for(int i=S;i<size;i++) current_generation[i] = new gene_A();
    }
 
    public void selection(){ 
        gene[] last_generation = current_generation;
        double[] fitness = new double[size];
        for(int i=0;i<size;i++) fitness[i] = last_generation[i].fitness();
        gene[] next_generation = new gene[size];
        for(int i=0;i<size;i++){
            int parent_no = disrand.value(fitness);
            next_generation[i] = last_generation[parent_no];
        }
        current_generation = next_generation;
    }

 
    public void immigration(double mig_rate, double p0){ 
        gene immigrant;
        for(int i=0;i<size;i++) {
            if (Math.random()<=mig_rate){
                if (Math.random()<=p0){
                    immigrant = new gene_S();
                }else{
                    immigrant = new gene_A();
                }
                current_generation[i] = immigrant;
            }
        }
    }

 
    public void mutation(){ 
        gene[] last_generation = current_generation;
        for(int i=0;i<size;i++) current_generation[i] = last_generation[i].mutation();
    }

 
    public double fitness(){ 
        return 1 + 0.4*frequency();
    }
 
    public int num(){ 
        int count =0;
        for(int i=0;i<size;i++){
            if (current_generation[i] instanceof gene_S) count++;
        }
        return count;
    }
 
    public double frequency(){ 
        return (num()+0.0)/(size+0.0);
    }
 
} 
 
