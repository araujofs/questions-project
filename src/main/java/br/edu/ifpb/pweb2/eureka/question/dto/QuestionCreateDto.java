package br.edu.ifpb.pweb2.eureka.question.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.pweb2.eureka.question.difficulty.Difficulty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionCreateDto {
  private Long id;
  private String statement;
  private Difficulty difficulty;
  private List<String> answers = new ArrayList<>();
  private Integer correctAnswer;
}
