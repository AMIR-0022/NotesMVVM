package com.amar.notesmvvm

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.amar.notesmvvm.Models.DataEntity
import java.util.Date

class AddEditActivity : AppCompatActivity() {

    private lateinit var etPoetTitle: EditText;
    private lateinit var etPoetMessage: EditText;

    private lateinit var currentPoet: DataEntity;
    private lateinit var updatedPoet: DataEntity;

    private var isUpdate: Boolean = false;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)

        etPoetTitle = findViewById(R.id.etPoetTitle);
        etPoetMessage = findViewById(R.id.etPoetMessage);

        // set custom tool bar
        val toolBar: Toolbar = findViewById(R.id.addEditToolBar);
        setSupportActionBar(toolBar);
        if (supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        }

        // get data from intent
        try {
            currentPoet = intent.getSerializableExtra("CurrentPoet") as DataEntity;
            etPoetTitle.setText(currentPoet.title);
            etPoetMessage.setText(currentPoet.message);
            isUpdate = true;

            Toast.makeText(this, ""+currentPoet.id, Toast.LENGTH_SHORT).show()
        } catch (ex: Exception){
            ex.printStackTrace();
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressedDispatcher.onBackPressed();
        } else if (item.itemId == R.id.opt_save){
            val title: String = etPoetTitle.text.toString();
            val message: String = etPoetMessage.text.toString();

            val formatter: String = "EEE, d MMM yyyy HH:mm:ss";

            if (title.isNotEmpty() && message.isNotEmpty()){
                if (isUpdate){
                    updatedPoet = DataEntity(currentPoet.id, currentPoet.date, title, message);
                } else {
                    updatedPoet = DataEntity(null, Date(), title, message);
                }

                val intent: Intent = Intent();
                intent.putExtra("Poet", updatedPoet);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(this, "Enter valid Inputs", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}