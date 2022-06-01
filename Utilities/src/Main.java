public class Main {
    public static void main(String[] args){
        System.out.println(Utilities.randomInt(-10, 10));
        System.out.println(Utilities.randomDouble(0, 0.01));
        System.out.println(Utilities.formatDecimal(0.239231));

        double d;
        double max = Double.MIN_VALUE*10;
        System.out.println(max);
        System.out.println();
        do{
            d = Utilities.randomDouble(0,max);
            System.out.println(d);
        }while (d!=max);
    }
}
