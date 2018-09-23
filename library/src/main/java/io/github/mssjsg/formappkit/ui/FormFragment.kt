package io.github.mssjsg.formappkit.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mssjsg.formappkit.FormAppKit
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.model.FormElementPath
import io.github.mssjsg.formappkit.model.FormSession
import io.github.mssjsg.formappkit.model.dataPathOf
import io.github.mssjsg.formappkit.ui.recyclerview.FormAdapter
import io.github.mssjsg.formappkit.ui.recyclerview.SimpleFormAdapter

class FormFragment: Fragment() {

    companion object {
        private const val ARG_FORM_PATH = "ARG_FORM_PATH"
        private const val ARG_SESSION_ID = "ARG_FORM_SESSION_ID"

        fun newInstance(formId: String): FormFragment {
            return FormFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FORM_PATH, formId)
                }
            }
        }
    }

    private lateinit var adapter: FormAdapter
    private lateinit var formPath: FormElementPath

    private lateinit var session: FormSession
    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val formAppManager = FormAppKit.getDefaultFormAppManager()
        session = arguments?.getString(ARG_SESSION_ID, null)
                ?.let { formAppManager.getSession(it) }
                ?: formAppManager.getAnonymousSession()

        formPath = dataPathOf(arguments?.getString(ARG_FORM_PATH) ?: throw IllegalArgumentException("missing formId"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SimpleFormAdapter()
        adapter.addFormItems(session.formElementGroup?.toFormItems() ?: emptyList())

        list = view.findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(view.context).apply { orientation = LinearLayoutManager.VERTICAL }
        list.adapter = adapter
    }
}