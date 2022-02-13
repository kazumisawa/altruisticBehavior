# altruistic allele
class gene_A extends gene{ 
 
    public gene_A(){ 
    }
 
    public gene mutation(){ 
        if (Math.random()<m){
            return (new gene_S());
       } else return this;
    }
 
} 
 
