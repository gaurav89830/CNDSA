package SeparateChaining;

public class MapUseMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();

        for (int i = 0; i < 50; i++) {
            map.insert("Key" + i, i + 1);
            System.out.println("key" + i + " :" + i + 1 + " LF : " + map.loadFactor());

        }

    }
}
