package ejercicio11;
import java.util.Map;
import java.util.HashMap;


public class Euro {
    private Map<String,Integer> billetes = new HashMap();
    private Map<String,Integer> monedas = new HashMap();
    
    Euro(){
        billetes.put("b500", 0);
        billetes.put("b200", 0);
        billetes.put("b100", 0);
        billetes.put("b50", 0);
        billetes.put("b20", 0);
        billetes.put("b10", 0);
        billetes.put("b5", 0);
        
        monedas.put("m2",0);
        monedas.put("m1",0);
        monedas.put("m05",0);
        monedas.put("m02",0);
        monedas.put("m01",0);
        monedas.put("m005",0);
        monedas.put("m002",0);
        monedas.put("m001",0);
        
    }
    
    public void insertarDinero(double d){
        
    }

}
