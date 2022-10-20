FROM amazoncorretto:17
ADD build/libs/seizure-0.1.jar seizure.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/seizure.jar"]