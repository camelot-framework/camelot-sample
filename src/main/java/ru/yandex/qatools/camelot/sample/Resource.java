package ru.yandex.qatools.camelot.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.camelot.api.EventProducer;
import ru.yandex.qatools.camelot.api.annotations.Input;
import ru.yandex.qatools.camelot.sample.events.Event;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 26.06.14
 */
@SuppressWarnings("unused")
@Path("start")
public class Resource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Input
    public EventProducer input;

    @GET
    public Response start(@QueryParam("count") int count, @QueryParam("threads") int threads) {
        String msg = "Started with count " + count + " and " + threads + " threads successfully";
        logger.info(msg);
        input.produce(new Event(count, threads));
        return Response.ok(msg).build();
    }
}
