package com.reza.jenazah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class cektarif extends AppCompatActivity {
    Button cari;
    Spinner pulau, via, jenis;
    TextView viatampil,hargatampil;

    hitung tarif = new hitung();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cek_tarif);

        pulau = (Spinner) findViewById(R.id.pulauCari);
        via = (Spinner) findViewById(R.id.viaCari);
        jenis = (Spinner) findViewById(R.id.hariCari);
        cari = (Button) findViewById(R.id.cari);
        hargatampil = (TextView) findViewById(R.id.hargaTampil);
        viatampil = (TextView) findViewById(R.id.viaTampil);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viatampil.setText(String.valueOf(via.getSelectedItem()));
                perhitungan();
                int tot_tarif = tarif.getTotal_tarif();
//
                hargatampil.setText(String.valueOf(tot_tarif));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void perhitungan(){
        try{
            tarif.setWaktu(Integer.parseInt(jenis.getSelectedItem().toString()));
            if (via.getSelectedItemPosition() == 0){
                tarif.setVia(20000000);

                if (pulau.getSelectedItemPosition() == 0){
                    tarif.setPulau(2000000);
                }
                else if (pulau.getSelectedItemPosition() == 1) {
                    tarif.setPulau(1500000);
                }
                else if (pulau.getSelectedItemPosition() == 2) {
                    tarif.setPulau(3000000);
                }
                else if (pulau.getSelectedItemPosition() == 3) {
                    tarif.setPulau(3500000);
                }
                else if (pulau.getSelectedItemPosition() == 4) {
                    tarif.setPulau(2500000);
                }
                else if (pulau.getSelectedItemPosition() == 5) {
                    tarif.setPulau(4000000);
                }
                else if (pulau.getSelectedItemPosition() == 6) {
                    tarif.setPulau(5000000);
                }
            } else if (via.getSelectedItemPosition() == 1) {
                tarif.setVia(10000000);

                if (pulau.getSelectedItemPosition() == 0) {
                    tarif.setPulau(2000000);
                } else if (pulau.getSelectedItemPosition() == 1) {
                    tarif.setPulau(1500000);
                }
                else if (pulau.getSelectedItemPosition() == 2) {
                    tarif.setPulau(3000000);
                }
                else if (pulau.getSelectedItemPosition() == 3) {
                    tarif.setPulau(3500000);
                }
                else if (pulau.getSelectedItemPosition() == 4) {
                    tarif.setPulau(2500000);
                }
                else if (pulau.getSelectedItemPosition() == 5) {
                    tarif.setPulau(4000000);
                }
                else if (pulau.getSelectedItemPosition() == 6) {
                    tarif.setPulau(5000000);
                }

            }
            tarif.setTotal_tarif(tarif.getPulau(),tarif.getWaktu(),tarif.getVia());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
