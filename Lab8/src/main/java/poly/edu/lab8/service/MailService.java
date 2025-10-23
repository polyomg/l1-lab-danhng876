package poly.edu.lab8.service;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

public interface MailService {

    @Data
    @Builder
    @Accessors(chain = true)
    class Mail {
        @Builder.Default
        private String from = "WebShop <web-shop@gmail.com>";
        private String to;
        private String cc;
        private String bcc;
        private String subject;
        private String body;
        private String filenames;
    }

    void send(Mail mail);

    default void send(String to, String subject, String body) {
        send(Mail.builder()
                .to(to)
                .subject(subject)
                .body(body)
                .build());
    }

    void push(Mail mail); // dùng cho @Scheduled trong bài 2

    default void push(String to, String subject, String body) {
        push(Mail.builder()
                .to(to)
                .subject(subject)
                .body(body)
                .build());
    }
}
