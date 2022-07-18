/*
 * Reto #28
 * MÁQUINA EXPENDEDORA
 * Fecha publicación enunciado: 11/07/22
 * Fecha publicación resolución: 18/07/22
 * Dificultad: MEDIA
 *
 * Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección del producto.
 * - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
 *   número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
 *   y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 */

package folder;
import java.util.ArrayList;
import java.util.Arrays;

public class Reto28 {
    
    public static void main(String[] args){
        System.out.println(purchaseItem(30, Coins.TWO_HUNDRED, Coins.TWO_HUNDRED));
        System.out.println(purchaseItem(21, Coins.FIVE));
        System.out.println(purchaseItem(32, Coins.FIFTY));
        System.out.println(purchaseItem(33, Coins.TWO_HUNDRED, Coins.FIVE, Coins.TEN));
        System.out.println(purchaseItem(31, Coins.TWO_HUNDRED, Coins.TEN));
    }
    
    /*
    Resultados:
     Su cambio es 235 y compró COCA. ([TWO_HUNDRED, TEN, TEN, TEN, FIVE])
     No se encontro el codigo del producto
     El dinero ingresado no es suficiente. Coste: 120, ingresó 50
     Su cambio es 0 y compró JUGO. ([])
     Su cambio es 25 y compró LIMONADA. ([TEN, TEN, FIVE])
    */
    
    private static MachineProduct purchaseItem(int code, Coins...coins){
        Items[] items = {Items.AGUA, Items.COCA, Items.LIMONADA, Items.JUGO};
        Items selectedItem = null;
        for(int i = 0; i < items.length; i++){
            if(items[i].code == code){
                selectedItem = items[i];
                break;
            }
        }
        if(selectedItem == null) return new MachineProduct("No se encontro el codigo del producto");
        int money = getCount(coins);
        if(money < selectedItem.price) return new MachineProduct("El dinero ingresado no es suficiente. Coste: " + selectedItem.price + ", ingresó " + money);
        money -= selectedItem.price;
        return new MachineProduct(getChange(money), selectedItem);
    }
    
    private static Coins[] getChange(int change){
        Coins[] coins = {Coins.TWO_HUNDRED, Coins.ONE_HUNDRED, Coins.FIFTY, Coins.TEN, Coins.FIVE};
        int currentCoin = Coins.TWO_HUNDRED.value;
        ArrayList<Coins> list = new ArrayList<>();
        int i = 0;
        while(change > 1){
            if(change < currentCoin) {
                currentCoin = coins[i].value;
                if(i != coins.length -1) i++;
            }
            else {
               change -= currentCoin;
               list.add(getValue(currentCoin));
            }
        }
        return list.toArray(new Coins[list.size()]);
    }
    
    private static Coins getValue(int value){
        Coins[] coins = {Coins.TWO_HUNDRED, Coins.ONE_HUNDRED, Coins.FIFTY, Coins.TEN, Coins.FIVE};
        for(int i = 0; i < coins.length; i++){
            if(coins[i].value == value) return coins[i];
        }
        return null;
    }
    
    public static int getCount(Coins...coins){
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            count += coins[i].value;
        }
        return count;
    }
    
}

enum Coins{
    FIVE(5), TEN(10), FIFTY(50), ONE_HUNDRED(100), TWO_HUNDRED(200);

    public int value;

    private Coins(int coins){
        value = coins;
    }
}

enum Items{
    COCA(30, 165), LIMONADA(31, 185), AGUA(32, 120), JUGO(33, 215);

    public int code, price;

    private Items(int code, int price){
        this.code = code;
        this.price = price;
    }
}

class MachineProduct {
    private Coins[] changeInCoins;
    private int change;
    private Items item;
    private String error;

    public MachineProduct(Coins[] change, Items item){
        this.change = Reto28.getCount(change);
        this.item = item;
        this.changeInCoins = change;
    }

    public MachineProduct(String error){
        this.error = error;
    }

    @Override
    public String toString() {
        String msg = "Su cambio es " + change + " y compró " + item + ". (" + Arrays.toString(changeInCoins) + ")";
        return error != null ? error : msg;
    }
}
