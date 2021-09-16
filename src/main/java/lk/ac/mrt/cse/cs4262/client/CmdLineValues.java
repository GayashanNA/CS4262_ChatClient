package lk.ac.mrt.cse.cs4262.client;

import org.kohsuke.args4j.Option;

public class CmdLineValues {
    @Option(required=true, name = "-h", aliases="--host", usage="Server host address")
    private String host;

    @Option(required=false, name="-p", aliases="--port", usage="Server port number")
    private int port = 4444;

    @Option(required=true, name = "-i", aliases="--identity", usage="Client identity")
    private String identity;

    @Option(required=false, name = "-d", aliases="--debug", usage="Debug mode")
    private boolean debug = false;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getIdentity() {
        return identity;
    }

    public boolean isDebug() {
        return debug;
    }
}
