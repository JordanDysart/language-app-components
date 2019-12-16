package com.jordandysart.languageappexample;

import android.os.Bundle;

import com.jordandysart.languageappcomponents.MainLanguageActivity;
import com.jordandysart.languageappcomponents.fragment.CategoryFragment;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends MainLanguageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CategoryFragment.newInstance(2,
                            createDummyStringData(), createDummyAudioData()))
                    .commitNow();
        }
    }



    private String[] createDummyStringData() {
        String[] dummy = new String[25];
        for (int i = 0; i < 25; i++) {
            dummy[i] = "Dummy data: " + i;
        }
        return dummy;
    }

    private ArrayList<Integer> createDummyAudioData() {
        Integer[] audioFiles =  {
                R.raw.yah_tsi_naindalh_go_home_jw,
                R.raw.whutsan_ilujut_i_am_brave,
                R.raw.whutsun_hasya_i_am_coming_from_at,
                R.raw.whutude_tsi_doten_it_is_becoming_gloomy,
                R.raw.whuzkuz_be_wheni_sooduja_he_she_is_bundled_up,
                R.raw.wuzinli_dzen_tsi_hoonti_happy_birthday,
                R.raw.ya_nagha_too_apple_juice,
                R.raw.yabamusduscho,
                R.raw.yah_tsi_naindalh_go_home,
                R.raw.yah_usda_i_am_inside_of,
                R.raw.yah_usda_i_am_inside_of_st,
                R.raw.yanaghoo_apple,
                R.raw.yasat_daughter_i_law_tb,
                R.raw.yasat_daughterinlaw,
                R.raw.yatoobeskum,
                R.raw.yeste_nezdus_to_twist_body_parts,
                R.raw.yestse_tsun_deer_meat,
                R.raw.yestse_tu_na_sgus_i_am_washing_my_body,
                R.raw.yeztli,
                R.raw.yilhchoot_you_get_him_her_jww,
                R.raw.yilhchoot_you_get_him_her,
                R.raw.yilhchoot_you_get_him_jw,
                R.raw.yus,
                R.raw.zaz_father_in_law_tb,
                R.raw.zaz_fatherinlaw

        };
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Collections.addAll(integerArrayList,audioFiles);

        return integerArrayList;
    }
}
