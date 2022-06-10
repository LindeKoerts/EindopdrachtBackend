package com.example.garagewagen_eindopdrachtlindekoerts.projection;

import com.example.garagewagen_eindopdrachtlindekoerts.domain.InvoiceStatus;

import java.util.Date;
import java.util.UUID;

public interface InvoiceWithoutDataProjection {
    UUID getId();

    Date getCreatedAt();

    Date getPaidAt();

    InvoiceStatus getStatus();
}

