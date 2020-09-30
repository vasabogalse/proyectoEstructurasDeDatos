//librerias de java para manejo de archivos
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Paths; //Otra libreria de java para archivos
import java.nio.file.FileSystems;
import java.nio.file.Path;

//Librerias de json-simple
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//librerias de Jackson
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WriteJSON {

    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);

        //Write JSON file
        String localDir = System.getProperty("user.dir");
        File dir = new File(localDir + "/src/main/resources");
        try (FileWriter file = new FileWriter(new File(dir, "employees.json"))) {

            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Manera de generar un archivo json son Jackson
        try {
            // create a map to populate the info
            Map<String, Object> map = new HashMap<>();
            map.put("name", "John Deo");
            map.put("email", "john.doe@example.com");
            map.put("roles", new String[]{"Member", "Admin"});
            map.put("admin", true);

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert map to JSON file
            //Cada vez que necesite crear un objeto JSON hago varias veces lo de writeValue
            mapper.writeValue(Paths.get(".", "src", "main","resources", "user.json").toFile(), map);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

