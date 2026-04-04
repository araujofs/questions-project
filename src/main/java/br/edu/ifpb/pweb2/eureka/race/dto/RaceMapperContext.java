package br.edu.ifpb.pweb2.eureka.race.dto;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;

import br.edu.ifpb.pweb2.eureka.question.Question;
import br.edu.ifpb.pweb2.eureka.race.Race;

public class RaceMapperContext {

  private Race race;

  @BeforeMapping
  public void setTempRace(@MappingTarget Race race) {
    this.race = race;
  }

  @AfterMapping
  public void setRace(@MappingTarget Question question) {
    if (question != null)
      question.setRace(race);
  }
}
