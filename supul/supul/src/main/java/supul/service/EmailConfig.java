package supul.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // 이메일 호스트 설정
        mailSender.setPort(587); // 이메일 포트 설정
        mailSender.setUsername("roomsupul@gmail.com"); // 이메일 주소 설정
        mailSender.setPassword("Roomsupul123!"); // 이메일 비밀번호 설정

        return mailSender;
    }
}
