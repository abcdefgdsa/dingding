package com.example.myapp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonUtils {

    public static Map<String, Object> convertJson2Map(String jsonString)  {
        // 创建 ObjectMapper 对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将 JSON 字符串解析为一个 Map 对象
        Map<String, Object> jsonMap = null;
        try {
            jsonMap = objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return jsonMap;
    }
}
