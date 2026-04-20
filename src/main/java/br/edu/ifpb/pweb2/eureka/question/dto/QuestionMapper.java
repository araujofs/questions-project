package br.edu.ifpb.pweb2.eureka.question.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.ifpb.pweb2.eureka.question.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
  QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

  List<Question> map(List<QuestionCreateDto> questionCreateDtos);

  Question toEntity(QuestionCreateDto dto);
}
