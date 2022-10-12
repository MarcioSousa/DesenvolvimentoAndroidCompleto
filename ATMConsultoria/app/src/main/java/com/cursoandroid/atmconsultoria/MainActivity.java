package com.cursoandroid.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.cursoandroid.atmconsultoria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal,
                R.id.nav_servicos,
                R.id.nav_clientes,
                R.id.nav_email,
                R.id.nav_info)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        String celular = "tel:11962883301";
        String imagem = "https://www.melhoresdestinos.com.br/wp-content/uploads/2020/06/praias-brasil-sancho.jpg";
        String endereco = "https://www.google.com/maps/place/PoupaPinga/@-23.2685982,-47.3171805,3a,75y,8.14h,90t/data=!3m7!1e1!3m5!1sxCXpuNTYHF2lhNgdtnJDEg!2e0!6shttps:%2F%2Fstreetviewpixels-pa.googleapis.com%2Fv1%2Fthumbnail%3Fpanoid%3DxCXpuNTYHF2lhNgdtnJDEg%26cb_client%3Dsearch.gws-prod.gps%26w%3D86%26h%3D86%26yaw%3D8.144702%26pitch%3D0%26thumbfov%3D100!7i16384!8i8192!4m8!1m2!2m1!1spraia!3m4!1s0x94cf5069536504df:0x55a37d537384bc9c!8m2!3d-23.2684919!4d-47.3171847";


        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App.");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática.");

        intent.setType("message/rfc822");
        //intent.setType("text/plain");
        //intent.setType("image/*");
        //intent.setType("application/pdf*");

        startActivity(Intent.createChooser(intent, "Escolha um App de e-mail."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}