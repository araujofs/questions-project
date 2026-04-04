package br.edu.ifpb.pweb2.eureka.question.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionCreateDto {
  private String statement;
  private int difficulty;
  private List<String> answers = new ArrayList<>();
  private Integer correctAnswer;
}
