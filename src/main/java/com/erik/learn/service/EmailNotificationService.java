package com.erik.learn.service;

import java.util.logging.Logger;

public class EmailNotificationService implements NotificationService {
    private final Logger logger = Logger.getLogger(EmailNotificationService.class.getName());

    @Override
    public boolean send(String address, String content) {
        logger.info(String.format("Sending email to \"%s\" with message \"%s\"", address, content));
        return true;
    }
}
