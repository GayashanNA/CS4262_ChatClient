package lk.ac.mrt.cse.cs4262.client;

import lk.ac.mrt.cse.cs4262.client.data.State;
import lk.ac.mrt.cse.cs4262.client.messaging.MessageReceiveThread;
import lk.ac.mrt.cse.cs4262.client.messaging.MessageSendThread;
import org.json.simple.parser.ParseException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static void main(String[] args) throws IOException, ParseException {
        Socket socket = null;
        String identity = null;
        boolean debug = false;
        try {
            //load command line args
            CmdLineValues values = new CmdLineValues();
            CmdLineParser parser = new CmdLineParser(values);
            try {
                parser.parseArgument(args);
                String hostname = values.getHost();
                identity = values.getIdentity();
                int port = values.getPort();
                debug = values.isDebug();
                socket = new Socket(hostname, port);
            } catch (CmdLineException e) {
                System.err.println("Error while parsing cmd line arguments: " + e.getLocalizedMessage());
            }

            State state = new State(identity, "");

            // start sending thread
            MessageSendThread messageSendThread = new MessageSendThread(socket, state, debug);
            Thread sendThread = new Thread(messageSendThread);
            sendThread.start();

            // start receiving thread
            Thread receiveThread = new Thread(new MessageReceiveThread(socket, state, messageSendThread, debug));
            receiveThread.start();

        } catch (UnknownHostException e) {
            System.out.println("Unknown host");
        } catch (IOException e) {
            System.out.println("Communication Error: " + e.getMessage());
        }
    }
}
