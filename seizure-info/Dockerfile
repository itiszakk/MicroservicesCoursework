FROM amazoncorretto:17
ADD build/libs/seizure-info-0.1.jar seizure-info.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/seizure-info.jar"]