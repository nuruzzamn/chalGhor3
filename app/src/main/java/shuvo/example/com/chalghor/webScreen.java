package shuvo.example.com.chalghor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class webScreen extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_screen);


        // Get the application context
        mContext = getApplicationContext();
        mActivity = webScreen.this;

        // Get the widget reference from XML layout
        //  mCLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

      /*  AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);

        builder.setTitle("MAKE SURE YOU ARE CONNECTED WITH INTERNET.");
        //builder.setMessage("");
        builder.setCancelable(true);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something when want to stay in the app
               // Toast.makeText(mContext," THANK YOU ",Toast.LENGTH_LONG).show();

                mWebView = (WebView) findViewById(R.id.web_view);

                mWebView.setWebViewClient( new WebViewClient());
                mWebView.loadUrl("https://CHALGHOR.COM");
                mWebView.getSettings().setJavaScriptEnabled(true);
                mWebView.getSettings().setSupportZoom(true);
                mWebView.getSettings().setBuiltInZoomControls(true);
                mWebView.getSettings().setDisplayZoomControls(true);


                webScreen.super.onBackPressed();
            }
        });

        // Create the alert dialog using alert dialog builder
        AlertDialog dialog = builder.create();

        // Finally, display the dialog when user press back button
        dialog.show();*/
        Toast.makeText(mContext," Make sure you are connected with internet ",Toast.LENGTH_LONG).show();

        mWebView = (WebView) findViewById(R.id.web_view);

        mWebView.setWebViewClient( new WebViewClient());
        mWebView.loadUrl("https://chalghor.com/");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(true);

    }

    protected void showAppExitDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);

        builder.setTitle("Please Confirm");
        builder.setMessage("No Back History Found, Want To Exit The App?");
        builder.setCancelable(true);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something when user want to exit the app
                // Let allow the system to handle the event, such as exit the app
                webScreen.super.onBackPressed();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something when want to stay in the app
                Toast.makeText(mContext," THANK YOU ",Toast.LENGTH_LONG).show();
            }
        });

        // Create the alert dialog using alert dialog builder
        AlertDialog dialog = builder.create();

        // Finally, display the dialog when user press back button
        dialog.show();
    }

    @Override
    public void onBackPressed(){
        if(mWebView.canGoBack()){
            // If web view have back history, then go to the web view back history
            mWebView.goBack();
            // Snackbar.make(mCLayout,"Go to back history",Snackbar.LENGTH_LONG).show();
        }else {
            // Ask the user to exit the app or stay in here
            showAppExitDialog();
        }
    }
}