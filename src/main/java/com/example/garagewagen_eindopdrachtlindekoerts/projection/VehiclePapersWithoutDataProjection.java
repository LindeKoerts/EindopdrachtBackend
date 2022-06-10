package com.example.garagewagen_eindopdrachtlindekoerts.projection;

import java.util.Date;
import java.util.UUID;

public interface VehiclePapersWithoutDataProjection {
    UUID getId();
    String getName();
    String getType();
    Date getUploadedAt();
}

