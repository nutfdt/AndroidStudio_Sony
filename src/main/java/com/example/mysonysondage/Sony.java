package com.example.mysonysondage;

import java.util.HashMap;

public class Sony {

    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();

    public static void initialiser() {
        Sony.lesEnquetes.put("Enquete12", new Enquete());
    }

    public static Enquete getEnquete(String idE) {

        return Sony.lesEnquetes.get(idE);
    }

}
