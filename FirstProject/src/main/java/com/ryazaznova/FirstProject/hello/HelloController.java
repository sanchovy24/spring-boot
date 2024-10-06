package com.ryazaznova.FirstProject.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController

public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World")
                        String name) {
        return String.format("Hello %s!", name);
    }
    private List<String> arrayList = new ArrayList<>();
    private Map<Integer, String> hashMap = new HashMap<>();
    private int mapKeyCounter = 0;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        if (arrayList.isEmpty()) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(s);
        return "Добавление элемента в ArrayList "+ s;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        if (hashMap.isEmpty()) {
            hashMap = new HashMap<>();
        }
        hashMap.put(mapKeyCounter++, s);
        return "Добавление элемента в HashMap "+s;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListSize = arrayList.size();
        int hashMapSize = hashMap.size();
        return "В ArrayList " + arrayListSize + " элементов/(-а)." + "\nВ HashMap " +
                hashMapSize + " элементов/(-а)";
    }

}
