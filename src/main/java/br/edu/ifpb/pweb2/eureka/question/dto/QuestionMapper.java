package br.edu.ifpb.pweb2.eureka.question.dto;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.edu.ifpb.pweb2.eureka.question.Question;
import br.edu.ifpb.pweb2.eureka.question.difficulty.Difficulty;
import br.edu.ifpb.pweb2.eureka.race.dto.RaceMapperContext;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
  QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

  List<Question> map(List<QuestionCreateDto> questionCreateDtos);

  @Mapping(target = "race", ignore = true)
  Question toEntity(QuestionCreateDto dto, @Context RaceMapperContext ctx);

  default Difficulty toEnum(int difficulty) {
    return Difficulty.fromValue(difficulty);
  }
}
