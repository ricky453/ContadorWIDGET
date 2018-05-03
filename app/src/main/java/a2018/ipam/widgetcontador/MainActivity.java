package a2018.ipam.widgetcontador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static int numeroWidget = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSumar = (Button) findViewById(R.id.btnSumar);
        Button btnRestar = (Button) findViewById(R.id.btnRestar);


    }

    public void Numeros(View v){
        switch (v.getId()) {
            case R.id.btnSumar:
                numeroWidget++;
                break;
            case R.id.btnRestar:
                numeroWidget--;
                break;

        }
        UpdateService.startActionUpdateWidget(MainActivity.this);
    }
}
