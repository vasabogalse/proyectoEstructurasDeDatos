import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public interface handleJSON<T> {
    default String writeJSON(T o1, String jsonFile){
        String jsonInString = "";
        try {
            ObjectMapper mapper = new ObjectMapper(); // create object mapper instance
            jsonInString = mapper.writeValueAsString(o1); // serialization of received object
            Path path = Paths.get(".", "src", "main","resources", jsonFile + ".json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), o1); // write object to JSON file (serialization)
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonInString;
    }

    default ArrayList<T> readJSON(Class<T> className, String jsonFile){
        ArrayList<T> objs = null;
        try {
            ObjectMapper mapper = new ObjectMapper(); // create object mapper instance
            Path path = Paths.get(".", "src", "main","resources", jsonFile + ".json");
            ArrayList<T> myObjects = mapper.readValue(path.toFile(), mapper.getTypeFactory().constructCollectionType(ArrayList.class, className)); // overload readValue method
            //System.out.println(myObjects.toString());
            //System.out.println(myObjects.getClass().getName());
            //myObjects.forEach(obj -> System.out.println(obj.getClass().getName()));
            objs = myObjects;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objs;
    }
}

