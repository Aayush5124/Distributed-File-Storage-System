package com.example.project.node;

public class NodeInfo {
    private String nodeId;
    private String host; // Assuming this is the IP address
    private int port;

    // Constructor
    public NodeInfo(String nodeId, String host, int port) {
        this.nodeId = nodeId;
        this.host = host;
        this.port = port;
    }

    // Getter for nodeId
    public String getNodeId() {
        return nodeId;
    }

    // Setter for nodeId
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    // Getter for host (IP address)
    public String getHost() {
        return host;
    }

    // Setter for host (IP address)
    public void setHost(String host) {
        this.host = host;
    }

    // Getter for port
    public int getPort() {
        return port;
    }

    // Setter for port
    public void setPort(int port) {
        this.port = port;
    }

    // Method to get the IP address
    public String getIpAddress() {
        return host; // Assuming host is the IP address
    }
}
