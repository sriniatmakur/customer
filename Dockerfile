FROM anapsix/alpine-java:latest
WORKDIR /customer
COPY . /customer
RUN ./mvnw clean install
COPY /customer/target/customer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9005
ENTRYPOINT java -jar ./app.jar