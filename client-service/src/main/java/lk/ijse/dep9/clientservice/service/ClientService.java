package lk.ijse.dep9.clientservice.service;

import lk.ijse.dep9.basedomains.dto.ClientDTO;
import lk.ijse.dep9.basedomains.dto.LoginDTO;
import lk.ijse.dep9.clientservice.repository.ClientRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component
public class ClientService {
    private ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    public void createClient(ClientDTO client) {
        client.setPassword(DigestUtils.sha256Hex(client.getPassword()));
        clientRepository.save(modelMapper.map(client, lk.ijse.dep9.clientservice.entity.Client.class));
    }

    public HttpStatus findClient(LoginDTO loginDTO) throws Throwable {
        lk.ijse.dep9.clientservice.entity.Client byId = clientRepository.findById(loginDTO.getUsername()).get();

        if (DigestUtils.sha256Hex(loginDTO.getPassword()).equals(byId.getPassword())){
            return HttpStatus.FOUND;
        }
        throw new AuthenticationException();
    }
}
