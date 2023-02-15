package lk.ijse.dep9.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String firstName;
    private String lastName;
    private String address;
    private String username;
    private String password;
}
