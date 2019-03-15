package com.forex.forex;

import java.net.Socket;

public class APP {

    static String trading_api_host_demo = "api-demo.fxcm.com";
    static String trading_api_port = "443";
    static String demo_connection = "https://" + trading_api_host_demo + ":"+ trading_api_port;
    static String login_token = "4458747d3627df480ed824cf4bef2acc5fa967f9";
    static Socket server_socket;
    static String bearer_access_token;
    static String charset = java.nio.charset.StandardCharsets.UTF_8.name();
    static String accountID="D291049893";
}
