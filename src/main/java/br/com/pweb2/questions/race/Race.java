package br.com.pweb2.questions.race;

import java.util.List;

import br.com.pweb2.questions.question.Question;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Race {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String title;

  @Column
  private String description;

  @Column
  private int duration;

  @OneToMany(mappedBy = "race_id")
  private List<Question> questions;
}
