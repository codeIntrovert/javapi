import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.ProtocolException;

import java.net.URL;

import java.util.Scanner;


public class main {
    public static void MyGETRequest(String city) throws IOException {
        URL urlForGetRequest = new URL("https://catfact.ninja/"+city);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "parameter1"); // set userId its a sample here
        int responseCode = conection.getResponseCode();



        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            }
            in .close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        }

        else {
            System.out.println("REQUEST FAILED");
        }
    }
        public static void main(String[]x) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of your City[sayfactfortesting]: ");
            String cityName = sc.nextLine();

            main.MyGETRequest(cityName);
        }

    }

