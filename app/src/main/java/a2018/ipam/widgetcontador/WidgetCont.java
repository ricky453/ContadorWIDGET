package a2018.ipam.widgetcontador;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ivan on 02/05/2018.
 */

public class WidgetCont extends Activity{


    private TextView contador;
    int cont;
    private Button btnMas;
    private Button btnMenos;
    private Button btnReiniciar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wbotones);
    }
}
