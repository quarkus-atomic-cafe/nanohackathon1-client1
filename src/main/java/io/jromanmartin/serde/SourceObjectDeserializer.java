package io.jromanmartin.serde;

import io.jromanmartin.model.SourceObject;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class SourceObjectDeserializer extends ObjectMapperDeserializer<SourceObject> {

    public SourceObjectDeserializer(){
        // pass the class to the parent.
        super(SourceObject.class);
    }

}
