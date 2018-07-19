package danilo.laks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

/**
 * Created by ChUd0 on 14.07.2018.
 */
@Controller

public class URLmapper {

    private static final Logger log = LogManager.getLogger(URLmapper.class);


    @RequestMapping(
            path = "process",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> process(@RequestBody Map<String, Object> payload)
    {
        System.out.println("process");
        if(payload.containsKey("round"))
            System.out.println(payload.get("round"));

        return  new ResponseEntity<String>( HttpStatus.OK);
    }



    @RequestMapping(
            value = "csgo",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> csgoStatus(@RequestBody Map<String, Object> payload)  {

        System.out.println("csgo");
        System.out.println(payload);
        return  ResponseEntity.ok().build();
    }







    @RequestMapping(
            path = "chat",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> chat()
    {
        System.out.println("SEE chat");
        return  ResponseEntity.ok().build();
    }

    @RequestMapping(
            path = "say",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> say()
    {
        System.out.println("SEE say");

        return  new ResponseEntity<String>(HttpStatus.OK);
    }


}
