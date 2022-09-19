public class ChineseAstrology {
    public static final String[] MATERIALS = {"madera", "fuego", "tierra", "metal", "agua"};
    public static final String[] ANIMALS = {"rata", "buey", "tigre", "conejo", "dragón", "serpiente", "caballo", "oveja", "mono", "gallo", "perro", "cerdo"};
    public static final int CYCLE_LEN = 60;
    
    // Esta solución solo tiene en cuenta a los años mayores o iguales que 4
    public String sexagenaryCycle(int year) {
        int yearIndex = Math.abs(year - 4) % CYCLE_LEN;
        int materialIndex = yearIndex % 10 / 2;
        int animalIndex = yearIndex % ANIMALS.length;
        return MATERIALS[materialIndex] + " " + ANIMALS[animalIndex];
    }
    
    public static void main(String args[]) {
        ChineseAstrology obj = new ChineseAstrology();
        System.out.println(obj.sexagenaryCycle(1984));
        /*for (Integer i = 1924; i <= 2022; i++) {
            System.out.println(i.toString() + ": " + obj.sexagenaryCycle(i));   
        }*/
    }
}