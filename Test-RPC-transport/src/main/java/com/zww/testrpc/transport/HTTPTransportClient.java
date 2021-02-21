package com.zww.testrpc.transport;

import com.zww.testrpc.Peer;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.HttpConnection;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zww
 * @date 2021/2/7 15:45
 */

public class HTTPTransportClient implements TransportClient {
    private String url;
    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":"
                + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpCnn = (HttpURLConnection) new URL(url).openConnection();
            httpCnn.setDoOutput(true);
            httpCnn.setDoInput(true);
            httpCnn.setUseCaches(false);
            httpCnn.setRequestMethod("POST");

            httpCnn.connect();
            IOUtils.copy(data,httpCnn.getOutputStream());

            int resultCode = httpCnn.getResponseCode();
            if ((resultCode == HttpURLConnection.HTTP_OK))
                return httpCnn.getInputStream();
            else
                return httpCnn.getErrorStream();
        } catch (IOException e) {
           throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
