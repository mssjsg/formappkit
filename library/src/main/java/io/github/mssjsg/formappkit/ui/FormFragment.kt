package io.github.mssjsg.formappkit.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mssjsg.formappkit.FormAppKit
import io.github.mssjsg.formappkit.FormAppManager
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.ui.recyclerview.FormAdapter
import kotlinx.android.synthetic.main.layout_form.*

class FormFragment: Fragment() {

    companion object {
        private const val ARG_FORM_ID = "ARG_FORM_ID"

        fun newInstance(formId: String): FormFragment {
            return FormFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FORM_ID, formId)
                }
            }
        }
    }

    private lateinit var adapter: FormAdapter
    private lateinit var formId: String
    private lateinit var form: Form

    private lateinit var formAppManager: FormAppManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        formAppManager = FormAppKit.getDefaultFormAppManager()

        formId = arguments?.getString(ARG_FORM_ID) ?: throw IllegalArgumentException("missing formId")
        form = formAppManager.forms.get(formId) ?: Form(emptyList())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FormAdapter(formAppManager.formDataManager, formId, form)
        list.layoutManager = LinearLayoutManager(view.context).apply { orientation = LinearLayoutManager.VERTICAL }
        list.adapter = adapter
    }
}