# Camunda Try
Just to try camunda

# How to Run
- Import project into intellij idea (or other IDE) as maven project and run the Application.java
- Or run using maven command in terminal `mvn spring-boot:run`

# How to Make Executable
- Use maven command in terminal `mvn clean package`
- You will find a `jar` file inside `target` folder
- You can run it by using JRE with this command: `java -jar camunda-try-1.0.0-SNAPSHOT.jar`

# Camunda Utility
- Visit camunda UI at `http://localhost:8080/`
- Start some process and complete some task using cockpit
- You can also interact with camunda system using REST as described at `https://docs.camunda.org/manual/latest/reference/rest/`

# Rest command sample (cURL)
- Start a process (`watchMovie` is the process id)
```cUrl
curl --location --request POST 'localhost:8080/engine-rest/process-definition/key/watchMovie/start' \
--header 'Content-Type: application/json' \
--data-raw '{}'
```

- Get tasks (`pickMovie` is the definitionKey or task id in the modeler used to filter result)
```cUrl
curl --location --request GET 'localhost:8080/engine-rest/task?definitionKey=pickMovie' \
--header 'Content-Type: application/json' \
--data-raw '{}'
```

- Complete a task (`3d16d46a-9cd7-11eb-8bba-0242d8aeb5a0` is the task id) using variable
```cUrl
curl --location --request POST 'localhost:8080/engine-rest/task/3d16d46a-9cd7-11eb-8bba-0242d8aeb5a0/complete' \
--header 'Content-Type: application/json' \
--data-raw '{
    "variables": {
        "selectedMovie": {
            "value": "The Matrix"
        }
    }
}'
```
