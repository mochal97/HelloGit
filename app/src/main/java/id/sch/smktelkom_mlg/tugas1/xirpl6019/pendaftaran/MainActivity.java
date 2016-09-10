package id.sch.smktelkom_mlg.tugas1.xirpl6019.pendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etNIS;
    EditText etSekolah;
    EditText etWali;
    EditText etAgama;
    Button bOK;
    TextView tvHasil;
    TextView tvHasil1;
    TextView tvHasil2;
    TextView tvHasil3;
    TextView tvHasil6;
    TextView tvHasil7;
    TextView tvHasil8;
    TextView tvHasil9;
    RadioGroup rg1;
    RadioButton rb1, rb2;
    CheckBox cbSepakBola, cbVoli, cbBasket, cbFO;
    Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNIS = (EditText) findViewById(R.id.editTextNIS);
        etSekolah = (EditText) findViewById(R.id.editTextSekolah);
        sp1 = (Spinner) findViewById(R.id.spin);
        etWali = (EditText) findViewById(R.id.editTextWali);
        etAgama = (EditText) findViewById(R.id.editTextAgama);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil6 = (TextView) findViewById(R.id.textViewHasil6);
        tvHasil7 = (TextView) findViewById(R.id.textViewHasil7);
        tvHasil8 = (TextView) findViewById(R.id.textViewHasil8);
        tvHasil9 = (TextView) findViewById(R.id.textViewHasil9);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        cbSepakBola = (CheckBox) findViewById(R.id.checkboxSepakBola);
        cbVoli = (CheckBox) findViewById(R.id.checkboxVoli);
        cbFO = (CheckBox) findViewById(R.id.checkboxFO);
        cbBasket = (CheckBox) findViewById(R.id.checkboxBasket);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();
            }
        });
    }

    private void doClick() {
        String Hasil1 = tvHasil1.getText().toString();
        String hasil1 = null;
        String hasil2 = "Ekstra Kulikuler Anda :\n";

        tvHasil2.setText("Kelas : " + sp1.getSelectedItem().toString());
        if (rb1.isChecked()) {
            hasil1 = rb1.getText().toString();
        } else if (rb2.isChecked()) {
            hasil1 = rb2.getText().toString();
        }
        if (cbSepakBola.isChecked()) hasil2 += cbSepakBola.getText() + "\n";
        if (cbBasket.isChecked()) hasil2 += cbBasket.getText() + "\n";
        if (cbVoli.isChecked()) hasil2 += cbVoli.getText() + "\n";
        if (cbFO.isChecked()) hasil2 += cbFO.getText() + "\n";

        int startlen = hasil2.length();
        if (hasil2.length() == startlen) hasil2 += "";
        tvHasil3.setText(hasil2);
        if (hasil1 == null) {
            tvHasil.setText("Jenis Kelamin : Belum dipilih...");
        } else {
            tvHasil.setText("Jenis Kelamin Anda :" + hasil1);
        }

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String nis = etNIS.getText().toString();
            String sekolah = etSekolah.getText().toString();
            String wali = etWali.getText().toString();
            String agama = etAgama.getText().toString();
            tvHasil.setText("Nama :" + nama + "\n" + "NIS :" + nis + "\n" + "Sekolah :" + sekolah + "\n" + "Wali :" + wali + "\n" + "Agama :" + agama);
        }
    }

    private boolean isValid() {

        boolean valid = true;

        String nama = etNama.getText().toString();
        String nis = etNIS.getText().toString();
        String sekolah = etSekolah.getText().toString();
        String wali = etWali.getText().toString();
        String agama = etAgama.getText().toString();
        String raba1 = rb1.getText().toString();
        String raba2 = rb2.getText().toString();
        String hasil1 = null;
        if (nama.isEmpty()) {
            tvHasil6.setText("Nama : belum diisi..." + "\n");
            etNama.setError("Nama belum diisi...");
            valid = false;
        } else {
            tvHasil6.setText("Nama : " + nama + "\n");
        }
        if (nis.isEmpty()) {
            tvHasil7.setText("NIS : belum diisi..." + "\n");
            etNIS.setError("NIS belum diisi...");
            valid = false;
        } else {
            tvHasil7.setText("NIS : " + nis + "\n");
        }
        if (sekolah.isEmpty()) {
            tvHasil8.setText("Sekolah Asal : belum diisi..." + "\n");
            etSekolah.setError("Sekolah Asal belum diisi...");
            valid = false;
        } else {
            tvHasil8.setText("Sekolah Asal :" + sekolah + "\n");
        }
        if (wali.isEmpty()) {
            tvHasil9.setText("Nama Wali : belum diisi..." + "\n");
            etWali.setError("Nama Wali belum diisi...");
            valid = false;
        } else {
            tvHasil9.setText("Nama Wali :" + wali + "\n");
        }
        if (agama.isEmpty()) {
            tvHasil1.setText("Agama : belum diisi..." + "\n");
            etAgama.setError("Agama belum diisi...");
            valid = false;
        } else {
            tvHasil1.setText("Agama : " + agama + "\n");
        }

        return valid;
    }

}

