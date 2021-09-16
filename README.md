# CS4262 Distributed Systems - Group Project - Chat Client

The chat client is executed as follows:

`java -jar client.jar -h server_address [-p server_port] -i identity [-d]`

Square brackets ([]) are used to indicate optional arguments.

`server_address` corresponds to the ip address or hostname of the server to which the client is connecting to.

`server_port` corresponds to the port in which the server is listening for incoming client connections. The default server_port is 4444.

`identity` corresponds to the client's identity (i.e. username) which must be unique in the entire system. If the identity already exists, the server will send a message to the client indicating the error and will then close the connection. If the identity doesn't exist, a connection is established and the server places the client on its MainHall chat room. More details on this are given later.

The `-d` option can be used to start the client in debug mode. This means that all the received and sent messages will be printed on the standard output.

The client user interface is command-line based and reads input from the standard input. Each line of input is terminated by a new line and is interpreted by the client as either a command or a message. If the line of input starts with a hash character "#" then it is interpreted as a command, otherwise it is interpreted as a message that should be broadcasted by the chat server to other clients in the same chat room. The list of commands supported by chat clients is as follows:

            #list
            #who
            #createroom roomid
            #joinroom roomid
            #deleteroom roomid
            #quit
Pressing Ctrl-C terminate chat clients and works similar to #quit.

Here is an example of how a client session may look:

    E:\>java -jar client.jar -h localhost -p 4444 -i Adel
    Adel moves to MainHall-s1
    [MainHall-s1] Adel> #createroom comp90015
    [MainHall-s1] Adel> Room comp90015 is created.
    [MainHall-s1] Adel> Adel moves from MainHall-s1 to comp90015
    [comp90015] Adel> Maria moves from MainHall-s1 to comp90015
    [comp90015] Adel> We have a new comer to the room, Hi Maria!
    [comp90015] Adel> Maria: Hi everybody!
    [comp90015] Adel> Maria: Bye
    [comp90015] Adel> Maria moves from comp90015 to MainHall-s1
    [comp90015] Adel> #deleteroom comp90015
    [comp90015] Adel> Room comp90015 is deleted.
    [comp90015] Adel> Adel moves from comp90015 to MainHall-s1
    [MainHall-s1] Adel> Maria moves from MainHall-s1 to jokes
    [MainHall-s1] Adel> #quit
    [MainHall-s1] Adel> Adel quits
    
A client may receive messages at any time, and these will be written to the standard output as soon as they are received, even if the client is in the middle of typing a message.

# Acknowledgements
This chat client code has been inspired by the Group Project designed for Distributed Systems course at The University of Melbourne by Dr. Aaron Harwood et. al.
