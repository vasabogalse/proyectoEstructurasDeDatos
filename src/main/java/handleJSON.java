import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.WStringValueHelper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public interface handleJSON<T> {
    default String writeJSON(T o1, String jsonFile){
        String jsonInString = "";
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // serialization of received object
            jsonInString = mapper.writeValueAsString(o1);

            // write object to JSON file (serialization)
            Path path = Paths.get(".", "src", "main","resources", jsonFile + ".json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), o1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonInString;
    }

    default ArrayList<T> readJSON(String jsonFile){
        ArrayList<T> objs = null;
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of books
            Path path = Paths.get(".", "src", "main","resources", jsonFile + ".json");
            ArrayList<T> myObjects = mapper.readValue(path.toFile(), new TypeReference<ArrayList<T>>(){});
            System.out.println(myObjects.toString());

            myObjects.forEach(obj -> System.out.println(obj.getClass().getName()));
            objs = myObjects;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objs;
    }
}

