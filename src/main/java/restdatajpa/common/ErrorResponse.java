package restdatajpa.common;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ErrorResponse {

    private String message;
    private HttpStatus status;
    private String type;
    private Map<String, String> errors;

    public void addError(String field, String message) {
        if (errors == null) {
            errors = new HashMap<>();
        }

        errors.put(field, message);
    }
}