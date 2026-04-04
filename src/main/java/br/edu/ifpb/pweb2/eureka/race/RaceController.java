package br.edu.ifpb.pweb2.eureka.race;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.eureka.race.dto.RaceCreateDto;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/race")
@RequiredArgsConstructor
public class RaceController {

  private final RaceService service;

  @GetMapping("/create")
  public String getRaceForm(Model model) {
    var race = new RaceCreateDto();

    if (model.containsAttribute("race")) {
      race = (RaceCreateDto) model.getAttribute("race");
      System.out.println("entrou");
    }

    model.addAttribute("race", race);

    return "race/form";
  }

  @PostMapping("/create")
  public String postRaceForm(RaceCreateDto newRace, RedirectAttributes attributes) {
    try {
      service.save(newRace);
    } catch (Exception e) {
      attributes.addFlashAttribute("errorMessage", e.getLocalizedMessage());
      attributes.addFlashAttribute("race", newRace);

      return "redirect:/race/create";
    }

    return "redirect:/home";
  }
}
