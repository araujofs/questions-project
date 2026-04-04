package br.edu.ifpb.pweb2.eureka.race.dto;

import br.edu.ifpb.pweb2.eureka.question.dto.QuestionMapper;
import br.edu.ifpb.pweb2.eureka.race.Race;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { QuestionMapper.class })
public interface RaceMapper {
  RaceMapper INSTANCE = Mappers.getMapper(RaceMapper.class);

  Race toEntity(RaceCreateDto dto, @Context RaceMapperContext ctx);
}
