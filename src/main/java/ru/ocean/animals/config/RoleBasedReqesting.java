package ru.ocean.animals.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleBasedReqesting {
    private static final Map<String, Long> map;

    static {
        map = new HashMap<>();
        map.put("ROLE_ADMIN",           11L); // Админ
        map.put("ROLE_IHTI",            1L); // Ихтиопатология
        map.put("ROLE_KORM",            2L); // Кормокухня
        map.put("ROLE_TROPIC_SEA",      6L); // Гидробионтов тропических морей
        map.put("ROLE_TROPIC_SOFT",     8L); // Пресноводных тропических гидробионтов
        map.put("ROLE_FAREAST_SEA",     7L); // Гидробионтов Дальневосточных рек и озёр
        map.put("ROLE_ADMINISTRATION",  3L); // Администрация
    }

    public static Map<String, Long> getMap() {
        return map;
    }

    public static Boolean isFull(List<String> roles) {
        for(String role : roles) {
            if(map.get(role) == 11L) return true;       // Админ
            else if(map.get(role) == 1L) return true;   // Ихтиопатология
            else if(map.get(role) == 3L) return true;   // Администрация
            else if(map.get(role) == 2L) return true;   // Кормокухня
        }
        return false;
    }

    public static Long getMainRole(List<String> roles) {
        for(String role : roles) {
            if(map.containsKey(role)) return map.get(role);
        }
        return 0L;
    }

}
