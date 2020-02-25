package org.flepper.convexhull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private IconsAdapter iconsAdapter;
    private List<IconData> icondatalist = new ArrayList<IconData>();
    @TargetApi(Build.VERSION_CODES.O)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        iconsAdapter = new IconsAdapter(icondatalist);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new ItemOffsetDecoration(this));
        recyclerView.setAdapter(iconsAdapter);
        iconDataPrepare();
    }

    private void iconDataPrepare() {

        for(int i = 1; i <= 40; i++){
            String str1 = Integer.toString(i);

            IconData data = new IconData(str1);
            icondatalist.add(data);
        }
       /* data = new IconData("sai");
        icondatalist.add(data);
        data = new IconData("sd");
        icondatalist.add(data);
        data = new IconData("sd");
        icondatalist.add(data);
        data = new IconData("df");
        icondatalist.add(data);
        data = new IconData("sauki");
        icondatalist.add(data);
        data = new IconData("sfgfgai");
        icondatalist.add(data);
        data = new IconData("fsai");
        icondatalist.add(data);
        data = new IconData("safgi");
        icondatalist.add(data);
*/
    }

    private static final class ItemOffsetDecoration extends RecyclerView.ItemDecoration{

        private static int spacing = 4;

        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkParameterIsNotNull(outRect, "outRect");
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            Intrinsics.checkParameterIsNotNull(state, "state");
            outRect.set(spacing, spacing, spacing, spacing);
        }

        public ItemOffsetDecoration(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
        }

    }
}
