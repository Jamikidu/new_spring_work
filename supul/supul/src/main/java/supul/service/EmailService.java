package supul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import supul.model.MailDTO;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender emailSender;

    public void sendSimpleMessage(MailDTO mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2kwon2lee@gmail.com");
        message.setTo(mailDto.getAddress());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getContent());
        emailSender.send(message);
    }
	
}
