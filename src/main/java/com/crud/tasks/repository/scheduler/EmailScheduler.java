package com.crud.tasks.repository.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    @Scheduled(fixedDelay = 100000000)
    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        mailCountChecker(size),
                        null
                )
        );
    }

    @Scheduled(fixedDelay = 100000000)
    public void sendInformationEmail2() {
        simpleEmailService.sendCount(
                Mail.builder()
                        .mailTo(adminConfig.getAdminMail())
                        .subject(SUBJECT)
                        .message("Just for your knowledge")
                        .build()
        );
    }

    public String mailCountChecker (long size) {
        String message = "Currently in database you got: " + size + " task";
        if (size != 1) {
                message += "s";
        }
        return message;
    }
}