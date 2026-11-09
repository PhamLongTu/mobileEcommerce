package com.example.loginpj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private final Context context;
    private final List<Product> productList;
    private final LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productList != null ? productList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView imgProduct;
        TextView tvTag;
        TextView tvProductName;
        TextView tvProductPrice;
        TextView tvProductSold;
        ImageButton btnAddToCart;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_product_grid, parent, false);
            holder = new ViewHolder();
            holder.imgProduct = convertView.findViewById(R.id.imgProduct);
            holder.tvTag = convertView.findViewById(R.id.tvTag);
            holder.tvProductName = convertView.findViewById(R.id.tvProductName);
            holder.tvProductPrice = convertView.findViewById(R.id.tvProductPrice);
            holder.tvProductSold = convertView.findViewById(R.id.tvProductSold);
            holder.btnAddToCart = convertView.findViewById(R.id.btnAddToCart);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = productList.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice());
        holder.tvProductSold.setText(product.getSoldInfo());
        holder.tvTag.setText(product.getTag());
        holder.imgProduct.setImageResource(product.getImageResId());

        holder.btnAddToCart.setOnClickListener(v ->
                Toast.makeText(context, "Đã thêm vào giỏ: " + product.getName(), Toast.LENGTH_SHORT).show()
        );

        return convertView;
    }
}
