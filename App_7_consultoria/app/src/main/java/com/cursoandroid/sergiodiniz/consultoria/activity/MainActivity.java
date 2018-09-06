package com.cursoandroid.sergiodiniz.consultoria.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cursoandroid.sergiodiniz.consultoria.R;
import com.cursoandroid.sergiodiniz.consultoria.fragment.ClientesFragment;
import com.cursoandroid.sergiodiniz.consultoria.fragment.PrincipalFragment;
import com.cursoandroid.sergiodiniz.consultoria.fragment.ServicosFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Fragment principal ao iniciar o app
        this.fragmentReplace(new PrincipalFragment());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        // Tive ir nas classes de Fragmest e mudar o import do extends Fragment para android.support.v4.app.Fragment;

        if (id == R.id.nav_principal) {
            this.fragmentReplace(new PrincipalFragment());
        } else if (id == R.id.nav_servicos) {
            this.fragmentReplace(new ServicosFragment());
        } else if (id == R.id.nav_clientes) {
            this.fragmentReplace(new ClientesFragment());
        } else if (id == R.id.nav_contato) {
            this.enviarEmail();
        } else if (id == R.id.nav_sobre) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fragmentReplace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.commit();
    }

    public void enviarEmail(){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"sergiodinizsh@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        email.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        // configurar apps para email
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Escolha o App de email"));

    }
}
