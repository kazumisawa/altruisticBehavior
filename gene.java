import java.lang.*; 
 
class gene{ 
 
    double s; 
    double m;
 
    gene(){ 
        s=0;
        m=0.001;
    }

 
    public double fitness(){ 
        return 1;
    }
 
    public gene mutation(){ 
        return this;
    }
 
} 
 
