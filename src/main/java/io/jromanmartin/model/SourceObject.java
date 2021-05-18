package io.jromanmartin.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;

@RegisterForReflection
public class SourceObject {

    public String token;

    public String name;

    public SourceObject(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SourceObject [token=" + token + ", name=" + name + "]";
    }

    // SQL Reactive Methods

    public Uni<Void> save(PgPool client) {
        return
                client.preparedQuery("INSERT INTO hackathontarget (token, name) VALUES ($1,$2)")
                        .execute(Tuple.of(token, name))
                        .onItem().ignore().andContinueWithNull();
                        //.transform(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
    }

//    public Uni<String> save(PgPool client) {
//        return client.preparedQuery("INSERT INTO hackathontarget (token, name) VALUES ($1,$2) RETURNING token")
//                .execute(Tuple.of(token, name)).onItem()
//                .transform(pgRowSet -> pgRowSet.iterator().next().getString("token"))
//                .onItem().invoke(i -> System.out.println("Received item " + i))
//                .onCancellation().invoke(() -> System.out.println("The downstream does not want our items anymore!"))
//                .onFailure().invoke(t -> System.out.println("Oh no! We received a failure: " + t.getMessage()))
//                .onFailure().retry().atMost(3);
//
//    }

}
