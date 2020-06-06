package io.github.eaxdev.jsonsql4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eaxdev.jsonsql4j.model.criteria.Criteria;
import io.github.eaxdev.jsonsql4j.model.target.TargetClause;
import io.github.eaxdev.jsonsql4j.model.join.Join;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author eaxdev
 */
@Getter
@Setter
public class Select {

    @JsonProperty(value = "fields", required = true)
    List<TargetClause> fields;

    @JsonProperty(value = "from", required = true)
    List<Table> tables;

    @JsonProperty(value = "joins")
    List<Join> joins;

    @JsonProperty("where")
    Criteria criteria;
}

