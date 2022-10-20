FROM amazoncorretto:17
ADD build/libs/gateway-0.1.jar gateway.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/gateway.jar"]