package io.github.mssjsg.formappkit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.singmak.formappkit.R
import io.github.mssjsg.formappkit.model.*
import io.github.mssjsg.formappkit.ui.FormFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val FORM_PERSONAL_DETAILS = "FORM_PERSONAL_DETAILS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = FormElementPath(listOf("full"))

        FormAppKit.getDefaultFormAppManager().getAnonymousSession().apply {
            formElementGroup = FormElementGroup(root, "full application").apply {
                elements.addAll(listOf(
                        FormTitle(root.append("header"), "Personal details"),
                        FormEditText(root.append("name"), "Who are you?", "Your Name"),
                        FormTitle(root.append("jedi"), "Jedi"),
                        FormCheckBox(root.append("jedi"), "Are you a jedi?")
                ))
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.main, FormFragment.newInstance(FORM_PERSONAL_DETAILS), "formView")
                    .commit()
        }
    }
}
