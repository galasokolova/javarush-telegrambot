package com.github.javarushcommunity.jrtb.javarushclient.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

@Builder
@Getter
public class GroupsCountRequestArgs {
    private final String query;
    private final GroupInfoType type;
    private final GroupFilter filter;

    public Map<String, Object> populateQueries() {
        return Stream.of(
                        new AbstractMap.SimpleEntry<>("query", query),
                        new AbstractMap.SimpleEntry<>("type", type),
                        new AbstractMap.SimpleEntry<>("filter", filter))
                .filter(e -> Objects.nonNull(e.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
