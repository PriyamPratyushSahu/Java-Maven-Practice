package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class JsonReader {

    private static JsonNode rootNode;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/test/resources/testdata.json");
            rootNode = mapper.readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load test data JSON file");
        }
    }

    public static String getValue(String key) {
        return rootNode.get(key).asText();
    }

    // Optional: You can create more methods if needed
    public static String getUsername() {
        return getValue("username");
    }

    public static String getPassword() {
        return getValue("password");
    }

    public static String getUrl() {
        return getValue("url");
    }

    public static String getEnvironment() {
        return getValue("environment");
    }

    public static void main(String[] args) {
        JsonReader js = new JsonReader();
        System.out.println(js.getUsername());
        System.out.println(System.getProperty("user.dir"));

        String username = TestData.get("username");
        System.out.println(username);
        String password = TestData.get("password");
        System.out.println(password);
        String url = TestData.get("url");
        System.out.println(url);
    }

}