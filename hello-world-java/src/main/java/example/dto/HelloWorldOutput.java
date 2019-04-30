package example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Schema(description = "The greeting output.")
@Builder
@Data
public class HelloWorldOutput {

    @Schema(description = "The created greeting, normally consists of greeting + firstName + lastName")
    private String greeting;

    @Schema(description = "The timestamp the greeting was created at.")
    private Instant greetingTimestamp;

}
