FROM openjdk:11
COPY "./target/tipo-cambio-0.0.1-SNAPSHOT.jar" "app-tipo-cambio.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app-tipo-cambio.jar"]