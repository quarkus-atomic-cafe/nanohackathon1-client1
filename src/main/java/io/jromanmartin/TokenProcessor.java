package io.jromanmartin;

import io.jromanmartin.model.SourceObject;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class TokenProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(TokenProcessor.class);

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @Incoming("hackathon-topic")
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    public void process(SourceObject sourceObject) {
        LOG.info("Consuming message: {}", sourceObject);

        // Setting my name
        sourceObject.setName("rmarting");

        // Inserting into Database
        sourceObject.save(client)
                .subscribe()
                .with(row -> LOG.info("Saved to database {}-{}", sourceObject.token, sourceObject.name));
    }

}
