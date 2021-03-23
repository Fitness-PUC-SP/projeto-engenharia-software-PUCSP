package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.TrainerService;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualtrainer.transport.response.TrainerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @ApiOperation(value = "Insert a trainer into the database")
    @PostMapping()
    public void createTrainer(@RequestBody @Valid TrainerRequest request){
        trainerService.createTrainer(request);
    }

    @PostMapping(path = "/setField")
    public void addField(@RequestBody String request){
        trainerService.addFields(request);
    }

    @GetMapping(path = "/{trainerName}")
    @ResponseBody
    public TrainerResponse getTrainer(@PathVariable String trainerName){
        return trainerService.findTrainer(trainerName);
    }
}
