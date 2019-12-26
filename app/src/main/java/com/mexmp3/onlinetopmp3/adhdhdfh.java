package com.mexmp3.onlinetopmp3;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.InputStream;

import static com.mexmp3.onlinetopmp3.hadfdfhafh.admob_id;
import static com.mexmp3.onlinetopmp3.hadfdfhafh.url_move;

public class adhdhdfh extends AppCompatActivity {
    private RelativeLayout banner;
    public com.google.android.gms.ads.AdView adView;
    public com.facebook.ads.AdView fbView;
    jtdfhdfgsdfds sharedPreference;

    Button viwRate;
    Button viwPravacy;
    Button viwShare;

    ImageButton viwsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.jjklhgfjjf);
        MobileAds.initialize(this, admob_id);
        banner = (RelativeLayout)findViewById(R.id.adViewContainer);
        sharedPreference = new jtdfhdfgsdfds(this);

        viwsearch = (ImageButton) findViewById( R.id.searchView );
        viwRate = (Button) findViewById( R.id.rate_id );
        viwPravacy = (Button) findViewById( R.id.pravacy_id );
        viwShare = (Button) findViewById( R.id.share_id );

        if (hadfdfhafh.active_ads.equals("fb")) {
            fbView = new com.facebook.ads.AdView(this, hadfdfhafh.id_banner, AdSize.BANNER_HEIGHT_50);
            AdSettings.addTestDevice("936f0142-9449-42bb-aaa0-0c8ef62f0d2b");
            banner.addView(fbView);
            fbView.loadAd();

        } else {
            adView = new com.google.android.gms.ads.AdView(this);
            adView.setAdUnitId(hadfdfhafh.id_banner);
            adView.setAdSize(com.google.android.gms.ads.AdSize.SMART_BANNER);
            banner.addView(adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }

        if (hadfdfhafh.st_popup.equals("a")) {
            setPop_up();
        }

        viwsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adhdhdfh.this, jdfhgdgsd.class);
                startActivity(i);
            }
        });

        viwRate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateApps();
            }
        } );
        viwPravacy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPolicy();
            }
        } );
        viwShare.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ShareApp();
        }
    } );
}

    public void showPolicy(){
        String txt;
        try {
            InputStream is = getAssets().open("pravacy.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            txt = new String(buffer);
        } catch (IOException ex) {
            return;
        }

        AlertDialog alertDialogPolicy = new AlertDialog.Builder(adhdhdfh.this).create();
        alertDialogPolicy.setTitle("Privacy Policy");
        alertDialogPolicy.setIcon(R.mipmap.ic_launcher);
        alertDialogPolicy.setMessage(txt);
        alertDialogPolicy.setButton(AlertDialog.BUTTON_POSITIVE, "Accept",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        sharedPreference.setApp_runFirst("NO");
                        dialog.dismiss();

                    }
                });
        alertDialogPolicy.setButton(AlertDialog.BUTTON_NEGATIVE, "Decline",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        warningpolicy();

                    }
                });
        alertDialogPolicy.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                warningpolicy();
            }
        });
        alertDialogPolicy.show();
    }

    public void warningpolicy() {
        if (sharedPreference.getApp_runFirst().equals("FIRST")) {
            AlertDialog alertDialogPolicy = new AlertDialog.Builder(adhdhdfh.this).create();
            alertDialogPolicy.setTitle("Policy Warning !");
            alertDialogPolicy.setIcon(R.mipmap.ic_launcher);
            alertDialogPolicy.setMessage("Please accept our policy before use this App.\nThank You.");
            alertDialogPolicy.setButton(AlertDialog.BUTTON_POSITIVE, "Restart",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent i = getBaseContext().getPackageManager()
                                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            finish();
                        }
                    });
            alertDialogPolicy.setButton(AlertDialog.BUTTON_NEGATIVE, "Quit",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            System.exit(1);
                            finish();
                        }
                    });
            alertDialogPolicy.show();
        }
    }
    public void rateApps(){
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id="
                            + getPackageName())));
        }
    }
    private void ShareApp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction( Intent.ACTION_SEND );
        sendIntent.putExtra( Intent.EXTRA_TEXT, getResources().getString( R.string.share_msg ) + getPackageName() );
        sendIntent.setType( "text/plain" );
        startActivity( sendIntent );
    }
    @Override
    public void onBackPressed() {
        ExitApp();
    }

    private void ExitApp() {
            android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(this);
            View dialogView = getLayoutInflater().inflate(R.layout.hgllgkdhk, null);
            dialogBuilder.setView(dialogView);
            ImageView imgExit = (ImageView) dialogView.findViewById(R.id.img_exit);
            ImageButton imgRare = (ImageButton) dialogView.findViewById(R.id.img_rate);
            final android.app.AlertDialog playDialog = dialogBuilder.create();
            imgRare.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id="
                                        + getPackageName())));

//                        playDialog.dismiss();
                    }
                }
            });
        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
                finish();
            }
        });
            playDialog.show();
        }

    private void setPop_up() {
        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.kljskjsasa, null);
        dialogBuilder.setView(dialogView);
        ImageView icon_up = (ImageView) dialogView.findViewById(R.id.ic_icon);
        Glide.with(this).load(hadfdfhafh.dt_icon).into(icon_up);
        ImageView icon_banner = (ImageView) dialogView.findViewById(R.id.imgbanner);
        Glide.with(this).load(hadfdfhafh.dt_banner).into(icon_banner);
        TextView title_up = (TextView) dialogView.findViewById(R.id.txt_title);
        title_up.setText(hadfdfhafh.dt_title);
        TextView desc_up = (TextView) dialogView.findViewById(R.id.textMassage);
        desc_up.setText(hadfdfhafh.dt_desc);
        TextView imgInstal = (TextView) dialogView.findViewById(R.id.text_innstal);
        final android.app.AlertDialog playDialog = dialogBuilder.create();
        imgInstal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent rate = new Intent(Intent.ACTION_VIEW);
                rate.setData(Uri.parse("market://details?id=" + url_move));
                startActivity(rate);
                playDialog.dismiss();
            }
        });
        playDialog.show();
    }
}