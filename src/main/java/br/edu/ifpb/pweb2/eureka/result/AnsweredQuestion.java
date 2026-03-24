package br.edu.ifpb.pweb2.eureka.result;

import br.edu.ifpb.pweb2.eureka.question.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
class AnsweredQuestion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Result result;

  // unidirectional
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "question_id", nullable = false)
  private Question question;

  private boolean answeredCorrectly;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof AnsweredQuestion))
      return false;

    var a = (AnsweredQuestion) o;
    return id != null && id.equals(a.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
