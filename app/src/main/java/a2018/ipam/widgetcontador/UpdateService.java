package a2018.ipam.widgetcontador;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

/**
 * Created by Ivan on 02/05/2018.
 */

public class UpdateService extends IntentService {
    public static final String ACTION_UPDATE_WIDGET="a2018.ipam.widgetcontador.action.update_widget";

    public UpdateService(){
        super("UpdateService");
    }

    //ejecutar el UpdateService
    public static void startActionUpdateWidget(Context context){
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_UPDATE_WIDGET);// le associoamos una accion
        context.startService(intent);// arrancar el servicio // ejecutara la clase, inicializa el constructor y ejecuta el onHandleIntent
    }

    //cuando se ejecuta la clase UpdateService se ejecuta este metodo
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onHandleIntent(@Nullable Intent intent){
        if(intent !=null){
            final String action = intent.getAction();// esta accion es la del metodo anterior "intent.setAction(ACTION_UPDATE_WIDGET
            if(ACTION_UPDATE_WIDGET.equals(action)){
                int temp=0;
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
                int[] appWidgetId = appWidgetManager.getAppWidgetIds(new ComponentName(this, Wbotones.class)); //se crea un nuevo componente cnstantemento por el cambio de widget
                for(int i=0; i< appWidgetId.length; i++){
                    temp = MainActivity.numeroWidget;
                    Wbotones.updateAppWidgets(this, appWidgetManager, appWidgetId, String.valueOf(temp));
                }
            }
        }

    }

}
