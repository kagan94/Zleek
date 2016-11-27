package com.example.manish.zleek;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by manish on 11/27/2016.
 */
//it was late, dont judge the naming
public class ImageKindaView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

            ImageView previewThumbnail = (ImageView) findViewById(R.id.imageView4);
            Bitmap bitmap = getIntent().getParcelableExtra("bitmap");
            previewThumbnail.setImageBitmap(bitmap);

    }

    String selectedStyle = "Formal";

    public StyleController getSuggestion(StyleController user_garment, String suggest_what){
        // By selected garment we choose which color of product should we show
        StyleController suggested_item = new StyleController(suggest_what);
        suggested_item.setSelectedGarment(user_garment.getSelectedGarment());

        StyleController jacket = new StyleController("jacket");
        StyleController pants = new StyleController("pants");
        StyleController shirt = new StyleController("shirt");
        StyleController shoes = new StyleController("shoes");
        StyleController assecoires = new StyleController("assecoires");


        switch(selectedStyle) {
            case "formal":
                if(user_garment.getSelectedGarment() == "pant")
                {
                    jacket.setColor(user_garment.getColor());
                }
                else if(user_garment.getSelectedGarment() == "jacket") {
                    pants.setColor(user_garment.getColor());
                }
                shirt.setColor(getAnalogColor(user_garment.getColor()));
                shoes.setColor(getAnalogColor(user_garment.getColor()));
                assecoires.setColor(getComplementaryColor(user_garment.getColor()));
                break;
            case "fashion": //fashion hipster
                if(user_garment.getSelectedGarment() == "pant")
                {
                    jacket.setColor(getComplementaryColor(user_garment.getColor()));
                }
                pants.setColor(getComplementaryColor(user_garment.getColor()));
                shirt.setColor(getSplitComplementaryColor(user_garment.getColor(), 1));
                shoes.setColor(getComplementaryColor(user_garment.getColor()));
                assecoires.setColor(getSplitComplementaryColor(user_garment.getColor(),2));
                break;
            case "street-wear": // hip-hop (possible vatiance of colors: triodic, neutral, or random warm color)
                // choose random color
                int random_style = getRandomInt(1, 3);

                switch(random_style)
                {
                    case 1:
                        suggested_item.setColor(getTridiacColor(user_garment.getColor()));
                        break;

                    case 2:
                        suggested_item.setColor(getNeutralColor(user_garment.getColor()));
                        break;

                    case 3:
                        suggested_item.setColor(getRandomWarmColor(user_garment.getColor()));
                        break;
                }
                break;
            case "adventures": // Can set only warm color
                suggested_item.setColor(getRandomWarmColor(user_garment.getColor()));
                break;
        }

        return suggested_item;
    }

    public String getAnalogColor(String color){
        // request to get analog color
        return "ananalogcolor";
    }

    public String getComplementaryColor(String color){
        // request to get comlementary color
        return "complementcolor";
    }

    public String getSplitComplementaryColor(String color, int colorPointer){
        // request to get split-comlementary color
        return "splitcomplementarycolor";
    }

    public String getTridiacColor(String color){
        // request to get tridiac color
        return "tridiaccolor";
    }

    public String getNeutralColor(String color){
        // request to get neutral color
        return "neutralcolor";
    }

    public String getRandomWarmColor(String color){
        // request to get warm color
        String warm_colors[] = {"Brown", "Gray"};
        String rand_warm_color = warm_colors[getRandomInt(0, warm_colors.length)];

        return rand_warm_color;
    }

    // Generate random INTs in some range
    private static int getRandomInt(int aStart, int aEnd){
        Random aRandom = new Random();
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber =  (int)(fraction + aStart);
        System.out.println("Generated : " + randomNumber);

        return randomNumber;
    }

}
