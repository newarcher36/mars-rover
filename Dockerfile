FROM openjdk:9
COPY target/mars-rover-0.0.1.jar /usr/src/myapp/app.jar
WORKDIR /usr/src/myapp
CMD java -jar app.jar