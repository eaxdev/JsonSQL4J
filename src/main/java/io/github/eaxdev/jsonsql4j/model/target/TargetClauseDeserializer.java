package io.github.eaxdev.jsonsql4j.model.target;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author eaxdev
 */
public class TargetClauseDeserializer extends StdDeserializer<TargetClause> {

    private final Map<String, Class<?>> propertyNameToType;

    public TargetClauseDeserializer() {
        this(null);
    }

    public TargetClauseDeserializer(Class<?> vc) {
        super(vc);
        if (Objects.nonNull(vc)) {
            this.propertyNameToType = Arrays.stream(vc.getAnnotation(JsonSubTypes.class).value())
                    .collect(Collectors.toMap(JsonSubTypes.Type::name, JsonSubTypes.Type::value));
        } else {
            this.propertyNameToType = Collections.emptyMap();
        }
    }

    @Override
    public TargetClause deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper objectMapper = (ObjectMapper) p.getCodec();
        ObjectNode object = objectMapper.readTree(p);
        for (String propertyName : propertyNameToType.keySet()) {
            if (object.has(propertyName)) {
                return deserialize(objectMapper, propertyName, object);
            }
        }
        throw new IllegalArgumentException("could not infer to which class to deserialize " + object);
    }

    private TargetClause deserialize(ObjectMapper objectMapper,
                                     String propertyName,
                                     ObjectNode object) throws IOException {
        return (TargetClause) objectMapper.treeToValue(object, propertyNameToType.get(propertyName));
    }

}
