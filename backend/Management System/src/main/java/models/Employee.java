package models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Embeddable
@Getter
@Setter
public class Employee{
    private List<Role> roles;
    private Date startDate;
    private Date endDate;
}
