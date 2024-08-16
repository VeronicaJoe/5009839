package com.example.employeemanagementsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditingConfig {

    // This would typically fetch the currently logged-in user
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.ofNullable("admin"); // hard-coded for simplicity
    }
}
