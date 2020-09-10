FROM openjdk:11
ADD target/item-inventory.jar item-inventory.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "item-inventory.jar"]