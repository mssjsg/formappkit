package io.github.mssjsg.formappkit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.singmak.formappkit.R
import io.github.mssjsg.formappkit.model.element.CheckBox
import io.github.mssjsg.formappkit.model.element.Title
import io.github.mssjsg.formappkit.model.element.TextInputField
import io.github.mssjsg.formappkit.model.formOf
import io.github.mssjsg.formappkit.ui.FormFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val FORM_PERSONAL_DETAILS = "FORM_PERSONAL_DETAILS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FormAppKit.getDefaultFormAppManager().forms.put(FORM_PERSONAL_DETAILS,
                formOf(
                        Title("Who are you?"),
                        TextInputField("name", TextInputField.Meta(true, "Your Name")),
                        Title("Are you a Jedi?"),
                        CheckBox("name", CheckBox.Meta(true, "Yes"))
                ))

        supportFragmentManager.beginTransaction()
                .add(R.id.main, FormFragment.newInstance(FORM_PERSONAL_DETAILS), "form")
                .commit()
    }
}
