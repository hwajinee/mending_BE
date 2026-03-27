package mending_BE.global.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class DeletedBaseEntity extends BaseEntity {

    @Column
    private LocalDateTime deletedAt;

    @Column(nullable = false)
    private boolean deleted = false;

    public void delete() {
        this.deleted = true;
        this.deletedAt = LocalDateTime.now();
    }

    public void restore() {
        this.deleted = false;
        this.deletedAt = null;
    }
}
