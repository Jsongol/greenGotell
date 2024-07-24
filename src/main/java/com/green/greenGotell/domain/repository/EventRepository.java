package com.green.greenGotell.domain.repository;

import com.green.greenGotell.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);

    // 정렬된 결과를 반환하는 메서드
    List<Event> findByDateBetweenOrderByDateAsc(LocalDate startDate, LocalDate endDate);
}
