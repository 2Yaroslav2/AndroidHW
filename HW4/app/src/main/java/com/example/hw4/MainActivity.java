package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hw4.dummy.DummyContent;
import com.example.hw4.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ItemFragment.OnItemsFragmentListener,
                   ViewProductFragment.OnInfoFragmentListener,
                   CreateProductFragment.OnAddFragmentListener {

    static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("https://pngicon.ru/file/uploads/voda.png",
                "product 1",
                10,
                "available"));

        products.add(new Product("https://img.freepik.com/free-vector/powder-holi-paints-frame-border-solated_1441-3793.jpg?size=626&ext=jpg&ga=GA1.2.485545868.1621641600",
                "product 2",
                5,
                "available"));

        products.add(new Product("https://purepng.com/public/uploads/large/purepng.com-sandwichfood-slice-salad-tasty-bread-vegetable-health-delicious-breakfast-sandwich-9415246181796gyc0.png",
                "product 3",
                3,
                "available"));
    }

    RecyclerView rvProducts;
    ProductAdapter productAdapter;
    Button btnCreateProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //rvProducts = findViewById(R.id.rvProducts);
        btnCreateProduct = findViewById(R.id.btnCreateProduct);

       // productAdapter = new ProductAdapter(this, products);

        //rvProducts.setAdapter(productAdapter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new ItemFragment(), "LIST_TAG")
                .commit();

        btnCreateProduct.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, new CreateProductFragment(), "ADD_TAG")
                    .commit();
            btnCreateProduct.setVisibility(View.INVISIBLE);
        });

    }


    @Override
    public void onItemSelect(DummyContent.DummyItem item) {
        ViewProductFragment viewProductFragment = new ViewProductFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, viewProductFragment, "INFO_TAG")
                .commit();

        viewProductFragment.setData(item);
        btnCreateProduct.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBtnBackClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new ItemFragment(), "LIST_TAG")
                .commit();
        btnCreateProduct.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBtnCreateClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new ItemFragment(), "LIST_TAG")
                .commit();
        btnCreateProduct.setVisibility(View.VISIBLE);
    }
}