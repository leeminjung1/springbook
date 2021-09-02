package com.book.book.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entity 클래스들이 이 클래스를 상속할 때 필드들도 column으로 인식하도록.
@EntityListeners(AuditingEntityListener.class)  // Auditing 기능 포함
public abstract class BaseTimeEntity {  // 모든 entity의 상위클래스

    @CreatedDate    // Entity 생성, 저장될 때의 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity 값을 변경할 때의 시간 자동저장
    private LocalDateTime modifiedDate;

}
