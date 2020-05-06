package com.zybooks.didyouhaveagoodyearproj;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private EditText text;
    private EditText phraseBox;
    private TextView res;
    private TextView res2;
    private ArrayList<String> articArray;
    private JSONArray docs;
    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.searchButton);
        phraseBox = findViewById(R.id.phrase);

        res = findViewById(R.id.result);
        res2 = findViewById(R.id.secondResult);

        progressBar = findViewById(R.id.Progress);
        progressBar.setVisibility(View.GONE);
        text = findViewById(R.id.termToAnalyze);
        docs = new JSONArray();
        articArray = new ArrayList<>();

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
                Log.d("ErrorInApp", "exception on get Response from HTTP");
            }

            return toReturn;
        }

        @Override
        protected void onPostExecute(String jsonParse) {

            res.setText(jsonParse);
            String score_tag;
            String confidence;
            String irony;
            try {
                JSONObject jsonObject2 = new JSONObject(jsonParse);
                score_tag = jsonObject2.get("score_tag").toString();
                confidence = jsonObject2.get("confidence").toString();
                irony = jsonObject2.get("irony").toString();

                res.setText("score: " + score_tag + "\n" + "confidence: " + confidence + "\n" + "irony: " + irony);

                progressBar.setVisibility(View.GONE);

            } catch (Exception e) {

            }
        }



        }
    private class FindArticleTask extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... strings) {
            String toReturn= "DID NOT WORK";

            try
            {
                toReturn=getResponseFromHttpUrl(strings[0]);

            }catch (Exception e)
            {
                Log.d("ErrorInApp","exception on get Response from HTTP call" + e.getMessage());
            }
            return toReturn;
        }

        @Override
        protected void onPostExecute(String jsontoParse)
        {

            try
            {
                JSONObject jsonObject2 = new JSONObject(jsontoParse);
                docs = jsonObject2.getJSONObject("response").getJSONArray("docs");
                for(int i =0;i<docs.length();i++)
                {
                    JSONObject obj = docs.getJSONObject(i);
                    articArray.add(obj.get("peak").toString());
                }
                res2.setText(articArray.toString());
            }catch(Exception ignored)
            {

            }
        }

    }

    public void ArticleSearching()
    {
        Uri ArticleAPI = Uri.parse("https://api.nytimes.com/svc/search/v2/articlesearch.json").buildUpon()
                .appendQueryParameter("api-key","AIn7LJ795uFbQM6s3rNoFG07V8lGITzL")
                .appendQueryParameter("q",phraseBox.getText().toString())
                .build();

        new FindArticleTask().execute(ArticleAPI.toString());
    }
    public void SentimentApiSearch()
    {
        Uri builtUri2 = Uri.parse("https://api.meaningcloud.com/sentiment-2.1").buildUpon()
                .appendQueryParameter("key","5cefecfee765dde6c9c943db4c891c88")
                .appendQueryParameter("txt",articArray.toString())
                .appendQueryParameter("lang", "en").build();
        new FindSentimentTask().execute(builtUri2.toString());
    }

    public void buttonClicked(View view)
    {
        ArticleSearching();
        SentimentApiSearch();
    }

}
