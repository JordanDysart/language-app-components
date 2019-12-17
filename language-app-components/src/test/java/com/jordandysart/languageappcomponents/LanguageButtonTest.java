package com.jordandysart.languageappcomponents;

import com.jordandysart.languageappcomponents.button.LanguageButton;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LanguageButtonTest {

    private LanguageButton languageButtonTestObject;

    @Before
    public void createInstance() {
        languageButtonTestObject = new LanguageButton();
    }



    @Test
    public void emptyconstructor_returnsnull(){
        assertNull(languageButtonTestObject.getAudioPath() );
        assertNull(languageButtonTestObject.getPrimaryText());
        assertNull(languageButtonTestObject.getSecondaryText());
    }

    @Test
    public void emptyconstructor_canhavevaluesset_andreturnvalues(){
        languageButtonTestObject.setAudioPath(R.raw.testfile);
        assertThat(languageButtonTestObject.getAudioPath(), is(R.raw.testfile));
        languageButtonTestObject.setPrimaryText("foo");
        assertThat(languageButtonTestObject.getPrimaryText(), is("foo"));
        languageButtonTestObject.setSecondaryText("bar");
        assertThat(languageButtonTestObject.getSecondaryText(), is("bar"));
    }


}
