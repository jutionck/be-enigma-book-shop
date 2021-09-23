FROM openjdk:8
EXPOSE 8080
ADD target/be-enigma-shop.jar be-enigma-shop.jar
ENTRYPOINT ["java", "-jar", "/be-enigma-shop.jar"]
