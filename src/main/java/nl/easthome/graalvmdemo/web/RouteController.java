package nl.easthome.graalvmdemo.web;

import nl.easthome.graalvmdemo.models.HostResponseMessage;
import nl.easthome.graalvmdemo.models.SimpleResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class RouteController {

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<SimpleResponseMessage> getSimple() {
        return new ResponseEntity<>(new SimpleResponseMessage(String.format("Hello?")), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}", produces = "application/json")
    public ResponseEntity<SimpleResponseMessage> getThing(@PathVariable String name){
        return new ResponseEntity<>(new SimpleResponseMessage(String.format("Hello, %s!", StringUtils.capitalize(name))), HttpStatus.OK);
    }
    @GetMapping(path = "/host", produces = "application/json")
    public ResponseEntity<HostResponseMessage> getHost() throws UnknownHostException {
        return new ResponseEntity<>(new HostResponseMessage(String.format(StringUtils.capitalize(InetAddress.getLocalHost().getHostName()))), HttpStatus.OK);
    }
}
