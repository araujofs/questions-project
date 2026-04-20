package br.edu.ifpb.pweb2.eureka.race.dto;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.ifpb.pweb2.eureka.question.dto.QuestionMapper;
import br.edu.ifpb.pweb2.eureka.race.Race;

@Mapper(componentModel = "spring", uses = { QuestionMapper.class })
public interface RaceMapper {
  RaceMapper INSTANCE = Mappers.getMapper(RaceMapper.class);

  List<RaceDto> toDtos(List<Race> questionCreateDtos);

  RaceDto toDto(Race race);

  Race toEntity(RaceCreateDto dto, @Context RaceMapperContext ctx);
}
