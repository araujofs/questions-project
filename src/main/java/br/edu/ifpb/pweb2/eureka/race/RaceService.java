package br.edu.ifpb.pweb2.eureka.race;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.eureka.race.dto.RaceCreateDto;
import br.edu.ifpb.pweb2.eureka.race.dto.RaceMapper;
import br.edu.ifpb.pweb2.eureka.race.dto.RaceMapperContext;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RaceService {
  private final RaceRepository repo;

  public Long save(RaceCreateDto dto) {
    Objects.requireNonNull(dto, "Race must not be null to save it!");

    Race race = RaceMapper.INSTANCE.toEntity(dto, new RaceMapperContext());
    // will never be null
    return (repo.save(race)).getId();
  }

  public List<Race> getAll() {
    return repo.findAll();
  }

  public void remove(Race race) {
    Objects.requireNonNull(race, "Race must not be null to delete it!");
    repo.deleteById(race.getId());
  }
}
