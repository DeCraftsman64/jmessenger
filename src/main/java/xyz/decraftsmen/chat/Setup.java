package xyz.decraftsmen.chat;

import javafx.stage.Stage;
/**
 * @autor nks
 * @date 21/02/22
 */
public interface Setup {
    void stageApp();
    void startRunning();
    void waitForConnection();
    void setupStreams();
    void whileChatting();
    void closeStreams();
    void showMessage();
    void sendMessage();

}
