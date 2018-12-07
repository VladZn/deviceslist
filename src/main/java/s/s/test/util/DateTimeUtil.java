package s.s.test.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss O");
//    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    private DateTimeUtil() {
    }

    public static String toString(Timestamp timestamp) {
        return timestamp == null ? "" : timestamp.toLocalDateTime().format(DATE_TIME_FORMATTER);
        //return OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.of("UTC")).toZonedDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

}
