package danilo.laks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChUd0 on 18.07.2018.
 */
public class TempClass {
    public static void main(String[] args) {
        Map<String, Object> m = new HashMap();
        m.put("key", "value");
        m.put("key1", "value1");
        System.out.println(m.toString());
    }
}
