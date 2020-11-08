package com.app.service;

import com.app.dao.AlertDAO;

import java.util.Date;
import java.util.UUID;

public class AlertService {
    private AlertDAO storage;

    public AlertService(AlertDAO alertDAO) {
        this.storage = alertDAO;
    }

    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }
}
