package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestData {

    private static JsonNode rootNode;

    // ✅ Static block runs once when the class is loaded
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

    public static String get(String key) {
        return rootNode.get(key).asText();
    }
}
