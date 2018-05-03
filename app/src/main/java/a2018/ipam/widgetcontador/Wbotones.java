package a2018.ipam.widgetcontador;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class Wbotones extends AppWidgetProvider {

    private static String textUpdate;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void updateAppWidgets(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds, String text){
        textUpdate = text;
        for (int appWidgetId : appWidgetIds){
            updateAppWidget(context, appWidgetManager, appWidgetId, textUpdate);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId, String text) {

        Bundle option = appWidgetManager.getAppWidgetOptions(appWidgetId);
        float ancho = option.getInt(appWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);//recibe el ancho del widget
        int imagen1 = R.drawable.imgpequena;
        int imagen2 = R.drawable.imgmediana;
        int imagen3 = R.drawable.imggrande;

        int imagen;

        if(ancho < 200){
            imagen = imagen1;
        }else{
            if (ancho < 300){
                imagen = imagen2;
            }else{
                imagen = imagen3;
            }
        }

        //intento para abrir la MainActivity
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.wbotones);
        views.setOnClickPendingIntent(R.id.imgvWidget,pendingIntent);//cuando se da click en el lblTitulo del widget se abrira la MainActivity
        views.setImageViewResource(R.id.imgvWidget, imagen);
        views.setTextViewText(R.id.lblNumero,text);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds){
            UpdateService.startActionUpdateWidget(context);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appwidgetManager, int appWidgetId, Bundle newOptions){
        updateAppWidget(context, appwidgetManager, appWidgetId, textUpdate);
    }

}

