package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.TrainerService;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualtrainer.transport.response.TrainerListResponse;
import br.edu.pucsp.virtualtrainer.transport.response.TrainerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @ApiOperation(value = "Insert a trainer into the database")
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes =APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrainer(@RequestBody @Valid TrainerRequest request){
        trainerService.createTrainer(request);
    }

    @GetMapping(path = "/filter")
    public TrainerListResponse getTrainers(
            @RequestParam(name = "name") String name){
        return new TrainerListResponse(trainerService.findTrainers(name));
    }

    @GetMapping(path = "/{trainerId}")//ou CPF?
    public TrainerResponse getTrainer(@PathVariable Long trainerId){
        return new TrainerResponse(trainerService.findTrainer(trainerId));
    }

    @GetMapping
    public TrainerListResponse getAllTrainers(){
        return new TrainerListResponse(trainerService.findAllTrainers());
    }

    @PutMapping(path = "/{trainerId}")
    public void updateTrainer(@RequestBody @Valid TrainerRequest request,
                                         @PathVariable Long trainerId){
        trainerService.updateTrainer(request, trainerId);
    }

    @DeleteMapping(path = "/{trainerId}")
    public void deleteTrainer(@PathVariable Long trainerId){
        trainerService.deleteTrainer(trainerId);

    }

    @PostMapping(path = "/setField", produces = APPLICATION_JSON_VALUE, consumes =APPLICATION_JSON_VALUE )
    public void addField(@RequestBody String request){
        trainerService.addFields(request);
    }
}
