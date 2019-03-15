package com.forex.forex;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


@SpringBootApplication
public class ForexApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;
    private FXMLLoader fxmlLoader;

   static GETHistory getHistory;
    static String trading_api_host_demo = "api-demo.fxcm.com";
    static String trading_api_port = "443";
    static String demo_connection = "https://" + trading_api_host_demo + ":" + trading_api_port;
    static String login_token = "4458747d3627df480ed824cf4bef2acc5fa967f9";

    static Socket server_socket;
    static String bearer_access_token;
    static String charset = java.nio.charset.StandardCharsets.UTF_8.name();
    static String accountID = "D291049893";


    public static void main(String[] args) throws URISyntaxException {




       // SpringApplication.run(ForexResult.class, args);
        IO.Options options = new IO.Options();
        options.forceNew = true;
        final OkHttpClient client = new OkHttpClient(); options.webSocketFactory = client; options.callFactory = client;
        options.query = "access_token="+ login_token;

        server_socket = IO.socket(demo_connection, options);
        server_socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                bearer_access_token =  server_socket.id() + login_token;
                System.out.println("connected, Server Socket ID: " + server_socket.id());
                System.out.println("bearer token: " +" "+ bearer_access_token);
            }
        });


        server_socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
        public void call(Object... args) {
            bearer_access_token = "Bearer " + server_socket.id() + login_token;
            System.out.println("connected, Server Socket ID: " + server_socket.id());
            System.out.println("bearer token: " + "=" +" " + bearer_access_token);
                try {
                    getHistory. getHistoricalData(bearer_access_token);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } });
        server_socket.io().on(io.socket.engineio.client.Socket.EVENT_CLOSE, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("engine close");
                client.dispatcher().executorService().shutdown();
            }
        });


        server_socket.open();

        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(ForexApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<Candles> list =  getHistory. getHistoricalData(bearer_access_token);

        TableView<Candles> table = new TableView<Candles>();



        // Create column UserName (Data type of String).
        TableColumn<Candles, String> historyDate = new TableColumn<>("History Date");
        historyDate.setMinWidth(100);
        historyDate.setCellValueFactory(new PropertyValueFactory<>("historyDate"));


        TableColumn<Candles, Double> bidOpen = new TableColumn<>("Bid Open");
        bidOpen.setMinWidth(50);
        bidOpen.setCellValueFactory(new PropertyValueFactory<>("bidOpen"));

        TableColumn<Candles, Double> bidClose = new TableColumn<>("Bid Close");
        bidClose.setMinWidth(50);
        bidClose.setCellValueFactory(new PropertyValueFactory<>("bidclose"));

        TableColumn<Candles, Double> bidhigh = new TableColumn<>("Bid High");
        bidhigh.setMinWidth(50);
        bidhigh.setCellValueFactory(new PropertyValueFactory<>("bidhigh"));

        TableColumn<Candles, Double> bidlow = new TableColumn<>("Bid Low");
        bidlow.setMinWidth(50);
        bidlow.setCellValueFactory(new PropertyValueFactory<>("bidlow"));

        TableColumn<Candles, Double>  askOpen = new TableColumn<>("Ask Open");
        askOpen.setMinWidth(50);
        askOpen.setCellValueFactory(new PropertyValueFactory<>("askopen"));


        TableColumn<Candles, Double>  askClose = new TableColumn<>("Ask Close");
        askClose.setMinWidth(50);
        askClose.setCellValueFactory(new PropertyValueFactory<>("askclose"));


        TableColumn<Candles, Double>  askHigh = new TableColumn<>("Ask High");
        askHigh.setMinWidth(50);
        askHigh.setCellValueFactory(new PropertyValueFactory<>("askhigh"));

        TableColumn<Candles, Double>  askLow = new TableColumn<>("Ask Low");
        askLow.setMinWidth(50);
        askLow.setCellValueFactory(new PropertyValueFactory<>("asklow"));

        TableColumn<Candles, Double>  tickQty = new TableColumn<>("Ticket Qty");
        tickQty.setMinWidth(50);
        tickQty.setCellValueFactory(new PropertyValueFactory<>("tickqty"));






        // Create column Email (Data type of String).
       // TableColumn<Candles, String> emailCol//
                //= new TableColumn<Candles, String>("Email");









        // Defines how to fill data for each cell.
        // Get value from property of UserAccount. .

       // emailCol.setCellValueFactory(new PropertyValueFactory<>("bidOpen"));



        // Set Sort type for userName column
       // userNameCol.setSortType(TableColumn.SortType.DESCENDING);


        // Display row data

        table.setItems(list);

        table.getColumns().addAll(historyDate, bidOpen,bidClose,bidhigh,bidlow,askOpen,askClose,askHigh,askLow,tickQty);



        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        primaryStage.setTitle("FXCM DATA RENDERING");

        Scene scene = new Scene(root,  800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();




       /* TableView<Candles> table = new TableView<Candles>();

        // Create column UserName (Data type of String).
        TableColumn<Candles, String> userNameCol //
                = new TableColumn<Candles, String>("User Name");

        // Create column Email (Data type of String).
        TableColumn<Candles, String> emailCol//
                = new TableColumn<Candles, String>("Email");

        // Create column FullName (Data type of String).
        TableColumn<Candles, String> fullNameCol//
                = new TableColumn<Candles, String>("Full Name");

        // Create 2 sub column for FullName.
        TableColumn<Candles, String> firstNameCol //
                = new TableColumn<Candles, String>("First Name");

        TableColumn<Candles, String> lastNameCol //
                = new TableColumn<Candles, String>("Last Name");

        // Add sub columns to the FullName
        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);





        table.setItems(list);



        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);


        primaryStage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();*/

        //fxmlLoader.setLocation(getClass().getResource("/fxml/resultSample.fxml"));

       /* rootNode = fxmlLoader.load();

        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(rootNode, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();*/

    }
}