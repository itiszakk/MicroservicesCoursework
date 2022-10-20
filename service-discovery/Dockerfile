FROM amazoncorretto:17
ADD build/libs/service-discovery-0.1.jar service-discovery.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/service-discovery.jar"]