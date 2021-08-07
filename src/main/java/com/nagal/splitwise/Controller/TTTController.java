package com.nagal.splitwise.Controller;

import com.nagal.splitwise.models.Coordinate;
import com.nagal.splitwise.service.TTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/TTT")
public class TTTController {

    @Autowired
    TTTService tttService;
    static int global_count = 0;

    @GetMapping(value = "/hellog")
    public List<String> home(){
        ArrayList<String> array=new ArrayList<>(Arrays.asList("hello","this","application"));
        int count = 0;
        global_count++;
        System.out.println("Entering count loop");
        for (long time = 1; time <= 10000000000L; ++time) {
            //System.out.println(time);
            count++;
        }
        if (global_count % (30000) == 0) {
            System.out.println (global_count + " " + System.currentTimeMillis());
        }
        return array;
    }

    @PostMapping(value = "/updateGrid")
    public ResponseEntity update(@RequestBody Coordinate coordinate) {
        if (!tttService.validMove(coordinate.getX(),coordinate.getY())) {
            return ResponseEntity.badRequest().body("Error from User side");
        }
        else {
            tttService.playMove(coordinate.getX(),coordinate.getY());
            if (tttService.isFinished() != null) {
                return ResponseEntity.ok().body("Winner is {}".format(tttService.isFinished()));
            }
           else {
                return ResponseEntity.ok().body("Move was successful");
            }
        }
    }

    @GetMapping(value = "/getGridState")
    public List<List <Character>> getCurrentState () {
        return tttService.getState();
    }

}
