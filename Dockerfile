FROM maven:3.9.0-amazoncorretto-19 AS build

COPY src /home/projects/score_service/src
COPY pom.xml /home/projects/score_service/
WORKDIR /home/projects/score_service/

RUN mvn -f /home/projects/score_service/pom.xml clean package

#
# Package stage
#

FROM amazoncorretto:19-alpine
COPY --from=build /home/projects/score_service/target/score_service-1.0.0.jar /usr/local/lib/score_service-1.0.0.jar

ENTRYPOINT ["java","-jar","/usr/local/lib/score_service-1.0.0.jar"]
