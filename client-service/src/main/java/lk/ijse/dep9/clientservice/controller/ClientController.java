package lk.ijse.dep9.clientservice.controller;

import lk.ijse.dep9.basedomains.dto.ClientDTO;
import lk.ijse.dep9.basedomains.dto.LoginDTO;
import lk.ijse.dep9.clientservice.service.ClientService;
import lk.ijse.dep9.clientservice.util.ValidationGroups;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientService clientService;
    private final ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClientAccount(@Validated(ValidationGroups.Create.class) @RequestBody ClientDTO client){
        clientService.createClient(client);

    }
    @PostMapping(value = ("/verify"), consumes = "application/json")
    public HttpStatus verifyUser(@RequestHeader LoginDTO loginDTO, @AuthenticationPrincipal String username) throws Throwable {
        return clientService.findClient(loginDTO);

    }


}
