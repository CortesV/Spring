package com.devcortes.springbuilder;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = Application.run("com.devcortes.springbuilder", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        applicationContext.getObject(CoronaDesinfector.class).start(new Room());
    }
}
