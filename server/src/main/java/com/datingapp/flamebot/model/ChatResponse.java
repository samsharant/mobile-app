package com.datingapp.flamebot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {
    private String id;
    private String sender;
    private String type;
    private String prompt;
    private String responseContent;
    private Instant timestamp;
    private String intent;
    private String emotion;
    private List<String> suggestions;
}