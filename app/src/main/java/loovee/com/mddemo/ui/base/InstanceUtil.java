package loovee.com.mddemo.ui.base;

import java.lang.reflect.ParameterizedType;

/**
 * Created by loovee on 2017/4/19.
 */

public class InstanceUtil {

    public static <T> T getInstance(Object obj, int index){
        if(obj.getClass().getGenericSuperclass() instanceof ParameterizedType){
            Class<T> clazz = (Class<T>) ((ParameterizedType) obj.getClass().getGenericSuperclass()).getActualTypeArguments()[index];
            return getInstance(clazz);
        }
        return null;
    }

    public static <T> T getInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
