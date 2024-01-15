package com.github.javarushcommunity.jrtb.javarushclient.dto;

import lombok.*;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

/**
 * Request arguments for group requests.
 */
@Builder
@Getter
public class GroupRequestArgs {

    private final String query;
    private final GroupInfoType type;
    private final GroupFilter filter;

    /**
     * specified where to start getting groups
     */
    private final Integer offset;
    /**
     * Limited number of groups.
     */
    private final Integer limit;

    public Map<String, Object> populateQueries() {
        Map<String, Object> queries = new HashMap<>();

        // Creating a stream of "key-value" for each possible parameter
        Stream.of(
                        new AbstractMap.SimpleEntry<>("query", query),
                        new AbstractMap.SimpleEntry<>("type", type),
                        new AbstractMap.SimpleEntry<>("filter", filter),
                        new AbstractMap.SimpleEntry<>("offset", offset),
                        new AbstractMap.SimpleEntry<>("limit", limit)
                )
                // Filter pairs, where the value is null
                .filter(entry -> nonNull(entry.getValue()))
                // Putting every filtered pair to the Map
                .forEach(entry -> queries.put(entry.getKey(), entry.getValue()));

        return queries;
    }



}
