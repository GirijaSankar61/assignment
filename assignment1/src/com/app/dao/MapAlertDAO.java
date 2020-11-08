package com.app.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class MapAlertDAO implements AlertDAO {
    private final Map<UUID, Date> alerts = new HashMap<>();

    @Override
    public UUID addAlert(Date time) {
        UUID id = randomUUID();
        this.alerts.put(id, time);
        return id;
    }

    @Override
    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }
}
