package com.example.tasoskoskeridis.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Socket client;
    private PrintWriter printwriter;

    private static final int SERVERPORT = 12345;
    private static final String SERVER_IP = "192.168.1.4";

    private TextView tvClientMsg,tvServerIP,tvServerPort;
    private final int SERVER_PORT = 8080; //Define the server port



    final Context context = this; //den 3erw ti kanei pantos exei sxesi me to aplo click se koumpi kai alertbox
    private int buttonToChangeColor;
    private EditText textField,logTextField;
    private Button button;
    private Button button2;
    private String message,logMessage;
    private String tableNum;
    private View Button1;       //DIMIOURGO TO CONTEXT MENU KAI ANALOGA ME TO KOUMPI POU PATIETE PERNEI KAPOS KAI TO ANALOGO VIEW  DEN KSERW GIATI TA DILOSA AFTA ALLA DOULEVOUN
    private View Button2;
    private View Button3;
    private View Button4;
    private View Button5;
    private View Button6;
    private View Button7;
    private View Button8;
    private View Button9;
    private View Button10;
    //**    apo8ikevei ta anomata kratisewn DOMI= ONOMA + table number
    String reserveB1,reserveB2,reserveB3,reserveB4,reserveB5,reserveB6,reserveB7,reserveB8,reserveB9,reserveB10;

    //**
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //get a reference to the view for pressing
        Button1 = (Button)findViewById(R.id.button1);
        //register if for context
        registerForContextMenu(Button1);
        Button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(Button2);
        Button3 = (Button) findViewById(R.id.button3);
        registerForContextMenu(Button3);
        Button4 = (Button) findViewById(R.id.button4);
        registerForContextMenu(Button4);
        Button5 = (Button) findViewById(R.id.button5);
        registerForContextMenu(Button5);
        Button6 = (Button) findViewById(R.id.button6);
        registerForContextMenu(Button6);
        Button7 = (Button) findViewById(R.id.button7);
        registerForContextMenu(Button7);
        Button8 = (Button) findViewById(R.id.button8);
        registerForContextMenu(Button8);
        Button9 = (Button) findViewById(R.id.button9);
        registerForContextMenu(Button9);
        Button10 = (Button) findViewById(R.id.button10);
        registerForContextMenu(Button10);


        textField = (EditText) findViewById(R.id.messageText); // reference to the text field
        button = (Button) findViewById(R.id.sendButton); // reference to the send button

        // Button press event listener   stelnei oti exei stalei teleftea
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                message = textField.getText().toString(); // get the text message on the text field
                textField.setText(""); // Reset the text field to blank
                SendReservationMessage sendMessageTask = new SendReservationMessage();
                sendMessageTask.execute();
            }
        });




        Button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");
                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB1)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB2)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB3)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB4)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB5)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB6)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB7)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB8)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB9)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        Button10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Κράτηση");

                // set dialog message
                alertDialogBuilder
                        .setMessage(reserveB10)
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        tvClientMsg = (TextView) findViewById(R.id.textViewClientMessage);
        tvServerIP = (TextView) findViewById(R.id.textViewServerIP);
        tvServerPort = (TextView) findViewById(R.id.textViewServerPort);
        tvServerPort.setText(Integer.toString(SERVER_PORT));
        //Call method
        getDeviceIpAddress();
        //New thread to listen to incoming connections
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //Create a server socket object and bind it to a port
                    ServerSocket socServer = new ServerSocket(SERVER_PORT);
                    //Create server side client socket reference
                    Socket socClient = null;
                    //Infinite loop will listen for client requests to connect
                    while (true) {
                        //Accept the client connection and hand over communication to server side client socket
                        socClient = socServer.accept();
                        //For each client new instance of AsyncTask will be created
                        ServerAsyncTask serverAsyncTask = new ServerAsyncTask();
                        //Start the AsyncTask execution
                        //Accepted client socket object will pass as the parameter
                        serverAsyncTask.execute(new Socket[] {socClient});
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /**
     * Get ip address of the device
     */
    public void getDeviceIpAddress() {
        try {
            //Loop through all the network interface devices
            for (Enumeration<NetworkInterface> enumeration = NetworkInterface
                    .getNetworkInterfaces(); enumeration.hasMoreElements();) {
                NetworkInterface networkInterface = enumeration.nextElement();
                //Loop through all the ip addresses of the network interface devices
                for (Enumeration<InetAddress> enumerationIpAddr = networkInterface.getInetAddresses(); enumerationIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumerationIpAddr.nextElement();
                    //Filter out loopback address and other irrelevant ip addresses
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getAddress().length == 4) {
                        //Print the device ip address in to the text view
                        tvServerIP.setText(inetAddress.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            Log.e("ERROR:", e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * AsyncTask which handles the commiunication with clients
     */
    class ServerAsyncTask extends AsyncTask<Socket, Void, String> {
        //Background task which serve for the client
        @Override
        protected String doInBackground(Socket... params) {
            String result = null;
            //Get the accepted socket object
            Socket mySocket = params[0];
            try {
                //Get the data input stream comming from the client
                InputStream is = mySocket.getInputStream();
                //Get the output stream to the client
                PrintWriter out = new PrintWriter(
                        mySocket.getOutputStream(), true);
                //Write data to the data output stream
                out.println("Hello from server");
                //Buffer the data input stream
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                //Read the contents of the data buffer
                result = br.readLine();

                //Close the client connection
                mySocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            //After finishing the execution of background task data will be write the text view
            tvClientMsg.setText(s);
        }
    }


    private class SendReservationMessage extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {

                client = new Socket(SERVER_IP, SERVERPORT); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);

                //stile paketo kratisis domi paketou px trapezi noumero 4 =   r4
                String reservationPacket = "r" + tableNum;
                printwriter.write(reservationPacket); // write the message to output stream

                printwriter.flush();
                printwriter.close();
                client.close(); // closing the connection

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == Button1){
            tableNum = "1";
            buttonToChangeColor = 1;
        }
        if (v == Button2) {
            tableNum = "2"; //GIA KAPIO LOGO DEN EMFANIZETE STON SERVER AMA VALO INTEGER DEN KSERW GIATI GAMIETE TO ANDROID KAI H C# !!!
            buttonToChangeColor = 2;
        }
        if (v == Button3){
            tableNum = "3";
            buttonToChangeColor = 3;
        }
        if (v == Button4){
            tableNum = "4";
            buttonToChangeColor = 4;
        }
        if (v == Button5){
            tableNum = "5";
            buttonToChangeColor = 5;
        }
        if (v == Button6){
            tableNum = "6";
            buttonToChangeColor = 6;
        }
        if (v == Button7){
            tableNum = "7";
            buttonToChangeColor = 7;
        }
        if (v == Button8){
            tableNum = "8";
            buttonToChangeColor = 8;
        }
        if (v == Button9){
            tableNum = "9";
            buttonToChangeColor = 9;
        }
        if (v == Button10){
            tableNum = "10";
            buttonToChangeColor = 10;
        }
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
    }



    public boolean onContextItemSelected(MenuItem item) {
        //find out which menu item was pressed
        SendReservationMessage sendMessageTask = new SendReservationMessage();
        switch (item.getItemId()) {
            case R.id.option1:
                if (buttonToChangeColor == 1){          //gia na allazei to color toy button molis pati8i h epilogi kane kratisi
                    Button1.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 2) {
                    Button2.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 3){
                    Button3.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 4){
                    Button4.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 5){
                    Button5.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 6){
                    Button6.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 7){
                    Button7.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 8){
                    Button8.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 9){
                    Button9.setBackgroundResource(R.drawable.button_closed_state);
                }
                if (buttonToChangeColor == 10){
                    Button10.setBackgroundResource(R.drawable.button_closed_state);
                }

                sendMessageTask.execute();
                return true;
            case R.id.option2:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);

                alert.setTitle("Κράτηση");
                alert.setMessage("Ονοματεπώνημο");

                // Set an EditText view to get user input
                final EditText input = new EditText(this);

                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String inputText = input.getText().toString();

                        if (buttonToChangeColor == 1){          //gia na allazei to color toy button molis pati8i h epilogi kane kratisi
                            reserveB1 = inputText;              //vazei ta prota 3 gramata tou onomatos p egine h kratisi sto button
                            Button p1_button = (Button)findViewById(R.id.button1);
                            p1_button.setText(inputText.substring(0, 3)+":1");
                            Button1.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 2) {
                            reserveB2 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button2);
                            p1_button.setText(inputText.substring(0, 3)+":2");
                            Button2.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 3){
                            reserveB3 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button3);
                            p1_button.setText(inputText.substring(0, 3)+":3");
                            Button3.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 4){
                            reserveB4 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button4);
                            p1_button.setText(inputText.substring(0, 3)+":4");
                            Button4.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 5){
                            reserveB5 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button5);
                            p1_button.setText(inputText.substring(0, 3)+":5");
                            Button5.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 6){
                            reserveB6 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button6);
                            p1_button.setText(inputText.substring(0, 3)+":6");
                            Button6.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 7){
                            reserveB7 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button7);
                            p1_button.setText(inputText.substring(0, 3)+":7");
                            Button7.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 8){
                            reserveB8 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button8);
                            p1_button.setText(inputText.substring(0, 3)+":8");
                            Button8.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 9){
                            reserveB9 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button9);
                            p1_button.setText(inputText.substring(0, 3)+":9");
                            Button9.setBackgroundResource(R.drawable.button_reserved_state);
                        }
                        if (buttonToChangeColor == 10){
                            reserveB10 = inputText;
                            Button p1_button = (Button)findViewById(R.id.button10);
                            p1_button.setText(inputText.substring(0, 3)+":10");
                            Button10.setBackgroundResource(R.drawable.button_reserved_state);
                        }

                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();
                doOptionTwo();
                return true;
            default:
                return false;
        }
    }
    private void doOptionOne() {
        Toast.makeText(this, "Option One Chosen...", Toast.LENGTH_LONG).show();

    }

    //method to execute when option two is chosen
    private void doOptionTwo() {
        Toast.makeText(this, "Option Two Chosen...", Toast.LENGTH_LONG).show();
    }






}

