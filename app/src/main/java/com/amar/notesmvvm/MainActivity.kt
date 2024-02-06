package com.amar.notesmvvm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amar.notesmvvm.Adapters.PoetAdapter
import com.amar.notesmvvm.Models.DataEntity
import com.amar.notesmvvm.ViewModel.MyViewModel

class MainActivity : AppCompatActivity(), PoetAdapter.NotesItemClickListener {

    private lateinit var rvMainRecycler : RecyclerView;
    private lateinit var btnFloatingAdd : ImageButton;
    private lateinit var poetList: ArrayList<DataEntity>;
    private lateinit var poetAdapter: PoetAdapter;

    private lateinit var viewModel: MyViewModel;

    private val registerActivityForInsert = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val poet = result.data?.getSerializableExtra("Poet") as? DataEntity;
            if (poet != null){
                viewModel.insertPoet(poet);
            }
        }
    }

    private val registerActivityForUpdate = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val poet = result.data?.getSerializableExtra("Poet") as? DataEntity;
            if (poet != null){
                viewModel.updatePoet(poet);
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMainRecycler = findViewById(R.id.mainRecyclerView);
        btnFloatingAdd = findViewById(R.id.btnFloatingAdd);

        poetList = ArrayList();
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[MyViewModel::class.java];

        viewModel.allPoet.observe(this) { list ->
            poetAdapter.updateAdapterList(list as ArrayList<DataEntity>);
        }

        poetAdapter = PoetAdapter(this, poetList, this);

        rvMainRecycler.adapter = poetAdapter;
        rvMainRecycler.layoutManager = LinearLayoutManager(this);

        btnFloatingAdd.setOnClickListener {
            val intent: Intent = Intent(this, AddEditActivity::class.java);
            registerActivityForInsert.launch(intent)
        }

    }

    override fun onEditButtonClicked(dataEntity: DataEntity, view: View) {
        val intent: Intent = Intent(this, AddEditActivity::class.java);
        intent.putExtra("CurrentPoet", dataEntity)
        registerActivityForUpdate.launch(intent);
    }

    override fun onDeleteButtonClicked(dataEntity: DataEntity, view: View) {
        viewModel.deletePoet(dataEntity);
    }

}