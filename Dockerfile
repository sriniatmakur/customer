FROM adoptopenjdk/openjdk8 as builder
WORKDIR /customer
COPY . /customer
RUN chmod +x mvnw
RUN ./mvnw clean install
FROM adoptopenjdk/openjdk8:jre
COPY --from=builder /customer/target/customer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9005
ENTRYPOINT java -jar ./app.jar