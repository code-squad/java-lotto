package enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hoon on 2018. 1. 17..
 */
public enum Menu {
    ZERO(0, 0, 0),
    ONE(1, 0, 0),
    TWO(2, 0, 0),
    THREE(3, 0, 5000),
    FOUR(4, 0, 50000),
    FIVE(5, 0, 1500000),
    SIX(6, 0, 2000000000);

    private Integer number;
    private Integer hits;
    private Integer money;

    Menu(Integer number, Integer hits, Integer money) {
        this.number = number;
        this.hits = hits;
        this.money = money;
    }

    private static Map<Integer, Menu> MENUS =
            Arrays.stream(Menu.values())
            .collect(Collectors.toMap(o -> o.number, o -> o));

    public static Integer findMenu(Integer key) {
        return MENUS.get(key).hits;
    }

    public static Menu renewHits(Integer key) {
        Menu menu = MENUS.get(key);
        menu.hits++;
        MENUS.put(key, menu);
        return menu;
    }

    public static void clear() {
        MENUS.clear();
    }

    public static Integer getWinningMoney() {
        return MENUS.values().stream()
                .filter(menu -> menu.number >= 3)
                .mapToInt(value -> value.hits * value.money).sum();
    }

}
