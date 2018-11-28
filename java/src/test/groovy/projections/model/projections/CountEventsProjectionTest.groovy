package projections.model.projections

import be.playing.with.projections.model.projections.CountEventsProjection
import spock.lang.Specification
import spock.lang.Unroll

import static projections.model.projections.EventStreamFactory.*

class CountEventsProjectionTest extends Specification {

    def 'project single question quiz'() {

        given:
        def projection = new CountEventsProjection()

        and:
        def nrOfPlayers = projection.project(buildSingleQuestionEventSream())

        expect:
        nrOfPlayers == 8
    }


    def 'project basic quiz'() {

        given:
        def projection = new CountEventsProjection()

        and:
        def nrOfPlayers = projection.project(buildBasicQuizEventSream())

        expect:
        nrOfPlayers == 17
    }


    @Unroll
    def 'project #description quiz parameterized'() {

        given:
        def projection = new CountEventsProjection()

        and:
        def nrOfPlayers = projection.project(events)

        expect:
        nrOfPlayers == count

        where:
        description       | events                                             | count
        'single question' | buildSingleQuestionEventSream() | 8
        'basic'           | buildBasicQuizEventSream()      | 17
    }
}