package com.example.demo.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Prototype: bean recreado en cada inyección, simula un borrador de reseña de un producto.
 */
@Slf4j
@Component
@Scope("prototype")
public class ReviewDraft {
    private final UUID draftId;
    private String reviewerName;
    private String reviewContent;

    public ReviewDraft() {
        this.draftId = UUID.randomUUID();
        log.info("[Prototype] ReviewDraft instantiated: {}", this.hashCode());
    }

    public UUID getDraftId() {
        return draftId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    /**
     * Simula el envío del borrador de reseña.
     */
    public void submit() {
        log.info("Submitting draft [{}]: by {} - '{}'", draftId, reviewerName, reviewContent);
    }
}
