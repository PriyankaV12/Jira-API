import gettersSetters.fileReader;
import gettersSetters.getterSetter;

public class baseTest extends fileReader {


    public getterSetter values = dataYamlReader();
    public getterSetter secrets = secretYamlReader();


    public baseTest() throws Exception {


    }


}
