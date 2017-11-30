package fr.fedior.samba.meteorquest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_aide:
                showHelp();
                return true;
            case R.id.menu_echange:
                showExchange();
                return true;
            case R.id.menu_item:
               showInventory();
                return true;
            case R.id.menu_mon_compte:
               showAccount();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void showExchange() {

    }

    private void showInventory() {

    }

    private void showAccount() {

    }

    private void showHelp() {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
}
