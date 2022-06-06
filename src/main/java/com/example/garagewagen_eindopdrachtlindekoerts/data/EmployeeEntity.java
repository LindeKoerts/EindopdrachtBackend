package com.example.garagewagen_eindopdrachtlindekoerts.data;

import com.fasterxml.jackson.annotation.JsonIgnore;





import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee")
@Table(indexes = {
        @Index(name = "idx_employee_email", columnList = "email")
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = EmployeeEntity.GRAPH_DEFAULT),
})
public class EmployeeEntity {
}
