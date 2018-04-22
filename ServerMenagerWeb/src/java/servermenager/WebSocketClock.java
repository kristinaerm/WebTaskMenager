/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermenager;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ServerEndpoint("/clock")
public class WebSocketClock {


    private static ScheduledExecutorService timer =
            Executors.newSingleThreadScheduledExecutor();


    @OnMessage
public void onMessage(String secs, Session session) {
        System.out.println("seeecs: " + secs);
        int timeInSeconds = Integer.parseInt(secs);
        timer.schedule(() -> sendTimeToAll(session), timeInSeconds, TimeUnit.SECONDS);

    }

    private void sendTimeToAll(Session session) {
        try {
            session.getBasicRemote().sendText("Answer From Server");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

