package com.example.loginpj;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private ImageButton btnCart;
    private EditText edtSearch;
    private GridView gridViewProducts;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_product_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainProductScroll), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Ánh xạ các thành phần giao diện
        btnCart = findViewById(R.id.btnCart);
        edtSearch = findViewById(R.id.edtSearch);
        gridViewProducts = findViewById(R.id.gridViewProducts);

        // 2. Tiện ích nhanh (AbsoluteLayout items)
        TextView utilCoupon = findViewById(R.id.utilCoupon);
        TextView utilFreeship = findViewById(R.id.utilFreeship);
        TextView utilCoins = findViewById(R.id.utilCoins);

        utilCoupon.setOnClickListener(v -> Toast.makeText(this, "Đã lưu Mã giảm giá 50k!", Toast.LENGTH_SHORT).show());
        utilFreeship.setOnClickListener(v -> Toast.makeText(this, "Đã kích hoạt Freeship!", Toast.LENGTH_SHORT).show());
        utilCoins.setOnClickListener(v -> Toast.makeText(this, "Bạn nhận được 10.000 Xu!", Toast.LENGTH_SHORT).show());

        btnCart.setOnClickListener(v -> Toast.makeText(this, "Mở giỏ hàng của bạn", Toast.LENGTH_SHORT).show());

        // 3. Khởi tạo danh sách sản phẩm mẫu cho GridView (2 cột)
        initProductList();

        // 4. Gắn Adapter vào GridView
        adapter = new ProductAdapter(this, productList);
        gridViewProducts.setAdapter(adapter);

        // Bắt sự kiện click vào 1 sản phẩm trong GridView
        gridViewProducts.setOnItemClickListener((parent, view, position, id) -> {
            Product selected = productList.get(position);
            Toast.makeText(this, "Chi tiết: " + selected.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    private void initProductList() {
        productList = new ArrayList<>();
        productList.add(new Product("iPhone 15 Pro Max 256GB", "29.490.000đ", "⭐ 4.9 • Đã bán 1.2k", "Chính hãng", android.R.drawable.ic_menu_call));
        productList.add(new Product("Samsung Galaxy S24 Ultra", "26.990.000đ", "⭐ 4.8 • Đã bán 850", "Giảm 15%", android.R.drawable.ic_menu_camera));
        productList.add(new Product("MacBook Air M2 8GB 256GB", "23.890.000đ", "⭐ 4.9 • Đã bán 420", "Hot Sale", android.R.drawable.ic_menu_gallery));
        productList.add(new Product("Tai nghe AirPods Pro 2", "5.390.000đ", "⭐ 5.0 • Đã bán 2.4k", "Freeship", android.R.drawable.ic_menu_compass));
        productList.add(new Product("iPad Air 5 64GB WiFi", "14.290.000đ", "⭐ 4.8 • Đã bán 630", "Bán chạy", android.R.drawable.ic_menu_agenda));
        productList.add(new Product("Đồng hồ Apple Watch S9", "9.790.000đ", "⭐ 4.9 • Đã bán 310", "Mới ra mắt", android.R.drawable.ic_menu_recent_history));
    }
}
