package mk.ukim.finki.ticketmanagement.domain.valueobjects.reservation;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Embeddable
@Getter
public class SeatNum {

    private final int seatNum;
    @Enumerated(value = EnumType.STRING)
    private final SeatStatus status;
    public SeatNum(int seatNum, SeatStatus status) {
        if (seatNum <= 0) {
            throw new IllegalArgumentException("Seat number must be positive.");
        }
        this.seatNum = seatNum;
        this.status = status;
    }

    protected SeatNum() {
        this.seatNum = 0;
        this.status = null;
    }

    public SeatNum reserve() {
        if (this.status != SeatStatus.AVAILABLE) {
            throw new IllegalStateException("Seat is not available for reservation.");
        }
        return new SeatNum(this.seatNum, SeatStatus.RESERVED);
    }

    public SeatNum occupy() {
        if (this.status != SeatStatus.RESERVED) {
            throw new IllegalStateException("Seat must be reserved before it can be occupied.");
        }
        return new SeatNum(this.seatNum, SeatStatus.OCCUPIED);
    }

    public SeatNum release() {
        return new SeatNum(this.seatNum, SeatStatus.AVAILABLE);
    }

}
