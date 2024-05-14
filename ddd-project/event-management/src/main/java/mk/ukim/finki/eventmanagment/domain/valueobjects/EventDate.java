package mk.ukim.finki.eventmanagment.domain.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.Duration;
@Embeddable
public class EventDate {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    protected EventDate() {
        this.startDate = null;
        this.endDate = null;
    }

    public EventDate(LocalDateTime start, LocalDateTime end) {
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }
        this.startDate = start;
        this.endDate = end;
    }

    public static EventDate of(LocalDateTime start, LocalDateTime end) {
        return new EventDate(start, end);
    }

    public boolean overlapsWith(EventDate other) {
        return !this.endDate.isBefore(other.startDate) && !this.startDate.isAfter(other.endDate);
    }

    public Duration getDuration() {
        return Duration.between(startDate, endDate);
    }

    public EventDate extendEvent(LocalDateTime newEnd) {
        if (newEnd.isBefore(this.endDate)) {
            throw new IllegalArgumentException("New end time cannot be before current end time.");
        }
        return new EventDate(this.startDate, newEnd);
    }

    public EventDate reschedule(LocalDateTime newStart, LocalDateTime newEnd) {
        if (newEnd.isBefore(newStart)) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }
        return new EventDate(newStart, newEnd);
    }

}
