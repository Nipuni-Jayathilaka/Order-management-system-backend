package lk.ijse.dep9.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    @NotBlank(message = "first name cannot be empty")
    @Pattern(regexp = "^a-zA-Z $", message = "please enter a valid name")
    private String firstName;
    @NotBlank(message = "first name cannot be empty")
    @Pattern(regexp = "^a-zA-Z $", message = "please enter a valid name")
    private String lastName;
    @NotBlank(message = "first name cannot be empty")
    @Pattern(regexp = "^a-zA-Z $", message = "please enter a valid name")
    private String address;
    @NotBlank(message = "first name cannot be empty")
    @Pattern(regexp = "^a-zA-Z $", message = "please enter a valid name")
    private String username;
    @NotEmpty(message = "password cannot be empty")
    @Length(min = 3, message = "password length should  be more than 3")
    private String password;
}
