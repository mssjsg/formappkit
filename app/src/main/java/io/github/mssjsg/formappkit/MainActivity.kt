package io.github.mssjsg.formappkit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.singmak.formappkit.R
import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.model.element.FieldTitle
import io.github.mssjsg.formappkit.model.formOf
import io.github.mssjsg.formappkit.ui.FormFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val FORM_PERSONAL_DETAILS = "FORM_PERSONAL_DETAILS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FormAppManager.forms.put(FORM_PERSONAL_DETAILS,
                formOf(
                        FieldTitle("Who are you?"),
                        FieldTitle("Are you a Jedi?")
                ))

        supportFragmentManager.beginTransaction()
                .add(R.id.main, FormFragment.newInstance(FORM_PERSONAL_DETAILS), "form")
                .commit()
    }
}
