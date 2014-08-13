package ru.yandex.qatools.camelot.sample;

import ru.yandex.qatools.camelot.api.annotations.Aggregate;
import ru.yandex.qatools.camelot.api.annotations.Filter;
import ru.yandex.qatools.camelot.sample.events.Event;
import ru.yandex.qatools.camelot.sample.events.State;
import ru.yandex.qatools.fsm.StopConditionAware;
import ru.yandex.qatools.fsm.annotations.FSM;
import ru.yandex.qatools.fsm.annotations.OnTransit;
import ru.yandex.qatools.fsm.annotations.Transit;
import ru.yandex.qatools.fsm.annotations.Transitions;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 26.06.14
 */
@SuppressWarnings("unused")
@Filter(instanceOf = {Event.class})
@FSM(start = State.class)
@Aggregate
@Transitions(
        @Transit(on = Event.class)
)
public class Receiver extends AbstractPlugin implements StopConditionAware<State, Event> {

    @OnTransit
    public void message(State state, Event event) throws InterruptedException {
        if (event.getCount() > 0) {
            Event next = new Event(event.getCount() - 1, event.getThreads());
            self.produce(next);
            out.produce(next);
        }
    }

    @Override
    public boolean isStopRequired(State state, Event event) {
        return event.getCount() == 0;
    }
}
