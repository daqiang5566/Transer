package com.scott.transer.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2017/3/15.<p>
 * <p>Email:     shijl4@lenovo.com<p>
 * <p>Describe:
 */

public class OkHttpProxy {

    private static OkHttpClient mClient;

    private OkHttpProxy() {

    }

    private synchronized static void _initClient() {
        mClient = new OkHttpClient.Builder()
                .sslSocketFactory(SsX509TrustManager.createSSLSocketFactory())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .build();
    }

    public static OkHttpClient getClient() {
        if(mClient == null) {
            _initClient();
        }
        return mClient;
    }
}
