package fr.fedior.samba.meteorquest;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PermissionsCheck extends Activity implements View.OnClickListener {

    private final int PERMISSION_REQUEST_CODE_USE_CAMERA = 2;

    private Button buttonValider;
    private Button buttonFermer;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permissions_check);

        init();
        permissions();
    } /// onCreate



    private void init() {
        buttonValider = findViewById(R.id.buttonValider);
        buttonValider.setOnClickListener(this);
        buttonFermer = findViewById(R.id.buttonFermer);
        buttonFermer.setOnClickListener(this);
        textViewMessage = findViewById(R.id.textViewMessage);
    }

    /*
    PERMISSIONS
     */
    private void permissions() {

        /*
        Permet de connaître l'état d'une permission
         */
        /*
        CAMERA
         */
        int permissionCheckCamera = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);
        if (permissionCheckCamera == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Camera Granted", Toast.LENGTH_LONG).show();
        } else if (permissionCheckCamera == PackageManager.PERMISSION_DENIED) {
            Toast.makeText(this, "Camera Denied", Toast.LENGTH_LONG).show();
        }

        /*
        INTERNET
         */
        int permissionCheckInternet = ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET);

        if (permissionCheckInternet == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Internet Granted", Toast.LENGTH_LONG).show();
        } else if (permissionCheckInternet == PackageManager.PERMISSION_DENIED) {
            Toast.makeText(this, "Internet Denied", Toast.LENGTH_LONG).show();
        }

        /*
        Permet de modifier l'état d'une permission
         */
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE_USE_CAMERA);
        }

    } /// permissions


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        /*
        Cette méthode est appelée par ActivityCompat.requestPermissions()
        */
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE_USE_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission d'utiliser la Camera accordée", Toast.LENGTH_LONG).show();
                    Toast.makeText(this, permissions[0], Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Permission d'utiliser la Camera refusée", Toast.LENGTH_LONG).show();
                    Toast.makeText(this, permissions[0], Toast.LENGTH_LONG).show();
                }
                return;
            }

        } /// switch
    } /// onRequestPermissionsResult

    @Override
    public void onClick(View v) {
        if (v == buttonValider) {
            permissions();
        }
        if (v == buttonFermer) {
            finish();
        }
    } /// onClick
} /// class