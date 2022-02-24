package Item3;

import java.lang.reflect.AccessibleObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class SingletonObjectTest
{
    private static final Logger logger = Logger.getLogger(SingletonObjectTest.class.getName());

    public static void main(String[] args) throws NoSuchMethodException
    {

        //createdSingletonClassWithStaticFactoryMethod();

    }

    private static void createdSingletonClassWithStaticFactoryMethod() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException
    {

        Constructor<DBConnectorPrivate> privateConstructorMethod = DBConnectorPrivate.class.getDeclaredConstructor(String.class, String.class, String.class);
        
        AccessibleObject.setAccessible(new AccessibleObject[]{privateConstructorMethod}, true);


        DBConnectorPrivate dbConnectorPrivate = privateConstructorMethod.newInstance();
        
        //dbConnectorPrivate = new DBConnectorPrivate();

        

        DBConnector dbConnector = DBConnector.getInstance("github.com", "emreyildirim53","****");
        logger.info(dbConnector.toString());
                
                
        dbConnector = DBConnector.getInstance("sahibinden.com", "emre.yildirim","****");
        logger.info(dbConnector.toString());
    }
}
