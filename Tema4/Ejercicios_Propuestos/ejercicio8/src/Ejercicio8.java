public class Ejercicio8 {

    public static void main(String[] args) {
        char rnd = randomLetter();
        
        System.out.println("El caracter '" + rnd + "' es vocal?");
        System.out.println(isVocal(rnd)?"Sí.":"No.");
    }
    
    public static char randomLetter(){
        String alfa = "ABCÇDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int rnd = (int)(Math.random()*(alfa.length()-1));
        char out = alfa.charAt(rnd);
        
        rnd = (int)(Math.random()*2);
        if(rnd%2 == 0) out=Character.toLowerCase(out);
        
        return out;
    }
    
    public static boolean isVocal(char c){
        switch(Character.toLowerCase(c)){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
    
}
