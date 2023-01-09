package com.your_market;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// هي الصفحة التي سيتم فيها عرض الفئات المختلفة للتسووق
public class categories extends AppCompatActivity {

     // تعريف الكلاس الربط
    Catogry_Adapter adapter ;
    // تعريف القائمة المتحركة
    RecyclerView cat_recycle ;
    // تعريف قائمة الفئات
    ArrayList<ItemCategories> cat_items ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categgories);

        // دالة ربط العناصر مع شاشة العرض
        CastingView();

        // دوال تعريف القائمة المتحركة
        // تعريف خلية بعدد عنصرين في الصف الواحد
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 2);
        // خلية مع تحريك افقي
        gridLayoutManager.setOrientation( GridLayoutManager.VERTICAL );
        // ربط القائمة المتحركة مع الخلية المعرفة
        cat_recycle.setLayoutManager(gridLayoutManager);

        // نهيئة قائمة الفئات
        cat_items = new ArrayList<>();

        // تعبئة القائمة المتحركة
        cat_items.add( new ItemCategories( "1" , "سيارات" ) );
        cat_items.add( new ItemCategories( "2" , "عقارات" )  );
        cat_items.add( new ItemCategories( "3" , "إلكترونيات" )  );
        cat_items.add( new ItemCategories( "4" , "سيدتي" )  );
        cat_items.add( new ItemCategories( "5" , "عالم الرجال" )  );
        cat_items.add( new ItemCategories( "6" , "عالم الاطفال" )  );
        cat_items.add( new ItemCategories( "7" , "سلع " )  );
        cat_items.add( new ItemCategories( "8" , " مقايضات " )  );
        cat_items.add( new ItemCategories( "9" , " معدات " )  );
        cat_items.add( new ItemCategories( "10" , " اخرى " )  );

        // اعدادات الكلاس الرابط مع تمرير القائمة النصية
        adapter = new Catogry_Adapter( cat_items , getApplicationContext());
        // ربط القائمة المتحركة مع كلاس الربط
        cat_recycle.setAdapter( adapter );

    }

    // دالة ربط العناصر مع الواجهه
    private void CastingView() {
        // ربط القائمة المتحركة مع الواجهه
        cat_recycle = findViewById( R.id.cat_recycle ) ;
    }

    public void go_login(View view) {
        // الذهاب الي شاشة تسجيل الدخول
        startActivity(new Intent( this , MainActivity.class ));
    }

    // اعادة إستخدام دالة العودة الي الخلف
    @Override
    public void onBackPressed() {
    // الدالة الرئيسية المستخدمة
    //super.onBackPressed();

     // الكود الجديد
        // انشاء رسالة تاكيد الخروج من التطبيق
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        // لا يمكن اغلاق الرسالة يدويا
        dialogBuilder.setCancelable(false);
        // اضافة نص الرسالة
        dialogBuilder.setMessage(" هل انت متاكد من الخروج ؟ ");

        // اضافة الحدث عند الضغط علي نعم
        dialogBuilder.setPositiveButton("نعم", (dialogInterface, i) -> {
            // الخروج من التطبيق واغلاقه
            System.exit(0);
        });

        // اضافة الحدث عند الضغط علي لا
        dialogBuilder.setNegativeButton("لا", (dialogInterface, i) -> {
            // اغلاق الرسالة والعودة الي التطبيق
            dialogBuilder.setCancelable(true);
        });

        // عرض الرسالة
        dialogBuilder.show();
    }
}

// الكلاس المسؤول عن الربط مع القائمة
 class Catogry_Adapter extends RecyclerView.Adapter<Catogry_Adapter.ViewHolder>{

     // تعريف قائمة
    ArrayList<ItemCategories> list;
    private final Context context;

    // Constructor
    public Catogry_Adapter(ArrayList<ItemCategories> list, Context context) {
        this.list = list;
        // تعريف المحتوى
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // كلاس الذي يحتوي علي
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories , parent , false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // ربط قائمة الفئات مع واجهه غنصر القائمة المتحركة
       holder.name.setText(list.get(position).getName());

    // عند الضغط علي اخد بطاقات الفئات
        holder.liner.setOnClickListener(view -> {
            // الذهاب الي شاشة العروض
            context.startActivity(
                    new Intent( context , offers.class ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            );
        });

    }

    // دالة تحديد عدد وعناصر ومواقع القائمة المتحركة
    @Override
    public int getItemCount() {
        return  (null != list ? list.size(): 0 );
    }

    // الربط مع واجهه عنصر القائمة المتحركة
    public static class ViewHolder extends RecyclerView.ViewHolder {
       // تعريف محتويات واجهه العنصر
        TextView name ;
        LinearLayout liner;

        // الربط مع واجهه العنصر
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById( R.id.name ) ;
            liner = itemView.findViewById( R.id.liner ) ;
        }

    }

}