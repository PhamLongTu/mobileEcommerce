package com.example.loginpj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilEmailLogin, tilPasswordLogin;
    private TextInputEditText edtEmailLogin, edtPasswordLogin;
    private MaterialButton btnLogin, btnGoogleSignIn;
    private TextView tvForgotPassword, tvGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Ánh xạ View từ XML
        tilEmailLogin = findViewById(R.id.tilEmailLogin);
        tilPasswordLogin = findViewById(R.id.tilPasswordLogin);
        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogleSignIn = findViewById(R.id.btnGoogleSignIn);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvGoToRegister = findViewById(R.id.tvGoToRegister);

        // 2. Xử lý nút Đăng nhập
        btnLogin.setOnClickListener(v -> {
            String email = edtEmailLogin.getText() != null ? edtEmailLogin.getText().toString().trim() : "";
            String password = edtPasswordLogin.getText() != null ? edtPasswordLogin.getText().toString().trim() : "";

            if (email.isEmpty()) {
                tilEmailLogin.setError("Vui lòng nhập Email");
                return;
            } else {
                tilEmailLogin.setError(null);
            }

            if (password.isEmpty()) {
                tilPasswordLogin.setError("Vui lòng nhập Mật khẩu");
                return;
            } else {
                tilPasswordLogin.setError(null);
            }

            Toast.makeText(this, "Đăng nhập thành công: " + email, Toast.LENGTH_SHORT).show();

            // Chuyển sang màn hình danh sách sản phẩm (ProductActivity)
            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
            startActivity(intent);
        });

        // 3. Chuyển sang trang Đăng ký
        tvGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // 4. Các nút phụ
        tvForgotPassword.setOnClickListener(v ->
                Toast.makeText(this, "Chức năng quên mật khẩu", Toast.LENGTH_SHORT).show()
        );

        btnGoogleSignIn.setOnClickListener(v ->
                Toast.makeText(this, "Đăng nhập bằng Google", Toast.LENGTH_SHORT).show()
        );
    }
}
