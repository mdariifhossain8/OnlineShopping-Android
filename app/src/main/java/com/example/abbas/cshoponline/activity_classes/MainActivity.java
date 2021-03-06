package com.example.abbas.cshoponline.activity_classes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abbas.cshoponline.DatabaseManager;
import com.example.abbas.cshoponline.ProductCredentials;
import com.example.abbas.cshoponline.R;
import com.example.abbas.cshoponline.adapters.ProductAdapter;
import com.example.abbas.cshoponline.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseManager databaseManager= new DatabaseManager(this);
    Spinner spinner;
    TextView cartTV;
    ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cartTV = findViewById(R.id.cartTextView);

        showCartText();


        final ListView listView;
        spinner = findViewById(R.id.spinnerId);
        List<String>categories = new ArrayList<>();
       // categories.add("Select Category");
        categories.add("All Products");
        categories.add("Electronics");
        categories.add("Clothes");
        categories.add("Cosmetics");
        categories.add("Sports");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, categories);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);



        // --------- Properties of every list item--------------

        //----------titles----------------------
        final String pakhi3PcsTitle="Pakhi 3pcs";
        final String makeUpBoxTitle="Make up box";
        final String chakriThakbeNaTitle="Chakri thakbe na T-shirt";
        final String cardMobileTitle="Card mobile";
        final String smartWatchTitle="Smart watch DZ-08";
        final String tendaRouterTitle="Tenda router";
        final String waterHeatheTitle="Water heater";
        final String kidswearTitle="Kids wear kit";
        final String smartPenTitle="Smart pen";
        final String footBall = "Adidas Foot Ball";
        final String cricketBat= "Cricket bat";
        //------------descriptions---------------------
        final String pakhi3PcsDes="\n" +
                "\n" +
                "    ???????????????????????? ???????????????????????????\n" +
                "\n" +
                "    ???????????????????????? ???????????? ?????????\n" +
                "\n" +
                "    ?????????????????????: ?????????\n" +
                "\n" +
                "    ??????????????? ?????????????????????- ????????? ?????????????????? ??????????????????????????????\n" +
                "\n" +
                "    ????????????: ????????????\n" +
                "\n" +
                "    ????????? ???????????????????????? ?????????????????????\n" +
                "\n" +
                "    ???????????????????????? ??????????????????\n" +
                "\n" +
                "    ??????????????????????????? ??? ????????????????????????\n"; final String price3Pcs= "3450";

        final String makeUpBoxDes="Product details of Cosmetics Organizer Box - Transparent\n" +
                "\n" +
                "    Type: Storage Boxes\n" +
                "    Material: Plastic\n" +
                "    Style: Modern\n" +
                "    Color: Transparent\n" +
                "    Environmentally friendly, Stocked\n" +
                "    Ideal for organizing and storing your makeup"; final String makeUpBoxPri= "1990";

        final String chakriTNDes="\n" +
                "    Fabrics: Cotton\n" +
                "    Fabrication: 180 GSM\n" +
                "    Attractive Design\n" +
                "    Color: As Given Picture\n" +
                "    Computer Marvel Rubber Print\n" +
                "    N.B: Please Check The Size Chart And Select Your Size Before Placing Order.\n" +
                "    Disclaimer: The Actual Color Of The Physical Product May Slightly Vary Due To The Deviation Of Lighting Sources, Photography Or Your Device Display Settings."; final String tShirtPrice ="999";

        final String cardMobileDes="\n" +
                "\n" +
                "???????????????????????????: AEKU\n" +
                "\n" +
                "????????????: C6\n" +
                "\n" +
                "???\u200D????????????: <128 ????????????????????????\n" +
                "\n" +
                "??????????????????: ??? ??????????????? (???????????????)\n" +
                "\n" +
                "???????????????????????????????????? ????????????: ??? ????????? (???????????????)\n" +
                "\n" +
                "????????????????????????: 320mAh\n" +
                "\n" +
                "?????????????????? ?????????\n" +
                "\n" +
                "????????????????????? ?????????\n" +
                "\n" +
                "???????????????: ???\u200C?????????????????????\n"; final String carMobPrice="2400";

        final String smartWatchDes="    Display: 1.54'' IPSCapacitive Touchscreen\n" +
                "    Resolutions: 240 x 240\n" +
                "    Compatible OS: Android\n" +
                "    RAM: 64MB, ROM: 128MB\n" +
                "    Single SIM\n" +
                "    Camera: VGA"; final String smartWatchPri= "1400";

        final String tendaRouterDes="Wireless Speed\t2.4GHZ:300Mbps II\n" +
                "5GHZ:867Mbps II\n" +
                "Button\t1*WPS/RESET button\n" +
                "Antenna Type\t5 External Antennas\n" +
                "Wireless Standards\t1 10/100M auto-negotiation WAN port II\n" +
                "3 10/100M auto-negotiation LAN ports II\n" +
                "Frequency\tWorks over 2.4GHz and 5GHz II\n" +
                "Basic Functions Wireless Switch II\n" +
                "SSID Broadcast Switch II\n" +
                "Work Frequency: 2.4GHz,5GHz II\n" +
                "Channel Of 2.4GHz:1-13 II\n" +
                "Channel Of 5GHz: 149???153???157???161???165 II"; final String routerPrice = "1950";

        final String waterHeaterDes="\n" +
                "\n" +
                "    *Brand: Hyundai\n" +
                "\n" +
                "    *Model: REK-105\n" +
                "\n" +
                "    *Power: 1550 W\n" +
                "\n" +
                "    *Voltage: 220 V\n" +
                "\n" +
                "    *Capacity: 1.8 LITER\n" +
                "\n" +
                "    *Size: 190x190x230 mm\n" +
                "\n" +
                "    *3 Leyar safety.\n" +
                "\n" +
                "    *Auto Switch Off Function after Boield.\n" +
                "\n" +
                "    *Mirror polished Stainless Steel.\n"; final String wHeaterPri ="1150";

        final String kidsWearDes="\n" +
                "\n" +
                "    Product type: Baby pack 7 pcs set.\n" +
                "    Brand: Cussons.\n" +
                "    Biodegradable and dermatologically tested.\n" +
                "    Good quality for kids.                                                                                           \n" +
                "    Made in Indonesia.\n" +
                "    Color: As same as picture.\n" +
                "\n"; final String kidswearPri = "5580";

        final String smartPenDes="\n" +
                "    Touch pen for smartphone and Tablets\n" +
                "    Stylus Pen for Capacitive Touch screens\n" +
                "    Pen clip for easy carry and storage\n" +
                "    Super soft and flexible 7mm stylus tip design is replaceable\n" +
                "    Highly sensitive and durable pen tip provides precision control\n" +
                "    500,000 tap times for pen tip - SGS certified\n"; final String smartPenPri= "2200";
                final String footBallDes= "Product Type: Football\n" +
                        "For all\n" +
                        "Material: PU\n" +
                        "Machine Stitched\n" +
                        "Size: 5\n" +
                        "Inflated to a pressure";
                final String footBallPri="1200";
                final String cricketBatDes="Cricket bat is made with traditionally made from willow wood\n" +
                        "Strong handle at the top of the bat to move the bat flexible\n" +
                        "Handle of the bat is fully covered with a rubber grip.\n" +
                        "Wooden color allover the body of the bat\n" +
                        "Durable and long lasting\n" +
                        "General size not more then 4.25 inches";
                final String cricketBatPri="1500";



        listView =findViewById(R.id.productListId);

        final ArrayList<Product> productListElectronics = new ArrayList<>();
        final ArrayList<Product> productList = new ArrayList<>();
        final ArrayList<Product> productListCosmetics = new ArrayList<>();
        final ArrayList<Product> productListClothes = new ArrayList<>();
        final ArrayList<Product> productListSports = new ArrayList<>();

        productList.add(new Product(R.drawable.three_pcs, pakhi3PcsTitle ,pakhi3PcsDes, price3Pcs));
        productList.add(new Product(R.drawable.make_up, makeUpBoxTitle , makeUpBoxDes ,makeUpBoxPri));
        productList.add(new Product(R.drawable.t_shirt, chakriThakbeNaTitle ,chakriTNDes, tShirtPrice));
        productList.add(new Product(R.drawable.card_mobile, cardMobileTitle ,cardMobileDes, carMobPrice));
        productList.add(new Product(R.drawable.sm_watch, smartWatchTitle ,smartWatchDes, smartWatchPri));
        productList.add(new Product(R.drawable.router, tendaRouterTitle ,tendaRouterDes ,routerPrice));
        productList.add(new Product(R.drawable.water_heater, waterHeatheTitle ,waterHeaterDes ,wHeaterPri));
        productList.add(new Product(R.drawable.kids_wear, kidswearTitle ,kidsWearDes ,kidswearPri));
        productList.add(new Product(R.drawable.smart_pen, smartPenTitle ,smartPenDes ,smartPenPri));
        productList.add(new Product(R.drawable.football,footBall,footBallDes,footBallPri));
        productList.add(new Product(R.drawable.cricket_bat,cricketBat,cricketBatDes,cricketBatPri));

        productListElectronics.add(new Product(R.drawable.card_mobile, cardMobileTitle ,cardMobileDes, carMobPrice));
        productListElectronics.add(new Product(R.drawable.sm_watch, smartWatchTitle ,smartWatchDes, smartWatchPri));
        productListElectronics.add(new Product(R.drawable.router, tendaRouterTitle ,tendaRouterDes ,routerPrice));
        productListElectronics.add(new Product(R.drawable.water_heater, waterHeatheTitle ,waterHeaterDes ,wHeaterPri));
        productListElectronics.add(new Product(R.drawable.smart_pen, smartPenTitle ,smartPenDes ,smartPenPri));

        productListClothes.add(new Product(R.drawable.three_pcs, pakhi3PcsTitle ,pakhi3PcsDes, price3Pcs));
        productListClothes.add(new Product(R.drawable.t_shirt, chakriThakbeNaTitle ,chakriTNDes, tShirtPrice));
        productListClothes.add(new Product(R.drawable.kids_wear, kidswearTitle ,kidsWearDes ,kidswearPri));

        productListCosmetics.add(new Product(R.drawable.make_up, makeUpBoxTitle , makeUpBoxDes ,makeUpBoxPri));

        productListSports.add(new Product(R.drawable.football,footBall,footBallDes,footBallPri));
        productListSports.add(new Product(R.drawable.cricket_bat,cricketBat,cricketBatDes,cricketBatPri));




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    mAdapter = new ProductAdapter(getApplicationContext(), productList);
                    listView.setAdapter(mAdapter);
                }else if (position==1){
                    mAdapter = new ProductAdapter(getApplicationContext(),productListElectronics);
                    listView.setAdapter(mAdapter);
                }else if (position==2){
                    mAdapter = new ProductAdapter(getApplicationContext(),productListClothes);
                    listView.setAdapter(mAdapter);
                }else if (position==3){
                    mAdapter = new ProductAdapter(getApplicationContext(),productListCosmetics);
                    listView.setAdapter(mAdapter);
                }else if (position==4){
                    mAdapter = new ProductAdapter(getApplicationContext(),productListSports);
                    listView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mAdapter = new ProductAdapter(getApplicationContext(), productList);
                listView.setAdapter(mAdapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Product product = productList.get(i);

                Intent intent = new Intent(MainActivity.this,ProductDetailsActivity.class);
                intent.putExtra(ProductCredentials.imageKye,product.getProductImage());
                intent.putExtra(ProductCredentials.titleKey,product.getTitle());
                intent.putExtra(ProductCredentials.descriptionKye,product.getDescription());
                intent.putExtra(ProductCredentials.priceKey,product.getPrice());

                startActivity(intent);
            }
        });

    }
    public void showCartText(){
        Cursor cursor = databaseManager.getCartData();
        // StringBuilder stringBuilder = new StringBuilder();
        if (cursor.moveToFirst()){
            String result = String.valueOf(cursor.getInt(cursor.getColumnIndex("totalQtt")));
            cartTV.setText(result);
        }
    }
    public void cartIntent(View view){
        if (cartTV.getText().toString().equals("0")){
            Toast.makeText(this, "No item added to cart yet!", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this,CartDetailsActivity.class);
            startActivity(intent);
        }
    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
