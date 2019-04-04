package com.example.widget.controller;

import com.example.widget.dto.CreateGadgetRequest;
import com.example.widget.dto.GadgetResponse;
import com.example.widget.service.GadgetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = {"api/v1/gadgets"})
public class GadgetController {

    private GadgetService gadgetService;

    public GadgetController(GadgetService gadgetService) {
        this.gadgetService = gadgetService;
    }

    //this creates gadget
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGadget(@Valid @RequestBody CreateGadgetRequest createGadgetRequest) {
        this.gadgetService.createGadget(createGadgetRequest);

    }

    // this maps over the gadget and returns a list.
    // findAll() method does not work, needs to be overridden.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GadgetResponse> getGadgets() { return this.gadgetService.findAll(); }

}
