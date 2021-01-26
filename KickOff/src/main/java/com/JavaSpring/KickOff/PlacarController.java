package com.JavaSpring.KickOff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacarController {

    private Integer golsTime1 = 0;
    private Integer golsTime2 = 0;

    @GetMapping("/placar/gol/{time}")
    public void registrarGol(@PathVariable int time){
        if (time == 1){
            golsTime1++;
        }else if (time == 2){
            golsTime2++;
        }
    }

    @GetMapping("/placar/atual")
        public String placarAtual(){
            return String.format("Placar > Time1: %d  x  Time2: %d", golsTime1, golsTime2);
        }
}
