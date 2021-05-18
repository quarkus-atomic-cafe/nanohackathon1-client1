package io.jromanmartin.serde;

import io.jromanmartin.model.SourceObject;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class SourceObjectJsonbDeserializer extends JsonbDeserializer<SourceObject> {

    public SourceObjectJsonbDeserializer() {
        // pass the class to the parent.
        super(SourceObject.class);
    }

}
