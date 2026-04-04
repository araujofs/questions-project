package br.edu.ifpb.pweb2.eureka.race.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceCreateDto {

  private String title;
  private String description;
  private Integer duration;
  // private Set<QuestionCreateDto> questions = new HashSet<>();
}
