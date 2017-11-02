package com.javaQuickstart;

import static java.lang.String.format;

public class CompliationStatictypingDataStructures {

    public static void main(String[] args) {
        Dog fido = new Dog("Fido", 3);

        System.out.println(format("%s says %s", fido.getName(), fido.makeNoise()));
    }
}
