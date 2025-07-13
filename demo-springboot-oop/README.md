# demo-springboot-oop

Minimal Spring Boot project used to demonstrate Object-Oriented Programming concepts.

## Build

```bash
mvn clean package
```

## Run

```bash
java -jar target/demo-springboot-oop-0.0.1-SNAPSHOT.jar
```

## Examples

Create a product:

```bash
curl -X POST -H "Content-Type: application/json" \
    -d '{"name":"Book","price":9.99}' \
    http://localhost:8080/api/products
```

Get all products:

```bash
curl http://localhost:8080/api/products
```

Actuator health:

```bash
curl http://localhost:8080/actuator/health
```

Anthropic chat (will respond with placeholder unless `ANTHROPIC_API_KEY` is set):

```bash
curl http://localhost:8080/api/ia/chat?prompt=Hello
```

Sentiment analysis:

```bash
curl http://localhost:8080/api/ia/sentiment?text=I%20love%20this
```

## Bean scopes
* **GreetingService** - singleton (one instance for entire app)
* **TaskBean** - prototype (new instance each request to context)
* **RequestInfoBean** - request scope (new per HTTP request)
* **CartBean** - session scope (stored in HTTP session)

Look in the console logs for each bean's hash code to see the scope in action.
