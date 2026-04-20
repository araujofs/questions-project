package br.edu.ifpb.pweb2.eureka.race;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.eureka.race.dto.RaceCreateDto;
import br.edu.ifpb.pweb2.eureka.race.dto.RaceDto;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/race")
@RequiredArgsConstructor
public class RaceController {

  private final RaceService service;

  @GetMapping("/create")
  public String getRaceForm(Model model) {
    if (!model.containsAttribute("race"))
      model.addAttribute("race", new RaceCreateDto());

    return "race/form";
  }

  @GetMapping("/confirm")
  public String getConfirm(Model model) {
    if (!model.containsAttribute("raceId"))
      return "redirect:/home";

    return "race/confirm";
  }

  @PostMapping("/create")
  public String postRaceForm(RaceCreateDto newRace, RedirectAttributes attributes) {

    try {
      attributes.addFlashAttribute("raceId", service.save(newRace));
      return "redirect:/race/confirm";
    } catch (Exception e) {
      attributes.addFlashAttribute("errorMessage", e.getLocalizedMessage());
      attributes.addFlashAttribute("race", newRace);
    }

    return "redirect:/race/create";
  }

  @GetMapping("/edit/{id}")
  public String getRaceEditForm(@PathVariable Long id, Model model) {
    var race = service.getById(id);
    model.addAttribute("race", race.get());

    return "race/edit/form";
  }

  @PostMapping("/edit/{id}")
  public String postRaceEditForm(@PathVariable Long id, RaceDto newRace, RedirectAttributes attributes) {
    try {
      attributes.addFlashAttribute("raceId", service.edit(newRace));
      return "redirect:/home";
    } catch (Exception e) {
      attributes.addFlashAttribute("errorMessage", e.getLocalizedMessage());
      attributes.addFlashAttribute("race", newRace);
    }

    return "redirect:/race/edit/" + id;
  }

  @GetMapping("/delete/{id}")
  public String getDeleteConfirm(@PathVariable Long id, Model model) {
    model.addAttribute("raceId", id);

    return "race/delete/confirm";
  }

  @DeleteMapping("/delete/{id}")
  public String deleteRace(@PathVariable Long id, RedirectAttributes attributes) {
    try {
      service.remove(id);
    } catch (Exception e) {
      attributes.addFlashAttribute("errorMessage", e.getMessage());
      return "redirect:/race/delete/{id}";
    }

    return "redirect:/home";
  }
}
