package gettersSetters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class fileReader extends getterSetter {

    public ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());


    public getterSetter dataYamlReader() throws Exception {
        File file = new File(  System.getProperty("user.dir") + "/src/main/java/data.yaml");
        getterSetter values=objectMapper.readValue(file,getterSetter.class);
        return values;
    }


    public getterSetter secretYamlReader() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/java/secrets.yaml");
        getterSetter secrets =objectMapper.readValue(file,getterSetter.class);
        return secrets;

    }
}


