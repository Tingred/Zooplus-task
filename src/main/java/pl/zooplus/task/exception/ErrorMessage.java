package pl.zooplus.task.exception;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
}
