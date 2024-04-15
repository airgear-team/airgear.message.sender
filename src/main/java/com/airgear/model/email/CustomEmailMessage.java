package com.airgear.model.email;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomEmailMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String recipient;

    @Column
    private String subject;

    @Column
    private String text;

    @Column
    private String attachment;
}
