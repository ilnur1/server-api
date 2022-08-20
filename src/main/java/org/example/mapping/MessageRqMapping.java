package org.example.mapping;

import org.example.dto.MessageDto;
import org.example.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageRqMapping {

    @Mapping(target = "time", expression = "java(java.time.OffsetDateTime.now())")
    Message map(MessageDto messageDto);
}
