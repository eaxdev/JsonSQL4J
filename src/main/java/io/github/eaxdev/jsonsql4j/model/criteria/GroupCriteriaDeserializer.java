package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JParseException;

import java.io.IOException;
import java.util.List;

/**
 * @author eaxdev
 */
public class GroupCriteriaDeserializer extends StdDeserializer<GroupCriteria> {

    private static final TypeReference<List<Criteria>> TYPE_REFERENCE =
            new TypeReference<List<Criteria>>() {
            };

    public GroupCriteriaDeserializer() {
        this(null);
    }

    private GroupCriteriaDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public GroupCriteria deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String currentKey = p.getParsingContext().getCurrentName();
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        List<Criteria> criteriaList = mapper.convertValue(node, TYPE_REFERENCE);

        if (currentKey.equals(ConditionalOperator.AND.getType())) {
            return new And(criteriaList);
        } else if (currentKey.equals(ConditionalOperator.OR.getType())) {
            return new Or(criteriaList);
        }
        throw new JsonSQL4JParseException("Can not deserialize json. Key [" + currentKey + "] is not correct");
    }

}
