package layout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

public class UIUtils {
    private Context context;



    //标准值   初始化时序可以HOOK在contentp'rovider初始化时   leakcanary，bugly
    private static final float STANDRD_WINDTH=1080F;
    private static final float STANDRD_HEIGHT=1920F;
    //实际值  MMKV
    private static float displayMetricsWidth;
    private static float displayMetricsHeight;

    //单例
    private static UIUtils instance;

    public static UIUtils getInstance(Context context){
        if (instance==null){
            instance=new UIUtils(context);
        }
        return instance;
    }

    private UIUtils(Context context){
        this.context=context;
        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        if (displayMetricsWidth==0.0f||displayMetricsHeight==0.0f) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int systemBarHeight=getSystemBarHeight(context);
            if (displayMetrics.widthPixels>displayMetrics.heightPixels){
                //横屏
                displayMetricsWidth=displayMetricsHeight;
                displayMetricsHeight=displayMetrics.widthPixels-systemBarHeight;
            }else{
                //竖屏
                displayMetricsWidth=(float) displayMetrics.widthPixels;
                displayMetricsHeight=(float) displayMetrics.heightPixels-systemBarHeight;
            }
        }
    }

    private static final String DIME_CLASS="com.android.internal.R$dimen";
    //用于反射系统的属性
    private int getSystemBarHeight(Context context){
        return getValue(context,DIME_CLASS,"system_bar_height",48);
    }

    private int getValue(Context context, String dimeClass, String system_bar_height,int i) {
        try{
            Class<?> clz=Class.forName(dimeClass);
            Object object=clz.newInstance();
            //反射属性  system_bar_height
            Field field=clz.getField(system_bar_height);
            int id=Integer.parseInt(field.get(object).toString());
            return context.getResources().getDimensionPixelSize(id);

        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }
    public float getHorValue(){
        return ((float) displayMetricsWidth)/STANDRD_WINDTH;
    }
    public float getVerValue(){
        return ((float) displayMetricsHeight)/(STANDRD_HEIGHT-getSystemBarHeight(context));
    }
}


