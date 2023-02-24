package cn.ChengZhiYa.YZFCore;

import org.bukkit.Location;

import java.util.HashMap;

public class Location_HashMap {
    static HashMap<String, Location> Temp = new HashMap<>();

    public static void set(String HashMapName,Location Value) {
        Temp.put(HashMapName,Value);
    }

    public static Location get(String HashMapName) {
        return Temp.get(HashMapName);
    }

    public static void remove(String HashMapName) {
        Temp.remove(HashMapName);
    }

    public static void clear() {
        Temp.clear();
    }
}
