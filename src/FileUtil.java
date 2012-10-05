import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class FileUtil {

    public final static String PROPSFILE = "/home/patito/libjava/bot.properties";
    private static Properties props;
    
    static{
    	props = new Properties();
    	try {
			props.load(new FileInputStream(new File(PROPSFILE)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public static String getProperty(String key) throws FileNotFoundException, IOException
    {
        return props.getProperty(key);
    }
    
}
