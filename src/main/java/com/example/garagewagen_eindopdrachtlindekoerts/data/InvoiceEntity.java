package com.example.garagewagen_eindopdrachtlindekoerts.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.example.garagewagen_eindopdrachtlindekoerts.domain.InvoiceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "invoice")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = InvoiceEntity.GRAPH_DEFAULT),
})
public class InvoiceEntity {

    public static final String GRAPH_DEFAULT = "Invoice.default";

    @Id
    @Column(name = "id", unique = true)
    @Schema(example = "8296b5c5-gt10-56d3-y678-c7a8291d8201", format = "uuid")
    private UUID id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "paid_at")
    @Schema(example = "2022-06-06 11:51:08.000000", format = "date-time", nullable = true)
    private Date paidAt;

    @Column(name = "status")
    @Schema(example = "1", allowableValues = {"0", "1"})
    private InvoiceStatus status;

    @Lob
    @Column(name = "data")
    @Type(type = "org.hibernate.type.BinaryType")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Schema(format = "byte", nullable = true)
    private byte[] data;

    @CreationTimestamp
    @Column(name = "created_at")
    @Schema(example = "2022-06-06 11:49:29.998000", format = "date-time")
    private Date createdAt;

}
