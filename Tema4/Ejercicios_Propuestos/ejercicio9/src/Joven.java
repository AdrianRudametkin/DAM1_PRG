public class Joven {
    private int edad, nivel_de_estudios, ingresos;
    
    Joven(int e, int nde, int i){
        this.edad = e;
        this.nivel_de_estudios = nde;
        this.ingresos = i;
        
    }
    
    public boolean jasp(){
        if((edad<=28 && nivel_de_estudios > 3) || (edad<30 && ingresos>28000)) return true;
        else return false;
    }
}
