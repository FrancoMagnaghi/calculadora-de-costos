package primerintentocostos;

import java.util.ArrayList;
import primerintentocostos.gui.Ventana;
import primerintentocostos.logica.Material;


public class PrimerIntentoCostos {

    public static void main(String[] args) {
        Material bnOracal100 = new Material();
        bnOracal100.setNombre("Negro/Blanco Oracal 100");
        bnOracal100.setPrecio(5100);
        
        Material doMcCal = new Material();
        doMcCal.setNombre("Dorado Metalizado McCal");
        doMcCal.setPrecio(6500);
        
        Material torna = new Material();
        torna.setNombre("Tornasolado");
        torna.setPrecio(4500);
        
        Material otro = new Material();
        otro.setNombre("Otro");
        otro.setPrecio(0);
        
        Material transferUnical = new Material();
        transferUnical.setNombre("Transfer Unical");
        transferUnical.setPrecio(17000);
        
        Material transferAdere = new Material();
        transferAdere.setNombre("Transfer ADERE");
        transferAdere.setPrecio(35000);
        
        ArrayList<Material> materiales = new ArrayList<>();
        materiales.add(bnOracal100);
        materiales.add(doMcCal);
        materiales.add(torna);
        materiales.add(otro);
        materiales.add(transferUnical);
        materiales.add(transferAdere);
        
        Ventana frame = new Ventana(materiales);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
}
