FROM amazoncorretto:17
ADD build/libs/treatment-0.1.jar treatment.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/treatment.jar"]