package nl.easthome.graalvmdemo.models;

public class HostResponseMessage {

    String nodeName;
    public HostResponseMessage() {
    }

    public HostResponseMessage(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }
}
