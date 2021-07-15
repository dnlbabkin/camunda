FROM  adoptopenjdk/openjdk13
#:alpine-jre

WORKDIR /apps
COPY /target/my-work.jar /apps/app.jar

ENTRYPOINT ["java", "-jar", "/apps/app.jar"]

EXPOSE 8080
