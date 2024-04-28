# Top 5 JSON Loading Cases in Java Using Jackson

This document outlines different scenarios for loading JSON data into Java objects using the Jackson library.

## 1. Simple Array JSON

- **JSON Structure**:
  ```json
  [
      {"name": "Alice", "age": 25},
      {"name": "Bob", "age": 30}
  ]
    ```
  
Model Class: Person
Loader Method:

  ```java

public List<Person> loadPersonArray(String resourcePath) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new ClassPathResource(resourcePath).getInputStream(), new TypeReference<List<Person>>(){});
}
  ```
## 2. Nested Objects JSON
JSON Structure:

  ```json
{
    "department": "Sales",
    "employees": [
        {"name": "Alice", "age": 25},
        {"name": "Bob", "age": 30}
    ]
}
  ```

Model Class: Department
Loader Method:

  ```java
public Department loadDepartmentData(String resourcePath) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new ClassPathResource(resourcePath).getInputStream(), Department.class);
}
  ```
## 3. JSON With Root Key

JSON Structure:
  ```json
{
    "result": [
        {"name": "Alice", "age": 25},
        {"name": "Bob", "age": 30}
    ]
}
  ```
Model Class: ResultWrapper
Loader Method:

  ```java
public List<Person> loadPersonsWithRootKey(String resourcePath) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    ResultWrapper wrapper = objectMapper.readValue(new ClassPathResource(resourcePath).getInputStream(), ResultWrapper.class);
    return wrapper.getResult();
}
  ```

## 4. JSON With Metadata
JSON Structure:

  ```json
{
    "metadata": {
        "count": 2,
        "source": "database"
    },
    "data": [
        {"name": "Alice", "age": 25},
        {"name": "Bob", "age": 30}
    ]
}
  ```

Model Class: DataWithMetadata
Loader Method:

  ```java
public DataWithMetadata loadDataWithMetadata(String resourcePath) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new ClassPathResource(resourcePath).getInputStream(), DataWithMetadata.class);
}
  ```

## 5. Large JSON Files

JSON Structure: Varies
Model Class: Depends on the specific JSON structure
Loader Method:

  ```java
public <T> List<T> loadLargeJsonFile(String resourcePath, Class<T> clazz) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonParser jsonParser = new ClassPathResource(resourcePath).getInputStream();
    return objectMapper.readValues(jsonParser, clazz).readAll();
}
  ```

Each method showcases a unique way of handling JSON data in Java applications, making use of the Jackson library's flexibility and power in data processing.
