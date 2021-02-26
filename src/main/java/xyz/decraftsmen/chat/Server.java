package xyz.decraftsmen.chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @autor nks
 * @date 21/02/22
 */

enum ConnectionType {
    ONE_TO_ONE,
    ONE_TO_MANY,
    STREAM
}

public class Server implements Setup {

    private class OneToOneConnection extends Server {
        private OneToOneConnection(){
            super();
        }

        @Override
        public void startRunning() {
            super.startRunning();
        }
    }

    private class OneToManyConnection extends Server {
        private OneToManyConnection() {
            super();
        }

        @Override
        public void startRunning() {
            super.startRunning();
        }

        @Override
        public void waitForConnection() {
            super.waitForConnection();
        }

    }

    private class LiveStreamConnection extends Server {
        private LiveStreamConnection(){
            super();
        }

    }


    private ObjectOutputStream outputStream;

    private ObjectInputStream inputStream;

    private ServerSocket server;

    private Socket socket;

    private int port = 3030;

    private int backlog = 100;

    private static ConnectionType type = ConnectionType.ONE_TO_ONE;

    private static Server instance;

    public static Server getInstance()
        throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException{

        if (instance==null){
            synchronized (Server.class){
                if (instance==null){
                    Server server = new Server();
                    switch (type){
                        case ONE_TO_ONE:
                            instance = server;
                            break;
                        case ONE_TO_MANY:
                            Constructor<OneToOneConnection> toOneConnectionConstructor =
                                    OneToOneConnection.class.getDeclaredConstructor(Server.class);
                            toOneConnectionConstructor.setAccessible(true);
                            instance = toOneConnectionConstructor.newInstance(server);
                            break;
                        case STREAM:
                            Constructor<LiveStreamConnection> toLiveStreamConnectionConstructor =
                                    LiveStreamConnection.class.getDeclaredConstructor(Server.class);
                            toLiveStreamConnectionConstructor.setAccessible(true);
                            instance = toLiveStreamConnectionConstructor.newInstance(server);
                    }
                }
            }
        }

        return instance;
    }

    private Server(){
        super();
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    @Override
    public void stageApp() {

    }

    @Override
    public void startRunning() {

    }

    @Override
    public void waitForConnection() {

    }

    @Override
    public void setupStreams() {

    }

    @Override
    public void whileChatting() {

    }

    @Override
    public void closeStreams() {

    }

    @Override
    public void showMessage() {

    }

    @Override
    public void sendMessage() {

    }
}
