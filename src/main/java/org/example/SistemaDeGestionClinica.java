package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import java.io.IOException;

public class SistemaDeGestionClinica extends Application {
    private static Scene scene;
    public static Graph<Object, DefaultEdge> BD = new SimpleGraph<>(DefaultEdge.class);
    public static Object usuario = new Object();


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Ingreso"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SistemaDeGestionClinica.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        /** OBJETOS POR DEFECTO.**/
        //Coordinador.
        CoordinadorDeClinica coordinador = new CoordinadorDeClinica("12345678","Coordinador@gmail.com","coordinador");
        BD.addVertex(coordinador);

        //Clinica.
        Clinica clinica1 = new Clinica(1, "Nuestra Señora Del Sagrado Corazón", "Cra.50 #62-63", 123456);
        Clinica clinica2 = new Clinica(2, "Clínica psicológica de Antioquia", "Cl. 47 #80-24", 889034);
        Clinica clinica3 = new Clinica(3, "REMY IPS", "Cra. 50A #59-56", 1011121);
        Clinica clinica4 = new Clinica(4, "Clinica Sagrado Corazón", "Cra.50 #62-63", 123456);


        //Paciente.
        Paciente paciente1 = new Paciente("1000194793","Ximena","Castañeda Ochoa","Ximena@gmail.com","123","Cra. 45 #72-56",19,"05/10/2001","7865744","Carlos Lopez","2631551");
        Paciente paciente2 = new Paciente("1008194713","Felipe","Quintero Cano","Felipe@gmail.com","456","Cl. 78 #86-40",25,"14/03/1995","3193274553","Sofia Velez","4181376");
        Paciente paciente3 = new Paciente("1078694724","Juan Felipe","Rojas Calderon","Juan@gmail.com","789","Cra. 77A #50-30",25,"05/10/1995","5809296","Camila Aguirre","3931851");


        //Psiquiatra.
        Psiquiatra Psiquiatra1 = new Psiquiatra("1017252071","Andrés Felipe","García Revuelta","Andres@gmail.com","147","Masculino","Cl. 80 #54-20",23,"07/01/1993",8790344);
        Psiquiatra Psiquiatra2 = new Psiquiatra("1036688091","Innis Dapney","Salazar García","Innis@gmail.com","258","Femenino","Cra. 46 #35-14",22,"12/10/1998",4410349);
        Psiquiatra Psiquiatra3 = new Psiquiatra("1152472574","Valentina ","Sabogal Serrano","Valentina@gmail.com","369","Femenino","Cl. 69 #86-55",23,"25/07/1993",44208674);
        Psiquiatra Psiquiatra4 = new Psiquiatra("946145641","Felipe","García Revuelta","Felipe@gmail.com","777","Masculino","Cl. 80 #54-20",23,"10/01/1993",8797536);

        //Relaciones.
        BD.addEdge(coordinador, clinica1);
        BD.addEdge(coordinador, clinica2);
        BD.addEdge(coordinador, clinica3);
        BD.addEdge(coordinador,clinica4);
        BD.addEdge(clinica1,Psiquiatra1);
        BD.addEdge(clinica2,Psiquiatra2);
        BD.addEdge(clinica3,Psiquiatra3);
        BD.addEdge(clinica1,Psiquiatra4);
        BD.addEdge(Psiquiatra1,paciente1);
        BD.addEdge(Psiquiatra2,paciente2);
        BD.addEdge(Psiquiatra3,paciente3);

        //Recorrer nodos adyacentes.
        //Se utiliza el identificador para discriminar el tipo de los nodos adyacentes que quiero mostrar.
        /* for (Object nodo : Graphs.neighborListOf(BD, buscado)){
            if(identificador(nodo,"clinica")){
                //Para acceder a los atributos propios de la clase se debe parsear.
                Clinica clinica = (Clinica) nodo;
                System.out.println(clinica);
            }
       }*/

        /* for(Object obj : BD.vertexSet()){
            if(identificador(obj,"historial clinico")){
                //Para acceder a los atributos propios de la clase se debe parsear.
                HistorialClinico historialClinico = (HistorialClinico) obj;
                //BD.removeVertex(historialClinico);
                System.out.println(historialClinico);
            }
        }*/

        //Ver vértices y aristas.
       /* for(Object obj : BD.vertexSet()){
            System.out.println(obj);
        }
        for(DefaultEdge arista : BD.edgeSet()){
            System.out.println(arista);
        }*/

       launch();

    }

    /**IDENTIFICADOR DE OBJETOS**/
    public static boolean identificador(Object obj, String TipoObjeto) {
        if(TipoObjeto.toLowerCase().equals("coordinador")){
            return obj instanceof  CoordinadorDeClinica;
        }else if(TipoObjeto.toLowerCase().equals("clinica")){
            return obj instanceof Clinica;
        }else if(TipoObjeto.toLowerCase().equals("paciente")){
            return obj instanceof Paciente;
        }else if(TipoObjeto.toLowerCase().equals("psiquiatra")){
            return obj instanceof Psiquiatra;
        }else{
            return false;
        }
    }

}
