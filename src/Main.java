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

        try{
            String string2;
            while((string2 = bufferedReader.readLine())!= null){
                String[] productos = string2.replace("|", ",").split(",");
                String category = productos[0].trim().toUpperCase();
                String productoString = productos[1].trim();

                try{
                    if(inventario.get(category) != null){
                        List<String> lista_actual = inventario.get(category);
                        lista_actual.add(productoString);
                        inventario.put(category, lista_actual);
                    }else{
                        List<String> nueva_lista = new ArrayList<>();
                        nueva_lista.add(productoString);
                        inventario.put(category, nueva_lista);
                        categorias.add(category);
                    }

                }catch (Exception e){}

            }
        }catch (Exception e){
            show("ocurrió un error. ");
        }

    }

    public void ejecutarPrograma(){
        boolean flag = true;

        while (flag){
            show("Bienvenido a la tienda!");
            show("1. Agregar productos a la coleccion");
            show("2. Mostrar categorias de productos");
            show("3. Mostrar colecciones del usuario");
            show("4. Mostrar colecciones del usuario ordenados por categoría");
            show("5. Mostrar inventario");
            show("6. Mostrar inventario");
            show("7. Salir");
            Integer option_Ejecutar_Programa = scanner2.nextInt();
            switch (option_Ejecutar_Programa){
                case 1:
                    // FALTAN COSAS AAAAAAAAAAAAAAA
            }



        }
    }


    public void addProdutoColeccion(){
        boolean flag2 = true;
        while (flag2){
            show("Agregar productos a la coleccion");
            show("Ingrese el nombre de una categoría: ");
            show("ingresa salir para salir");
            String opcion_categoria = scanner.nextLine();

            if(opcion_categoria.equals("salir")){
                flag2 = false;
                break;
            }else{
                List<String> opcion_productos = inventario.get(opcion_categoria);
                if (opcion_productos == null){
                    show("La categoría no existe");
                }else{
                    for(int i = 0; i<opcion_productos.size();i++){
                        show((i+1)+". "+ opcion_productos.get(i));
                    }

                show("Ingrese el número de productos");
                int index_productos = scanner2.nextInt();
                index_productos = index_productos - 1;

                if(index_productos > opcion_productos.size() || index_productos < 1){
                    show("no existe este producto. ");
                }else{
                    if(coleccion.get(opcion_categoria) != null){
                        List<String> nueva_categoria = coleccion.get(opcion_categoria);
                        nueva_categoria.add(opcion_productos.get(index_productos));
                        coleccion.put(opcion_categoria, nueva_categoria);
                    }else{
                        List<String> nueva_lista = new ArrayList<>();
                        nueva_lista.add(opcion_productos.get(index_productos));
                        coleccion.put(opcion_categoria, nueva_lista);
                    }

                show("OK. Producto agregado exitosamente");

                }

                }
            }
        }
    }

    public void mostrarMapa(Imaps<String, List<String>> lista_temporal, Boolean iS){
        if(iS){
            Collections.sort(categorias);
        }

        for(int i = 0; i<categorias.size(); i++){
            List<String> opcion_productos = lista_temporal.get(categorias.get(i));
            if (opcion_productos != null){
                show(""+ categorias.get(i));

                for(int n = 0; n < opcion_productos.size(); n++) {
                    show("" + opcion_productos.get(n) + " 1");
                }
            }
        }

    }








    public void show(String string){
        System.out.println(string);
    }
}
