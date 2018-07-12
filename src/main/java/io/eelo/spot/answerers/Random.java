package io.eelo.spot.answerers;

import io.eelo.spot.data.Params;

import java.util.Arrays;

public class Random implements Answerer {

    private final java.util.Random random = new java.util.Random();

    @Override
    public String[] getKeyWorlds() {
        return new String[]{"random int", "random float", "random string", "random"};
    }

    @Override
    public boolean match(Params params) {
        return Arrays.asList(getKeyWorlds()).contains(params.getQuery());
    }

    private String generateString() {
        final String stringLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        final int length = stringLetters.length();
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            char randomChar = stringLetters.charAt(random.nextInt(length));
            result.append(randomChar);
        }
        return result.toString();
    }

    @Override
    public String call(final Params params) {
        switch (params.getQuery()) {
            case "random int":
                return String.valueOf(random.nextInt());
            case "random float":
                return String.valueOf(random.nextFloat());
            default:
                return generateString();
        }
    }

    @Override
    public String getName() {
        return "Random value generator";
    }

    @Override
    public String getDescription() {
        return "Generate different random values";
    }

    @Override
    public String getExample() {
        return "random int";
    }
}
