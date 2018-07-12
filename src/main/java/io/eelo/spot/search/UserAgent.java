package io.eelo.spot.search;

import java.util.List;
import java.util.Random;

public class UserAgent {

    public static List<String> OSs;
    public static List<String> versions;
    private static final Random random = new Random();

    public static String generate() {
        final String os = OSs.get(random.nextInt(OSs.size()));
        final String version = versions.get(random.nextInt(versions.size()));

        return "Mozilla/5.0 (os; rv:version) Gecko/20100101 Firefox/version"
                .replace("{os}", os).replace("version", version);
    }

}
