package models;

//Conține clasa `UserApi` (model POJO generat cu Lombok), folosită pentru structurarea datelor (payload-urilor) în testele API.//

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserApi {
    private String firstName;
    private String lastName;
}