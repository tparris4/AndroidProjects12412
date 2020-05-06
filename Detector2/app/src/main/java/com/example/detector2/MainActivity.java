package com.example.detector2;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static android.net.wifi.WifiConfiguration.Status.strings;
import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    public ProgressBar mProgress;
    private EditText mPhraseBox;
    private EditText Text1;
    private TextView mResult;
    private Button buttonClick;
    private TextView mResult2;
    private ArrayList<String> Array1;
    private JSONArray documents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar) (findViewById(R.id.Progress));
        mProgess.setVisibility(View.GONE);
        EditText mPhraseBox = (EditText) (findViewById(R.id.termToAnalyze));
        mProgress.setVisibility(View.GONE);
        mResult = (TextView) (findViewById(R.id.ResultText));

        documents = new JSONArray();
        Array1 = new ArrayList<>();


        buttonClick = (Button) findViewById(R.id.Button);
        buttonClick.setOnClickListener(MainActivity.this);


    }

    public static String getResponseFromHttpUrl(String url) throws IOException {
        URL theURL = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) theURL.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    private class FindSentimentTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String toReturn = "DID NOT WORK";
            try {
                toReturn = getResponseFromHttpUrl(strings[0]);

            } catch (Exception e) {
                Log.d("ErrorInApp", "exception on get Response from HTTP call" + e.getMessage());
            }
            return toReturn;
        }

        @Override
        protected void OnPostExecute(String sentimentData) {
            mProgress.setVisibility(View.GONE);
            mResult.setText(sentimentData);

            int x = 5;
            x = x + 1;
            /*P+:strong positive
            P: positive
            NEU: neutral
            N+: strong negative
            NONE: without sentiment*/
            try {
                JSONObject sentimentJSON = new JSONObject(sentimentData);
                TextView Result2 = ((TextView) findViewById(R.id.ResultText2));
                Result2.setText(sentimentJSON.toString());

                String scoreTag = sentimentJSON.get("score_tag").toString();
                JSONObject score = sentimentJSON.getJSONObject("score_tag");
                TextView Result3 = ((TextView) findViewById(R.id.ResultText3));
                Result3.setText(score.toString());

                String confNum = sentimentJSON.get("confidence").toString();
                JSONObject confidence = sentimentJSON.getJSONObject("confidence");
                TextView Result4 = ((TextView) findViewById(R.id.ResultText4));
                Result4.setText(confidence.toString());

                String ironyM = sentimentJSON.get("irony").toString();
                JSONObject irony = sentimentJSON.getJSONObject("irony");
                TextView Result5 = ((TextView) findViewById(R.id.ResultText5));
                Result5.setText(irony.toString());

                mProgress.setVisibility(View.GONE);

            } catch (JSONException e) {
                Log.e("Dectector2", "unexpected JSON exception", e);

            }


        }
    }

    private class FindArticle extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String toReturn = "DID NOT WORK";

            try {
                toReturn = getResponseFromHttpUrl(strings[0]);

            } catch (Exception e) {
                Log.d("ErrorInApp", "exception on get Response from HTTP call" + e.getMessage());
            }
            return toReturn;
        }

        @Override
        protected void onPostExecute(String jsontoParse) {

            try {
                JSONObject jsonObject2 = new JSONObject(jsontoParse);
                documents = jsonObject2.getJSONObject("response").getJSONArray("docs");
                for (int i = 0; i < documents.length(); i++) {
                    JSONObject obj = documents.getJSONObject(i);
                    Array1.add(obj.get("peak").toString());
                }
                mResult2.setText(Array1.toString());
            } catch (Exception ignored) {

            }
        }

    }

    public void onClick(View view) {
        if (view == buttonClick) {
            public void ArticleSearching()
            {

                Uri Article = Uri.parse("https://api.nytimes.com/svc/search/v2/articlesearch.json").buildUpon()
                        .appendQueryParameter("api-key", "FZcVbsqQU1fNovayZnLm858dvSGT3JoM")
                        .appendQueryParameter("q", mResult2.getText().toString())
                        .build();

                new FindArticle().execute(Article.toString());


                Uri builtUri2 = Uri.parse("https://api.meaningcloud.com/sentiment-2.1").buildUpon()
                        .appendQueryParameter("key", "5cefecfee765dde6c9c943db4c891c88")
                        .appendQueryParameter("txt", Array1.toString())
                        .appendQueryParameter("lang", "en")
                        .build();
                mProgress.setVisibility(View.VISIBLE);
                new FindSentimentTask().execute(builtUri2.toString());
            }
        }
    }
}


