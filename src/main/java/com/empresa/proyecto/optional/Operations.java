package com.empresa.proyecto.optional;

import java.util.Optional;

public class Operations {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Value");

        //map()
        Optional<String> map = optional.map(val -> "Replaced");
        System.out.println(map.get());

        //filter()
        Optional<String> filter = optional.filter(val -> val.equalsIgnoreCase("Value"));
        System.out.println(filter.get());

        //flatMap
        Optional<String> flatMap = optional.flatMap(val -> Optional.of("Replaced"));
        System.out.println(flatMap.get());
    }
}
