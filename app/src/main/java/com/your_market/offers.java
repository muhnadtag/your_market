package com.your_market;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// الصفحة التي ستظهر فيها العروض داخل كل فئة
public class offers extends AppCompatActivity {

    // تعريف الكلاس الربط
    Offers_Adapter adapter ;
    // تعريف القائمة المتحركة
    RecyclerView offer_recycle ;
    // تعريف قائمة الفئات
    ArrayList<ItemOffers> offer_items ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        // دالة ربط العناصر مع شاشة العرض
        CastingView();

        // دوال تعريف القائمة المتحركة
        // تعريف خلية بعدد عنصر واحد في الصف الواحد
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 1);
        // خلية مع تحريك افقي
        gridLayoutManager.setOrientation( GridLayoutManager.VERTICAL );
        // ربط القائمة المتحركة مع الخلية المعرفة
        offer_recycle.setLayoutManager(gridLayoutManager);

        // نهيئة قائمة الفئات
        offer_items = new ArrayList<>();

        // تعبئة القائمة المتحركة
        offer_items.add( new ItemOffers( "موريس MG 2014 اوتوماتيك" , "2300000 SDG" , "" , "" , "الخرطوم - السوق العربي" , "ملاذ" , "" , "سيارات") );
        offer_items.add( new ItemOffers( "شقق هيكل سوبر ديلوكس تمليك بالاقصاط في امتداد ناصر" , "4300000 SDG" , "" , "" , "الخرطوم - جبرة" , "ام هديل " , "" , "عقارات") );
        offer_items.add( new ItemOffers( "لابتوب Lenovo " , "35000 SDG" , "" , "" , "بحري - المؤسسة" , "عادل عوض" , "" , "الكترونيات") );
        offer_items.add( new ItemOffers( "توتل عشكوب فاخر" , "12000 SDG" , "" , "" , "امدرمان - الثورة " , "رندا عمر" , "", "سيدتي") );
        offer_items.add( new ItemOffers( "احذية طبية رجالية" , "7000 SDG" , "" , "" , " الخرطوم - الديم" , "وفاء عادل" , "" ,"عالم الرجال") );
        offer_items.add( new ItemOffers( "سبورة تعليمية" , "10000 SDG" , "" , "" , "بحري - الميرغنية" , "التجاري" , "" , "عالم الاطفال") );
        offer_items.add( new ItemOffers( "سكر برازيلي 10 الف طن" , "27500 SDG" , "" , "" , "الخرطوم - الكلاكلة" , "Hadel Yousif" , "" , "سلع") );
        offer_items.add( new ItemOffers( "اسلاك شايكة شاملة التركيب" , "0 SDG" , "" , "" , "امدرمان - شارع الوادي" , "salma " , "" , "مقايضات") );
        offer_items.add( new ItemOffers( "ابواب صينية باشكال مختلفة" , "95000 SDG" , "" , "" , "بحري - الحلفايا" , "مجدي عبد القادر" , "", "معدات") );
        offer_items.add( new ItemOffers( "ارقام زين جديدة" , "30000 SDG" , "" , "" , "الخرطوم - العمارات" , "موسي عمر" , "" , "اخري") );

        // اعدادات الكلاس الرابط مع تمرير القائمة النصية
        adapter = new Offers_Adapter( offer_items , getApplicationContext());
        // ربط القائمة المتحركة مع كلاس الربط
        offer_recycle.setAdapter( adapter );

    }

    // دالة ربط العناصر مع الواجهه
    private void CastingView() {
        // ربط القائمة المتحركة مع الواجهه
        offer_recycle = findViewById( R.id.offers_recycle ) ;
    }
}

class Offers_Adapter extends RecyclerView.Adapter<Offers_Adapter.ViewHolder>{

    // تعريف قائمة
    ArrayList<ItemOffers> list;
    private final Context context;

    // Constructor
    public Offers_Adapter(ArrayList<ItemOffers> list, Context context) {
        this.list = list;
        // تعريف المحتوى
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // كلاس الذي يحتوي علي
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_offers , parent , false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // كود مربط الصورة مع واجهه عنصر القائمة المتحركة
        // Picasso.with(context).load(config.IMG + list.get(position).getImg()).resize(800,500).noFade().centerCrop().into(holder.img);

        // ربط قائمة العروض مع واجهه غنصر القائمة المتحركة

        // الاسم
        holder.name.setText(list.get(position).getName());
        // السعر
        holder.price.setText(list.get(position).getPrice());
        // إسم المسووق
        holder.marketerName.setText(list.get(position).getMarketerName());
        // الفئة
        holder.category.setText(list.get(position).getCategory());
        // موقع العرض
        holder.location.setText(list.get(position).getLocation());

        // عند الضغط علي اخد بطاقات العروض
        holder.liner.setOnClickListener(view -> {
            // الذهاب الي شاشة تفاصيل العرض
            Toast.makeText(context, "تفاصيل العرض ", Toast.LENGTH_SHORT).show();
            // الإنتقال الي صفحة تفاصيل العرض
            context.startActivity(
                    new Intent( context , offerDetailes.class ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
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
        TextView name , price , marketerName  , category , location ;
        LinearLayout liner;

        public ViewHolder(View itemView) {
            super(itemView);

            // الربط مع واجهه العنصر
            name = itemView.findViewById( R.id.name ) ;
            price = itemView.findViewById( R.id.price ) ;
            marketerName = itemView.findViewById( R.id.marketerName ) ;
            category = itemView.findViewById( R.id.category ) ;
            location = itemView.findViewById( R.id.location ) ;
            liner = itemView.findViewById( R.id.liner ) ;

        }

    }

}