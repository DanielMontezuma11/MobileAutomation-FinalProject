package utils;

public class DataGenerator {

    public static String generatedEmail(){
        return "user" + System.currentTimeMillis() + "@test.com";
    }
}
