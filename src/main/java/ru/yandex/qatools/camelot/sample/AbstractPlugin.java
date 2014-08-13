package ru.yandex.qatools.camelot.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.camelot.api.EventProducer;
import ru.yandex.qatools.camelot.api.annotations.Aggregate;
import ru.yandex.qatools.camelot.api.annotations.AggregationKey;
import ru.yandex.qatools.camelot.api.annotations.Input;
import ru.yandex.qatools.camelot.api.annotations.Output;
import ru.yandex.qatools.camelot.sample.events.Event;

import java.util.Random;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 13.08.14
 */
@Aggregate
public abstract class AbstractPlugin {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Input
    public EventProducer self;

    @Output
    public EventProducer out;

    @AggregationKey
    public String key(Event event) {
        String key = Integer.toString(new Random().nextInt(event.getThreads()));
        logger.info("Key: " + key);
        return key;
    }
}
