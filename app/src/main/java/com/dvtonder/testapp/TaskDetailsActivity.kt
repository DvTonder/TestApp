/*
 * Copyright (C) 2018 David van Tonder
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dvtonder.testapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import kotlinx.android.synthetic.main.task_activity.*

class TaskDetailsActivity : DialogActivity(), OnClickListener {

    private var mContext: Context? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        // Get the widget id that called for the forecast
        mContext = baseContext

        // Apply the appropriate theme to the popup
        // Enforce Pro check for all but the Weather Extension
        applyTheme(MainActivity.isDarkMode)

        super.onCreate(savedInstanceState)

        updateTaskPanel()
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        finish()
    }

    @SuppressLint("NewApi")
    private fun updateTaskPanel() {
        // Load the appropriate base view
        val inflater = LayoutInflater.from(ContextThemeWrapper(this,
                if (isUsingLightTheme) R.style.DialogActivity_Light else R.style.DialogActivity))

        @SuppressLint("InflateParams")
        val view = inflater.inflate(R.layout.task_activity, null)

        // Set the view as the dialog's content view
        setContentView(view)

        // We can safely suppress the New API check since this is wrapped in a version check
        view.requestApplyInsets()

        task_notes_layout.visibility = View.VISIBLE

        if (!MainActivity.isNewTask) {
            // Load the Title and Notes for existing tasks
            task_title.setText("My title")
            task_notes.setText("My notes text")

            // Cancel button is not initially a valid button for existing tasks and should only
            // show if the user changes an aspect of the task
            button_cancel.isEnabled = false
            button_done.isEnabled = true

            // The move button is a valid button for existing tasks
            button_move.isEnabled = false

        } else {
            // Hide buttons not valid for new task creation
            button_delete.isEnabled = false
            button_move.isEnabled = false
            button_done.isEnabled = true
        }

        // Set the change listeners on the appropriate items
        button_cancel.setOnClickListener(this)
        button_done.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_cancel ->
                // Just a normal exit
                finish()

            R.id.button_done ->
                // Just a normal exit
                finish()

            else ->
                // Just a normal exit
                finish()
        }
    }
}
