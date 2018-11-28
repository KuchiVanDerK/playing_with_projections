package projections.model.projections

import be.playing.with.projections.model.Event
import be.playing.with.projections.model.EventType
import projections.EventBuilder

import java.time.LocalDateTime

class EventStreamFactory {

    static List<Event> buildSingleQuestionEventSream() {
        int eventId = 1
        return [buildPlayerHasRegistered(eventId++),
                buildGameWasOpened(eventId++),
                buildPlayerJoinedTeamEvent(eventId++),
                buildGameStarted(eventId++),
                buildQuestionWasAsked(eventId++),
                buildAnswerGiven(eventId++),
                buildQuestionWasCompleted(eventId++),
                buildGameWasFinished(eventId)]
    }

    static List<Event> buildBasicQuizEventSream() {
        int eventId = 1
        return [buildPlayerHasRegistered(eventId++),
                buildPlayerHasRegistered(eventId++),
                buildPlayerHasRegistered(eventId++),
                buildPlayerJoinedTeamEvent(eventId++),
                buildPlayerJoinedTeamEvent(eventId++),
                buildPlayerJoinedTeamEvent(eventId++),
                buildGameStarted(eventId++),
                buildQuestionWasAsked(eventId++),
                buildAnswerGiven(eventId++),
                buildAnswerGiven(eventId++),
                buildQuestionWasCompleted(eventId++),
                buildQuestionWasAsked(eventId++),
                buildAnswerGiven(eventId++),
                buildQuestionWasCompleted(eventId++),
                buildQuestionWasAsked(eventId++),
                buildAnswerGiven(eventId++),
                buildQuestionWasCompleted(eventId)]
    }

    private static Event buildPlayerJoinedTeamEvent(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.PLAYER_JOINED_GAME)
                .build()
    }

    private static Event buildPlayerHasRegistered(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.PLAYER_HAS_REGISTERED)
                .build()
    }

    private static Event buildQuestionWasAsked(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.QUESTION_WAS_ASKED)
                .build()
    }

    private static Event buildGameStarted(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.GAME_WAS_STARTED)
                .build()
    }

    private static Event buildAnswerGiven(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.ANSWER_WAS_GIVEN)
                .build()
    }

    private static Event buildQuestionWasCompleted(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.QUESTION_WAS_COMPLETED)
                .build()
    }

    private static Event buildGameWasOpened(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.GAME_WAS_OPENED)
                .build()
    }

    private static Event buildGameWasFinished(int id) {
        return EventBuilder.newBuilder()
                .withId("Event_" + id)
                .withTimestamp(LocalDateTime.now())
                .withType(EventType.GAME_WAS_FINISHED)
                .build()
    }

}
