package UL;

import java.util.HashMap;
import java.util.Map;

public class HashMapsPractice {
    static void main() {
        Map map = new HashMap();
        String str = "Hello, my name is Alex and I'm coding";
        System.out.println(str.toCharArray());

        for (char x : str.toLowerCase().toCharArray()) {
            if (map.containsKey(x)) {
                int old = (int) map.get(x);
                map.put(x,old+1);
            } else {
                map.put(x, 1);
            }
        }
        System.out.println(map);
    }
}
