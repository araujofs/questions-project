package br.edu.ifpb.pweb2.eureka.race.dto;

import java.util.List;
import java.util.ArrayList;

import br.edu.ifpb.pweb2.eureka.question.dto.QuestionCreateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceQuestionsDto {
  private Long id;
  private List<QuestionCreateDto> questions = new ArrayList<>();
}
