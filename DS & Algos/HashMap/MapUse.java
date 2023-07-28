import java.util.HashMap;
public class MapUse{
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        map.put("Red Pens", 10);
        map.put("blue pens", 1);
        map.put("Green Pens", 5);

        for(String str : map.keySet()){
            System.out.println(str);
        }
        System.out.println(map.containsKey("blue pens"));
        map.remove("blue pens");
        System.out.println(map.containsKey("blue pens"));


    }
}