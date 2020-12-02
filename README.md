# Embedded-Jetty-Server---Java (w/GlassFish)

## Description:
This is an Jetty Server example, using Maven project in Java. You're free to use it out.

## Maven Dependencies:
```
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-server</artifactId>
    <version>9.4.3.v20170317</version>
</dependency>
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-servlet</artifactId>
    <version>9.4.3.v20170317</version>
</dependency>
<dependency>
    <groupId>org.glassfish.main.extras</groupId>
    <artifactId>glassfish-embedded-all</artifactId>
    <version>5.0</version>
</dependency>
```

## Starting out:
The basic code to execute an JettyServer is simple, we only need an Server, Port and ServletContextHandler. In the following example I'm using port 8080.
Using Glassfish, we managed to have endpoints. Creating a Custom AuthFilter to use Basic Authentication.

## Authors:
``` Octávio Marques ```

## License:
[MIT](https://choosealicense.com/licenses/mit/)
