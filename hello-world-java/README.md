# Enhancement of the micronaut Java example

This version of hello-world is a demonstration for the OpenAPI documentation generation in combination with 
[Project lombok](https://projectlombok.org/).

# Problem

If you want to use fluent accessors instead of getters/setters, the OpenAPI is not created properly.

## Steps to reproduce

### correct behavior

#### Run gradle build
 
```bash
gradle clean build
``` 

#### Look at `build/classes/java/main/META-INF/swagger/hello-world-0.0.yml`

You will find documentation for the in- and outputmodels

```yaml
components:
  schemas:
    HelloWorldOutput:
      type: object
      properties:
        greeting:
          type: string
          description: The created greeting, normally consists of greeting + firstName
            + lastName
        greetingTimestamp:
          type: integer
          description: The timestamp the greeting was created at.
          format: int64
      description: The greeting output.
    HelloWorldInput:
      type: object
      properties:
        firstName:
          type: string
          description: The first name.
          example: Henry
        lastName:
          type: string
          description: The last name.
          example: Ford
      description: Give here the data of the Person you would like to greet.
```

### incorrect behavior

#### Change lombok configuration

Open `src/lombok.config` and set

`lombok.accessors.fluent=true`

#### Run gradle build

#### Look at `build/classes/java/main/META-INF/swagger/hello-world-0.0.yml`

You will find documentation for the in- and outputmodels

```yaml
components:
  schemas:
    HelloWorldOutput:
      type: object
      description: The greeting output.
    HelloWorldInput:
      type: object
      description: Give here the data of the Person you would like to greet. Some
        addition.
```

The documentation of the member variables is missing.