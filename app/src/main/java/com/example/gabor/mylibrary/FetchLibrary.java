package com.example.gabor.mylibrary;

/**
 * Created by gabor on 3/26/2017.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class FetchLibrary extends AsyncTask<Void, Void, String> {

    private final String LOG_TAG = FetchLibrary.class.getSimpleName();
    ArrayList<Object> books = new ArrayList<>();
    public AsyncResponse delegate = null;
    //Context applicationContext = MainActivityFragment.getContextOfApplication();
    String baseUrl;
    Class claz;


    public FetchLibrary(AsyncResponse delegate, String baseUrl, Class claz){
        this.delegate = delegate;
        this.baseUrl = baseUrl;
        this.claz = claz;
    }

    private ArrayList<Object> getMovieDataFromJson2(String forecastJsonStr)
            throws JSONException {

        // These are the names of the JSON objects that need to be extracted.
        final String OWM_RESULT = "data";

        final String OWM_POSTER = "pageCount";
        final String OWM_TITLE = "name";
        final String OWM_OVERVIEW = "publishYear";
        final String OWM_VOTE = "imageSrc";
        final String OWM_RELEASE = "rowKey";

        JSONObject forecastJson = new JSONObject(forecastJsonStr);

        JSONArray weatherArray = forecastJson.getJSONArray(OWM_RESULT);

        books.clear();
        Book book;

        for(int i = 0; i < weatherArray.length(); i++) {
            JSONObject movieForecast = weatherArray.getJSONObject(i);
            int pict = movieForecast.getInt(OWM_POSTER);
            String title = movieForecast.getString(OWM_TITLE);
            int overview = movieForecast.getInt(OWM_OVERVIEW);
            String vote = movieForecast.getString(OWM_VOTE);
            String release = movieForecast.getString(OWM_RELEASE);

            //String complete_url = "https://images-na.ssl-images-amazon.com/images/I/" + pict;
            book = new Book();
            book.setOverview(pict);
            book.setTitle(title);
            book.setVote(overview);
            book.setImage(vote);
            book.setRelease(release);

            //Log.v("complete url", movie.getImage());
            books.add(book);
        }
        return books;
    }



    private ArrayList<Object> getMovieDataFromJson(String forecastJsonStr)
            throws JSONException {

        // These are the names of the JSON objects that need to be extracted.
        final String OWM_RESULT = "data";

        final String OWM_POSTER = "pageCount";
        final String OWM_TITLE = "name";
        final String OWM_OVERVIEW = "publishYear";
        final String OWM_VOTE = "imageSrc";
        final String OWM_RELEASE = "rowKey";

        JSONObject forecastJson = new JSONObject(forecastJsonStr);

        JSONArray weatherArray = forecastJson.getJSONArray(OWM_RESULT);

        books.clear();
        Book book;

        for(int i = 0; i < weatherArray.length(); i++) {
            JSONObject movieForecast = weatherArray.getJSONObject(i);
            int pict = movieForecast.getInt(OWM_POSTER);
            String title = movieForecast.getString(OWM_TITLE);
            int overview = movieForecast.getInt(OWM_OVERVIEW);
            String vote = movieForecast.getString(OWM_VOTE);
            String release = movieForecast.getString(OWM_RELEASE);

            //String complete_url = "https://images-na.ssl-images-amazon.com/images/I/" + pict;
            book = new Book();
            book.setOverview(pict);
            book.setTitle(title);
            book.setVote(overview);
            book.setImage(vote);
            book.setRelease(release);

            //Log.v("complete url", movie.getImage());
            books.add(book);
        }
        return books;
    }


    @Override
    protected String doInBackground(Void... params) {
        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;


//        // get settings using context from MainActivityFragment
//        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(applicationContext);
//        String unitType = sharedPrefs.getString(
//                applicationContext.getResources().getString(R.string.pref_units_key),
//                applicationContext.getResources().getString(R.string.pref_units_popular));

        //baseUrl = "http://friendlibrary.azurewebsites.net/api/book/list";
        //baseUrl = "http://friendlibrary.azurewebsites.net/api/book/list";

        try {
//            if(unitType.equals(applicationContext.getResources().getString(R.string.pref_units_popular)))
//                baseUrl = "http://api.themoviedb.org/3/movie/popular?api_key=c88f3eabe09958ae472c9cd7e20b38aa"; // popular/top_rated
//            else
//                baseUrl = "http://api.themoviedb.org/3/movie/top_rated?api_key=c88f3eabe09958ae472c9cd7e20b38aa";

            URL url = new URL(baseUrl);

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            forecastJsonStr = buffer.toString();

            System.out.print("\n\n\n"+forecastJsonStr+"\n\n\n");
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }

        return forecastJsonStr;

//        try {
//            return getMovieDataFromJson(forecastJsonStr);
//        } catch (JSONException e) {
//            Log.e(LOG_TAG, e.getMessage(), e);
//            e.printStackTrace();
//        }
//
//        return null;
    }

    @Override
    protected void onPostExecute(String strings) {
        super.onPostExecute(strings);

        ArrayList<Object> filip = null;
        try {
            filip = getMovieDataFromJson(strings);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        delegate.processFinish(filip);
    }


}