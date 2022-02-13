# selfish allele
class gene_S extends gene{ 

 
    gene_S(){ 
        s = 0.06;
    }
 
    public double fitness(){ 
        return 1+s;
    }
 
    public gene mutation(){ 
        if (Math.random()<m){
            return (new gene_A());
       } else return this;
    }
 
} 
 
