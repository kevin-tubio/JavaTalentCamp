package talent.camp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Student implements Serializable {

    private static final long serialVersionUID = 1457142284862344056L;

    private String studentId;
    private String name;
    private String rollNumber;

}
