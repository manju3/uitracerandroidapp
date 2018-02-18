package com.cloudmpower.www.uiklario;

import android.widget.Toast;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class AppSocket {
    public static Socket socket;
    public AppSocket() {
        try {
            socket = IO.socket("https://tracersocket.klario.tech");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.connect();
    }

}
