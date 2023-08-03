import java.util.HashMap;
import java.util.Map;

public class AboutMaps {
    public void aboutMaps()
    {
        Map<Integer,String> map = new HashMap<>(); 
        // Map is an interface or contract and HashMap is an implementation of this Interface
        map.put(1, "Ali");
        map.put(2, "Ahmed"); // {1=Ali, 2=Ahmed, 3=Ali Ahmed}
        map.put(3, "Ali Ahmed");
        // what if we inset key value pair but key already exists
        map.put(3, "Mosh"); // prev value will overide with new value {1=Ali, 2=Ahmed, 3=Mosh}
        // what about null values
        map.put(4, null); // perfectly fine {1=Ali, 2=Ahmed, 3=Mosh, 4=null}
        // what about null keys
        map.put(null, null); //perfectly fine as well {null=null, 1=Ali, 2=Ahmed, 3=Mosh, 4=null}

        map.remove(null); // {1=Ali, 2=Ahmed, 3=Mosh, 4=null}
        // we can also get the value of the key
        var value = map.get(1);
        System.out.println(value); // Ali
        // Check the existance the of key and value
        map.containsKey(4); // O(1)
        map.containsValue("Mosh"); // o(n)
        // Iterate over HashMap
        for (var item : map.keySet())// keyset return list of keys
            System.out.println(map.get(item));// 1,2,3,4
        for (var item : map.entrySet()) // keyset return list of key value pair
            System.out.println(item);// 1=Ali 2=Ahmed 3=Mosh 4=null

        System.out.println(map);
    }
}
