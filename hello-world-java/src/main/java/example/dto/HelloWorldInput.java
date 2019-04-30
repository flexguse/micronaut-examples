package example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Give here the data of the Person you would like to greet. Some addition.")
@Data
public class HelloWorldInput {

    /**
     * if set to public, the OpenAPI documentation is generated even in fluent mode
     */
    @Schema(description = "The first name.", example = "Henry")
    private String firstName;

    /**
     * if set to public, the OpenAPI documentation is generated even in fluent mode
     */
    @Schema(description = "The last name.", example = "Ford")
    private String lastName;

    public String theFirstName(){
        return firstName;
    }

    public String theLastName(){
        return lastName;
    }

}
