package projections

import be.playing.with.projections.model.Event
import be.playing.with.projections.model.EventType

import java.time.LocalDateTime

class EventBuilder {

    private String id
    private EventType type
    private LocalDateTime timestamp
    private Map payload = [:]

    private EventBuilder() {
    }

    static EventBuilder newBuilder() {
        return new EventBuilder()
    }

    EventBuilder withId(String val) {
        id = val
        return this
    }

    EventBuilder withType(EventType val) {
        type = val
        return this
    }

    EventBuilder withTimestamp(LocalDateTime val) {
        timestamp = val
        return this
    }

    EventBuilder withProperty(String key, String val) {
        payload.put(key, val)
        return this
    }

    Event build() {
        validate()
        return new Event(id, type, timestamp, payload)
    }

    private void validate() {
        if (id == null || id.isEmpty()) {
            throw new RuntimeException("Id is required")
        }
        if (type == null) {
            throw new RuntimeException("Type is required")
        }
        if (timestamp == null) {
            throw new RuntimeException("Timestamp is required")
        }
    }

}
