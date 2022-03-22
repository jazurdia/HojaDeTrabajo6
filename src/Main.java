import java.io.BufferedReader;
import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.File;



public class Main {

    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);

    String path = "./ListadoProducto.txt";
    File archivo = null;
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;

    MyFactoryMap factoryMap = new MyFactoryMap();
    Imaps<String, List<String>> coleccion;
    Imaps<String, List<String>> inventario;
    List<String> categorias = new ArrayList<String>();



    public static void main(String[] args){
    }


    public void factoryInstance(){
        show("Bienvenidos a la tienda online!");
        show("Escriba el MAP que deseé. Ponga atención a la ortografía");
        show("HashMap, LinkedHashMap, TreeMap");
        String opcionFactoryInstance = scanner2.next(); //ATENCION!!!!!

        try {
            coleccion = factoryMap.getMap(opcionFactoryInstance);
            inventario = factoryMap.getMap(opcionFactoryInstance);
        } catch ( Exception e) {
            show("My bad. Vuelve después. ");
        }
    }

    public void leer(){
        try{
            archivo = new File(path);
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e){
            show("No se encontró el archivo. Prueba de nuevo. ");
        }
    }



    public void show(String string){
        System.out.println(string);
    }
}
