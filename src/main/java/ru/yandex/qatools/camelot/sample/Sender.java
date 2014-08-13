package ru.yandex.qatools.camelot.sample;

import ru.yandex.qatools.camelot.api.ClientMessageSender;
import ru.yandex.qatools.camelot.api.EventProducer;
import ru.yandex.qatools.camelot.api.annotations.Aggregate;
import ru.yandex.qatools.camelot.api.annotations.ClientSender;
import ru.yandex.qatools.camelot.api.annotations.Filter;
import ru.yandex.qatools.camelot.api.annotations.OnTimer;
import ru.yandex.qatools.camelot.api.annotations.Output;
import ru.yandex.qatools.camelot.sample.events.Event;
import ru.yandex.qatools.camelot.sample.events.State;
import ru.yandex.qatools.fsm.annotations.FSM;
import ru.yandex.qatools.fsm.annotations.OnException;
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
@Transitions(
        @Transit(on = Event.class)
)
public class Sender extends AbstractPlugin {

    @Output
    public EventProducer out;

    @ClientSender
    private ClientMessageSender client;

    @OnTransit
    public void message(Event event) throws InterruptedException {
        out.produce(event);
    }

    @OnTimer(cron = "*/10 * * * * ?", perState = false)
    public void sendSomethingToClient() {
        client.send(new Event(2, 123));
    }

}
