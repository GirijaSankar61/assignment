package com.app.dao;

import java.util.Date;
import java.util.UUID;

public interface AlertDAO {
    UUID addAlert(Date time);
    Date getAlert(UUID id);
}
