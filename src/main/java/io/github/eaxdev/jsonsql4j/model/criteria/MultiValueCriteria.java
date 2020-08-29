package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author eaxdev
 */
@Getter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = In.class)
})
public abstract class MultiValueCriteria implements Criteria {

    @JsonProperty(value = "fieldName", required = true)
    private String fieldName;

    @JsonProperty(value = "values", required = true)
    private List<String> values;

    public MultiValueCriteria(String fieldName, List<String> values) {
        this.fieldName = fieldName;
        this.values = Collections.unmodifiableList(values);
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(values);
    }

    public abstract MultiValueConditionalOperator getMultiValueConditionalOperator();

    public String getValuesView() {
        validateValues();

        return values.stream().map(value -> {
            if (Util.isNumeric(value)) {
                return value;
            }
            return "'" + value + "'";
        }).collect(Collectors.joining(", "));

    }

    private void validateValues() {
        if (values.isEmpty()) {
            throw new JsonSQL4JException("IN operator must contains one or more elements");
        }
        String firstValue = values.get(0);
        boolean isNumericFirst = Util.isNumeric(firstValue);
        boolean allNumericOrNot = values.stream().anyMatch(v -> Util.isNumeric(v) != isNumericFirst);

        if (allNumericOrNot) {
            throw new JsonSQL4JException("Values in IN operator must be same type");
        }
    }

}
