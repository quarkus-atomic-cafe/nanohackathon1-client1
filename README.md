# Quarkus Nanohackathon

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/nanohackathon-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

### Pushing Native Image into a Container Image Registry

You can build a container image and push into a Container Image Registry using:

```shell script
./mvnw package -Pnative \
  -Dquarkus.native.container-build=true \
  -Dquarkus.container-image.build=true \
  -Dquarkus.container-image.builder=jib \
  -Dquarkus.container-image.push=true \
  -Dquarkus.container-image.registry=quay.io \
  -Dquarkus.container-image.group=rmarting \
  -Dquarkus.container-image.username=rmarting \
  -Dquarkus.container-image.password=*******
```

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

## Deploy a local PostgreSQL Podman Instance

```shell script
podman run -it --rm=true --memory-swappiness=0 --name postgresql \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=sample \
  -e POSTGRES_DB=dbsample \
  -p 5432:5432 postgres:10.5
```

## Main References

* [QUARKUS - USING APACHE KAFKA WITH REACTIVE MESSAGING](https://quarkus.io/guides/kafka)
* [QUARKUS - REACTIVE SQL CLIENTS](https://quarkus.io/guides/reactive-sql-clients)
* [QUARKUS - GETTING STARTED WITH REACTIVE](https://quarkus.io/guides/getting-started-reactive)
* [How to handle failures with Mutiny](https://quarkus.io/blog/mutiny-failure-handling/)
