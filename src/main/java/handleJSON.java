import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.util.ArrayList;

public interface handleJSON<T> {
    default String writeJSON(T o1, String jsonFile){
        String jsonInString = "";
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            jsonInString = mapper.writeValueAsString(o1);

            // write object to JSON String
            mapper.writeValue(Paths.get(".", "src", "main","resources", jsonFile + ".json").toFile(), o1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonInString;
    }
}

