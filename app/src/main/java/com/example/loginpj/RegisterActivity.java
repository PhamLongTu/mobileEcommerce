package com.example.loginpj;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout tilFullName, tilEmailRegister, tilPhone, tilPasswordRegister, tilConfirmPassword;
    private TextInputEditText edtFullName, edtEmailRegister, edtPhone, edtPasswordRegister, edtConfirmPassword;
    private MaterialCheckBox cbTerms;
    private MaterialButton btnRegister;
    private ImageButton btnBack;
    private TextView tvGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRegister), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Ánh xạ View từ XML
        btnBack = findViewById(R.id.btnBack);
        tilFullName = findViewById(R.id.tilFullName);
        tilEmailRegister = findViewById(R.id.tilEmailRegister);
        tilPhone = findViewById(R.id.tilPhone);
        tilPasswordRegister = findViewById(R.id.tilPasswordRegister);
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);

        edtFullName = findViewById(R.id.edtFullName);
        edtEmailRegister = findViewById(R.id.edtEmailRegister);
        edtPhone = findViewById(R.id.edtPhone);
        edtPasswordRegister = findViewById(R.id.edtPasswordRegister);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);

        cbTerms = findViewById(R.id.cbTerms);
        btnRegister = findViewById(R.id.btnRegister);
        tvGoToLogin = findViewById(R.id.tvGoToLogin);

        // 2. Nút Quay lại & "Đăng nhập" -> đóng trang Register để về Login
        btnBack.setOnClickListener(v -> finish());
        tvGoToLogin.setOnClickListener(v -> finish());

        // 3. Xử lý nút Đăng ký
        btnRegister.setOnClickListener(v -> handleRegister());
    }

    private void handleRegister() {
        String fullName = getText(edtFullName);
        String email = getText(edtEmailRegister);
        String phone = getText(edtPhone);
        String password = getText(edtPasswordRegister);
        String confirmPassword = getText(edtConfirmPassword);

        if (fullName.isEmpty()) {
            tilFullName.setError("Vui lòng nhập họ và tên");
            return;
        } else {
            tilFullName.setError(null);
        }

        if (email.isEmpty()) {
            tilEmailRegister.setError("Vui lòng nhập Email");
            return;
        } else {
            tilEmailRegister.setError(null);
        }

        if (phone.isEmpty()) {
            tilPhone.setError("Vui lòng nhập số điện thoại");
            return;
        } else {
            tilPhone.setError(null);
        }

        if (password.length() < 6) {
            tilPasswordRegister.setError("Mật khẩu phải từ 6 ký tự trở lên");
            return;
        } else {
            tilPasswordRegister.setError(null);
        }

        if (!confirmPassword.equals(password)) {
            tilConfirmPassword.setError("Mật khẩu xác nhận không khớp");
            return;
        } else {
            tilConfirmPassword.setError(null);
        }

        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Vui lòng đồng ý với Điều khoản & Chính sách", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Đăng ký thành công tài khoản: " + email, Toast.LENGTH_SHORT).show();
        finish();
    }

    private String getText(TextInputEditText editText) {
        return editText.getText() != null ? editText.getText().toString().trim() : "";
    }
}
